package com.dxc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.dao.ClaimDAO;
import com.dxc.model.Claim;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClaimDAO claimDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");

		claimDAO = new ClaimDAO(jdbcURL, jdbcUsername, jdbcPassword);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String action = request.getServletPath();
		try {
			saveClaim(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private void saveClaim(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException, ServletException {
		response.setContentType("text/html");
		String prevClaimNo = claimDAO.getPreviousClaimID();
		String claimNo = generateClaimNo(prevClaimNo);
		String policyNo = request.getParameter("policyNo");

//        Check policy exist
		Boolean checkPolicyNo = claimDAO.checkPolicyNumberExist(policyNo);
		if (!checkPolicyNo) {
			PrintWriter out = response.getWriter();
			out.print("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
					+ "  Policy does not exist.\r\n" + "</div>");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		} else {
//        	Check policy in force
			Boolean checkInForce = claimDAO.checkPolicyInForce(policyNo);
			if (!checkInForce) {
				PrintWriter out = response.getWriter();
				out.print("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
						+ "  Policy not in force.\r\n" + "</div>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			} else {
				String dateOcc = request.getParameter("dateOccurred");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date dateOccurred = sdf.parse(dateOcc);
				java.sql.Date sqlDateOcc = new java.sql.Date(dateOccurred.getTime());
//                Check date occurred on policy period
				Boolean checkDate = claimDAO.checkDateOnFallsInPolicyPeriod(dateOccurred, policyNo);
				if (!checkDate) {
					PrintWriter out = response.getWriter();
					out.print("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
							+ "  Date does not falls in policy period.\r\n" + "</div>");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.include(request, response);
				} else {
					String reserveCurrency = request.getParameter("reserveCurrency");
					String reserveAmount = request.getParameter("reserveAmount");
//                    Compare reserve amount with sum insured
					String compare = claimDAO.compareReserveAmountWithSumInsured(reserveAmount, reserveCurrency,
							policyNo);
					
					if (compare.equals("0")) {
						PrintWriter out = response.getWriter();
						out.print("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
								+ "  Reverse amount must not be greater\r\n" + "than Sum Insured.\r\n" + "</div>");
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
					} 
					else if (compare.equals("1")) {
//						String action = request.getParameter("action");
						String status = null;
						String type = null;
						if (request.getParameter("save") != null) {
							status = "Pending";
							type = "Save";
						} else if (request.getParameter("approve") != null) {
							status = "Active";
							type = "Approve";
						}
					
						Claim newClaim = new Claim(claimNo, policyNo, sqlDateOcc, reserveCurrency, reserveAmount,
								status);
						claimDAO.saveClaim(newClaim);
						PrintWriter out = response.getWriter();
						out.print("<div class=\"alert alert-success text-center\" role=\"alert\">\r\n"
								+ "" + type + " claim successfully.\r\n" + "</div>");
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
					}
					else {
						PrintWriter out = response.getWriter();
						out.print("<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
								+ "  You must choose " + compare + " currency for this Policy.\r\n" + "</div>");
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.include(request, response);
					}

				}

			}

		}

	}

	private String generateClaimNo(String prevClaimNo) {
		if (prevClaimNo == null) {
			return "CL000001";
		} else {
			Integer num = Integer.parseInt(prevClaimNo.substring(2)) + 1;
			String newNum = "00000" + num.toString();
			String newClaimNo = "CL" + newNum.substring(newNum.length() - 6);
			return newClaimNo;
		}
	}
}