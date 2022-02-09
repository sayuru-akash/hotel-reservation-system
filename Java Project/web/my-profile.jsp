<%-- 
    Document   : my-profile
    Created on : Jan 13, 2022, 2:41:30 AM
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
        <title>My Profile</title>
        <meta content="My Profile" property="og:title" />
        <meta content="My Profile" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <link rel="stylesheet" href="css/main.css" media="all" />
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
            <h1 class="heading">MY&nbsp;Profile</h1>
        </div>
        <div class="section-13 wf-section">
            <h1 class="heading-12">My Details</h1>
            <p class="paragraph-4">
                Name:&nbsp;<% out.println(request.getAttribute("fname")); %> <% out.println(request.getAttribute("lname")); %><br />Email: <% out.println(request.getAttribute("email")); %><br />Mobile No:
                <% out.println(request.getAttribute("mobile")); %><br />‍
            </p>
            <h1 class="heading-12">My Recent Bookings</h1>
        </div>
        <div class="section-12 wf-section">
            <div class="div-block-47">
                <h4 class="heading-13">No. of Adults: <% out.println(request.getAttribute("adults1")); %></h4>
                <h4 class="heading-13">No. of Children: <% out.println(request.getAttribute("children1")); %></h4>
                <h4 class="heading-13">Check-in Date: <br /><% out.println(request.getAttribute("cidate1")); %></h4>
                <h4 class="heading-13">Check-out Date: <br /><% out.println(request.getAttribute("codate1")); %></h4>
            </div>
            <div class="div-block-47">
                <h4 class="heading-13">No. of Adults: <% out.println(request.getAttribute("adults2")); %></h4>
                <h4 class="heading-13">No. of Children: <% out.println(request.getAttribute("children2")); %></h4>
                <h4 class="heading-13">Check-in Date: <br /><% out.println(request.getAttribute("cidate2")); %></h4>
                <h4 class="heading-13">Check-out Date: <br /><% out.println(request.getAttribute("codate2")); %></h4>
            </div>
            <div class="div-block-47">
                <h4 class="heading-13">No. of Adults: <% out.println(request.getAttribute("adults3")); %></h4>
                <h4 class="heading-13">No. of Children: <% out.println(request.getAttribute("children3")); %></h4>
                <h4 class="heading-13">Check-in Date: <br /><% out.println(request.getAttribute("cidate3")); %></h4>
                <h4 class="heading-13">Check-out Date: <br /><% out.println(request.getAttribute("codate3"));%></h4>
            </div>
        </div>
        <a href="sign-out.jsp" ><div><h4 style="text-align: center; color: black; margin-bottom: 100px;">LOG OUT</h4></div></a>
<jsp:include page="footer.jsp" />
        <!--
    <script
      src="My%20Profile_files/jquery-3.js"
      type="text/javascript"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"
    ></script>
    <script src="My%20Profile_files/webflow.js" type="text/javascript"></script>
        !-->
    </body>
</html>
