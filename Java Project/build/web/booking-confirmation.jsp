<%-- 
    Document   : booking-confirmation
    Created on : Jan 9, 2022, 12:21:07 PM
    Author     : sayur
--%>
<%
    session = request.getSession();

    String urole = (String) session.getAttribute("LoggedInRole");

    if ("customer".equals(urole)) {

    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('You are not allowed to access this customer only content!');");
        out.println("location='sign-in.jsp';");
        out.println("</script>");
    }

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
        <style>
            .wf-force-outline-none[tabindex="-1"]:focus {
                outline: none;
            }
        </style>
        <meta charset="utf-8" />
        <title>Confirm Booking</title>
        <meta content="Confirm Booking" property="og:title" />
        <meta content="Confirm Booking" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <link rel="stylesheet" href="css/main.css" media="all" />
        <script src="https://www.paypal.com/sdk/js?client-id=AbdB49QXlBjEzeWDSu1ws2QrNR3FpcpcGPOif2a7XvK6sDKMkD8ijA2q0c5CdI-w2cUHlKTj_LLyn5cu&locale=en_US" data-csp-nonce="xxx"></script>
        <script type="text/javascript">
            WebFont.load({
                google: {
                    families: [
                        "Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic",
                    ],
                },
            });
        </script>
        <script type="text/javascript">
            !(function (o, c) {
                var n = c.documentElement,
                        t = " w-mod-";
                (n.className += t + "js"),
                        ("ontouchstart" in o ||
                                (o.DocumentTouch && c instanceof DocumentTouch)) &&
                        (n.className += t + "touch");
            })(window, document);
        </script>
        <link
            href="#"
            rel="shortcut icon"
            type="image/x-icon"
            />
        <link
            href="#"
            rel="apple-touch-icon"
            />
    </head>
    <body>
        <%    String att = "check";
            if (request.getSession().getAttribute("LoggedInRole") != null) {
                att = (String) request.getSession().getAttribute("LoggedInRole");
        %>
        <%
            }
            if (att.equals("customer")) {
        %>    
        <jsp:include page="user-header.jsp" />
        <%
        } else if (att.equals("admin")) {
        %>        
        <jsp:include page="admin-header.jsp" />
        <%
        } else {
        %> 
        <jsp:include page="common-header.jsp" />
        <%
            }
        %>
        <div class="section-6 wf-section">
            <h1 class="heading">Booking Confirmation</h1>
        </div>
        <div class="w-nav-overlay" data-wf-ignore="" id="w-nav-overlay-0"></div>
    </div>
    <div class="section-10 wf-section">
        <div class="div-block-45">
            <h2 class="heading-10">Customer Information</h2>
            <h4>Name</h4>
            <div class="text-block-10"><% out.println(request.getAttribute("livefname")); %> <% out.println(request.getAttribute("livelname")); %></div>
            <h4>Email</h4>
            <div><% out.println(request.getAttribute("liveemail")); %></div>
            <h4>Contact Number</h4>
            <div><% out.println(request.getAttribute("livemobile")); %></div>
            <h2 class="heading-10">Reservation Information</h2>
            <h4>Adults</h4>
            <div><% out.println(request.getAttribute("liveadults")); %></div>
            <h4>Children</h4>
            <div><% out.println(request.getAttribute("livechildren")); %></div>
            <h4>Check-in Date</h4>
            <div><% out.println(request.getAttribute("livecidate")); %></div>
            <h4>Check-out Date</h4>
            <div><% out.println(request.getAttribute("livecodate")); %></div>
            <h4>No. of Nights</h4>
            <div><% out.println(request.getAttribute("livedays")); %></div>
        </div>
        <div class="div-block-46">
            <h2 class="heading-10">Order Summary</h2>
            <div class="columns-5 w-row">
                <div class="column-4 w-col w-col-6">
                    <h4 class="heading-11">Subtotal</h4>
                    <h4 class="heading-11">Service Charge (10%)</h4>
                    <h4 class="heading-11">Total</h4>
                </div>
                <div class="w-col w-col-6">
                    <div class="text-block-11"><% out.println(request.getAttribute("subtotal")); %></div>
                    <div class="text-block-11"><% out.println(request.getAttribute("scharge")); %></div>
                    <div class="text-block-11"><% out.println(request.getAttribute("total"));%></div>
                </div>
            </div>
                <div id="paypal-button-container"></div>
<!--            <a href="#" class="button-5 w-button">Pay with Paypal</a>-->
            <div class="text-block-14">OR</div>
            <a href="ConfirmBooking" class="button-4 w-button">Offline Payment</a>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
    <script>
  paypal.Buttons({
  createOrder: function(data, actions) {
    // This function sets up the details of the transaction, including the amount and line item details.
    return actions.order.create({
      purchase_units: [{
        amount: {
          value: <% out.println(request.getAttribute("total"));%>
        }
      }]
    });
  },
  onApprove: function(data, actions) {
    // This function captures the funds from the transaction.
    return actions.order.capture().then(function(details) {
      // This function shows a transaction success message to your buyer.
      alert('Transaction completed by ' + details.payer.name.given_name + 'and Reservation Success!');
      window.location.href = "ConfirmPPBooking";
    });
  },
  onCancel: function (data) {
    // Show a cancel page, or return to cart
    alert('Transaction was declined, Please try again with a different payment method.');
  }
}).render('#paypal-button-container');
//This function displays payment buttons on your web page.
</script>
    <!--
<script
  src="Confirm%20Booking_files/jquery-3.js"
  type="text/javascript"
  integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
  crossorigin="anonymous"
></script>
<script
  src="Confirm%20Booking_files/webflow.js"
  type="text/javascript"
></script>
    !--->
</body>
</html>
