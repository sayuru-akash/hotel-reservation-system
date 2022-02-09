<%-- 
    Document   : about
    Created on : Jan 9, 2022, 1:21:40 AM
    Author     : sayur
--%>

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
    <title>About</title>
    <meta content="About" property="og:title" />
    <meta content="About" property="twitter:title" />
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
        <%
            String att = "check";
            if (request.getSession().getAttribute("LoggedInRole")!=null){
            att = (String)request.getSession().getAttribute("LoggedInRole");
        %>
        <%
            }if (att.equals("customer")) {
        %>    
        <jsp:include page="user-header.jsp" />
        <%
            }else if (att.equals("admin")){
        %>        
        <jsp:include page="admin-header.jsp" />
        <%
            }else{
        %> 
        <jsp:include page="common-header.jsp" />
        <%
            }
        %>
    <div class="section-6 wf-section"><h1 class="heading">About US</h1></div>
    <div class="div-block-43">
      <p class="paragraph-3">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse
        varius enim in eros elementum tristique. Duis cursus, mi quis viverra
        ornare, eros dolor interdum nulla, ut commodo diam libero vitae erat.
        Aenean faucibus nibh et justo cursus id rutrum lorem imperdiet. Nunc ut
        sem vitae risus tristique posuere. Lorem ipsum dolor sit amet,
        consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore
        et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
        exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
        Duis aute irure dolor in reprehenderit in voluptate velit esse cillum
        dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
      </p>
    </div>
    <div class="div-block">
      <h2 class="heading-9">Why Choose Us?</h2>
      <div
        style="padding-top: 56.17021276595745%"
        class="w-embed-youtubevideo youtube"
      >
        <iframe
          src="https://youtu.be/O6bG5bdurRY"
          style="
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            pointer-events: auto;
          "
          allow="autoplay; encrypted-media"
          allowfullscreen=""
          title="Cinnamon Grand Colombo - We are waiting for you!"
          frameborder="0"
        ></iframe>
      </div>
    </div>
    <div class="team-simple-section wf-section">
      <div class="centered-container horizontal-flex">
        <h2 class="team-heading">Meet the founders</h2>
        <div class="team-block">
          <img
            src="./images/person-sample.jpg"
            loading="lazy"
            alt=""
            class="team-image-circle"
          />
          <div class="team-content">
            <h3 class="member-name">Joe Smith</h3>
            <p class="member-title">CEO</p>
          </div>
        </div>
        <div class="team-block">
          <img
            src="./images/person-sample-2.jpg"
            loading="lazy"
            alt=""
            class="team-image-circle"
          />
          <div class="team-content">
            <h3 class="member-name">Jane Garcia</h3>
            <p class="member-title">CTO</p>
          </div>
        </div>
        <div class="team-block">
          <img
            src="./images/person-sample.jpg"
            loading="lazy"
            alt=""
            class="team-image-circle"
          />
          <div class="team-content">
            <h3 class="member-name">Charlie Jones</h3>
            <p class="member-title">CFO</p>
          </div>
        </div>
      </div>
    </div>
    <jsp:include page="footer.jsp" />
    <!--
    <script
      src="About_files/jquery-3.js"
      type="text/javascript"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"
    ></script>
    <script src="About_files/webflow.js" type="text/javascript"></script>
    !--->
    </body>
</html>
