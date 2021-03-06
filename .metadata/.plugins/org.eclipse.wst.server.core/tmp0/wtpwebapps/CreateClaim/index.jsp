<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
            <link rel="stylesheet" href="resource/css/css.css">
            <title>Create Claim</title>
        </head>

        <body>
            <nav class="navbar navbar-expand-sm bg-light navbar-light">
                <a class="navbar-brand" href="/CreateClaim">
                    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewBox="0 0 376.5 99.86" style="enable-background: new 0 0 376.5 99.86;" xml:space="preserve" height="77px" width="300px">
     			<path
         			d="M49.87,46.72c0-4.64-3.69-8.3-8.28-8.3h-3.6V55h3.6C46.17,55,49.87,51.34,49.87,46.72 M56.34,49.41l-5.87,10.13h11.7  L56.34,49.41z M56.34,44.02l5.83-10.13h-11.7L56.34,44.02z M62.79,46.72c0,4.62,3.69,8.28,8.28,8.28h3.6V38.41h-3.6  C66.48,38.41,62.79,42.07,62.79,46.72 M330.64,60.21c-1.34,3.39-3.02,5.01-6.84,5.01c-0.9,0-1.62-0.06-2.21-0.16V60.8  c0.53,0.09,1.28,0.19,1.68,0.19c1.28,0,2.08-0.5,2.74-2.08l0.4-1l-6.9-16.14h5.54l4.01,9.92l3.7-9.89h5.23L330.64,60.21   M308.87,53.9c-2.24,0-3.79-1.87-3.79-4.07s1.56-4.11,3.79-4.11c2.33,0,3.89,1.9,3.89,4.11S311.2,53.9,308.87,53.9 M317.86,58.16  V41.77h-5.01v2.36c-0.93-1.71-3.02-2.77-5.07-2.77c-4.7,0-7.81,3.64-7.81,8.46c0,4.79,3.23,8.18,7.87,8.18  c2.08,0,4.07-1.03,4.95-2.49v2.77c0,2.3-1.21,3.58-3.64,3.58c-2.15,0-3.33-1-3.55-2.46h-5.04c0.28,3.58,3.11,6.13,8.46,6.13  C314.96,65.53,317.86,62.85,317.86,58.16 M289.43,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11  c2.3,0,3.83,1.87,3.83,4.11C293.26,52.06,291.73,53.9,289.43,53.9 M289.43,58.28c5.6,0,8.93-3.89,8.93-8.46  c0-4.6-3.33-8.49-8.93-8.49c-5.54,0-8.9,3.89-8.9,8.49C280.53,54.39,283.89,58.28,289.43,58.28 M273.01,57.85h5.07V34.52h-5.07  V57.85z M261.62,53.9c-2.3,0-3.79-1.84-3.79-4.07c0-2.24,1.49-4.11,3.79-4.11c2.3,0,3.83,1.87,3.83,4.11  C265.45,52.06,263.93,53.9,261.62,53.9 M261.62,58.28c5.6,0,8.93-3.89,8.93-8.46c0-4.6-3.33-8.49-8.93-8.49  c-5.54,0-8.9,3.89-8.9,8.49C252.73,54.39,256.09,58.28,261.62,58.28 M234.25,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73  c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25c-2.39,0-4.14,1.06-5.04,2.74v-2.33h-5.01V57.85z   M214.94,57.85h5.07v-8.4c0-2.27,1.06-3.73,3.11-3.73c2.18,0,2.86,1.34,2.86,3.27v8.86h5.07v-9.24c0-4.54-1.99-7.25-6.06-7.25  c-2.36,0-4.07,1.06-4.98,2.74v-9.58h-5.07V57.85z M212.67,47.96c-0.62-3.73-3.39-6.62-8.24-6.62c-5.44,0-8.74,3.89-8.74,8.49  c0,4.57,3.3,8.46,8.74,8.46c4.85,0,7.62-2.89,8.24-6.62h-5.1c-0.44,1.4-1.52,2.33-3.11,2.33c-2.24,0-3.67-1.9-3.67-4.17  s1.43-4.2,3.67-4.2c1.59,0,2.64,0.93,3.08,2.33H212.67z M185.73,44.94c1.93,0,3.17,1.21,3.36,3.11h-6.81  C182.47,46.09,183.84,44.94,185.73,44.94 M193.67,52.96h-4.82c-0.53,0.96-1.46,1.65-3.05,1.65c-2.3,0-3.45-1.46-3.55-3.48h11.69  c0.09-0.75,0.12-1.31,0.12-1.9c0-4.26-2.95-7.9-8.27-7.9c-5.47,0-8.46,3.83-8.46,8.49c0,4.63,3.02,8.46,8.52,8.46  C190.24,58.28,192.86,55.95,193.67,52.96 M164.21,41.77v3.98h2.52v6.53c0,4.42,2.11,5.82,5.94,5.82c1.4,0,2.46-0.12,3.17-0.25v-4.07  c-0.62,0.09-1.56,0.19-2.02,0.19c-1.31,0-2.02-0.44-2.02-2.05v-6.16h3.67v-3.98h-3.67v-4.76h-5.07v4.76H164.21z M157.34,54.89  c0,1.77,1.43,3.23,3.23,3.23c1.84,0,3.23-1.46,3.23-3.23c0-1.77-1.4-3.23-3.23-3.23C158.77,51.66,157.34,53.12,157.34,54.89   M144.93,58.25c6.44,0,9.95-3.86,10.64-8.77h-5.32c-0.5,2.33-2.43,4.07-5.19,4.07c-4.01,0-6.1-3.2-6.1-6.9c0-3.7,2.08-6.9,6.1-6.9  c2.77,0,4.7,1.74,5.19,4.07h5.32c-0.68-4.91-4.2-8.77-10.64-8.77c-7.18,0-11.35,5.47-11.35,11.6S137.75,58.25,144.93,58.25   M127.48,57.85h6.16l-7.25-11.26l7.18-11.13h-6.03l-4.45,7.37l-4.51-7.37h-6.13l7.22,11.13l-7.28,11.26h6l4.57-7.46L127.48,57.85z   M100.77,39.99c4.14,0,6.5,3.23,6.5,6.66c0,3.39-2.36,6.66-6.5,6.66h-2.71V39.99H100.77z M92.8,57.85h8.21  c7.46,0,11.63-5.47,11.63-11.2s-4.2-11.2-11.63-11.2H92.8V57.85z">
     			</path>
     		</svg>
                </a>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/CreateClaim">
             Create Claim
         </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="/CreateClaim">
             About
         </a>
                    </li>
                </ul>
            </nav>



            <div class="container">
                <h5 class="font-weight-bold pt-3">Create Claim</h5>
                <div>
                    <form action="ControllerServlet" class="m-5" method="post">
                        <div class="row">
                            <div class="col">
                                <div class="form-group">
                                    <label for="policyNo">Policy No:</label>
                                    <input type="text" class="form-control" placeholder="Enter Policy No" name="policyNo" maxlength="8" required>
                                </div>

                                <div class="form-group">
                                    <label for="dateOccurred">Date Occurred:</label>
                                    <input type="date" class="form-control" name="dateOccurred" id='txtDate' required>
                                </div>

                                <div class="form-group">
                                    <label for="policyOwner">Policy Owner:</label>
                                    <input type="text" class="form-control" placeholder="Policy Owner" name="policyOwner" disabled>
                                </div>

                                <div class="form-group">
                                    <label for="engineNumber">Engine Number:</label>
                                    <input type="text" class="form-control" placeholder="Engine Number" name="engineNumber" disabled>
                                </div>

                            </div>

                            <div class="col">

                                <div class="form-group">
                                    <label for="chassisNo">Chassis No:</label>
                                    <input type="text" class="form-control" placeholder="Chassis No" name="chassisNo" disabled>
                                </div>

                                <div class="form-group">
                                    <label for="vehicleRegistrationNo">Vehicle Registration No:</label>
                                    <input type="text" class="form-control" placeholder="Vehicle Registration No" name="vehicleRegistrationNo" disabled>
                                </div>

                                <div class="form-group">
                                    <label for="reserveCurrency">Reserve Currency</label>
                                    <select class="form-control" name="reserveCurrency">
                         <option value="VND" selected>VND</option>
                         <option value="USD">USD</option>
                         <option value="SGD">SGD</option>
                       </select>
                                </div>

                                <div class="form-group">
                                    <label for="reserveAmount">Reserve Amount:</label>
                                    <input type="number" step="0.01" min="0" class="form-control" placeholder="Enter Claim No" name="reserveAmount" maxlength="19" required>
                                </div>

                            </div>
                        </div>


                        <div class="float-right">
                            <input type="submit" class="btn btn-success" name="save" value="Save">
                            <input type="submit" class="btn btn-primary" name="approve" value="Approve">
                        </div>

                    </form>
                </div>
            </div>
            <footer class="footer">
                <div class="container">
                    <span class="text-muted">Copyright ?? 2021 DXC Technology</span>
                </div>
            </footer>
            <script>
                $(function() {
                    var dtToday = new Date();

                    var month = dtToday.getMonth() + 1;
                    var day = dtToday.getDate();
                    var year = dtToday.getFullYear();
                    if (month < 10)
                        month = '0' + month.toString();
                    if (day < 10)
                        day = '0' + day.toString();

                    var maxDate = year + '-' + month + '-' + day;

                    $('#txtDate').attr('max', maxDate);
                });
            </script>
        </body>

        </html>