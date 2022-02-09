<%-- 
    Document   : admin-modify-data
    Created on : Jan 18, 2022, 4:23:36 AM
    Author     : sayur
--%>
<%
    session=request.getSession();

    String urole = (String) session.getAttribute("LoggedInRole");
    
    if("admin".equals(urole))
    {
        
    }
    else{
        out.println("<script type=\"text/javascript\">");
        out.println("alert('You are not allowed to access this admin only content!');");
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
    <title>Admin Modify Data</title>
    <meta content="Admin Modify Data" property="og:title" />
    <meta content="Admin Modify Data" property="twitter:title" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link
      rel="stylesheet"
      href="css/main.css"
      media="all"
    />
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
            <div class="section-14 wf-section">
      <img
        src="images/Hotel Rajapaksha Logo 1.png"
        loading="lazy"
        alt="logo"
        class="image-10"
        width="150"
      />
      <h1 class="heading-14">Modify Reservation</h1>
      <form action="SearchUsers" method="post" class="search w-form">
                <input
                    type="search"
                    class="search-input w-input"
                    maxlength="256"
                    name="query"
                    placeholder="Search Users…"
                    id="query"
                    required=""
                    /><input type="submit" value="Find" class="search-button w-button" />
            </form>
    </div>
    <div class="section-16 wf-section">
      <div class="div-block-48">
        <a href="admin-view-res.jsp"><img
          src="images/update.jpg"
          loading="lazy"
          alt=""
          width="50"
        /></a><a href="admin-add-data.jsp">
        <img
          src="images/add.jpg"
          loading="lazy"
          alt=""
          width="50"
          /></a><a href="admin-modify-data.jsp"><img
          src="images/update.jpg"
          loading="lazy"
          alt=""
          width="50"
        /></a><a href="admin-delete-data.jsp"><img
          src="images/remove.jpg"
          loading="lazy"
          alt=""
          width="50"
        /></a><a href="AdminMessages"><img
          src="images/message.jpg"
          loading="lazy"
          alt=""
          width="50"
        /></a><a href="AdminDashboard"><img
          src="images/profile.jpg"
          loading="lazy"
          alt=""
          width="50"
        /></a><a href="sign-out.jsp"><img
          src="images/logout.jpg"
          loading="lazy"
          alt=""
          class="image-9"
          width="50"
        /></a>
      </div>
      <div class="div-block-49">
        <a style="text-decoration: none; color: inherit;" href="admin-view-res.jsp"><h3>View Reservations</h3></a>
        <a style="text-decoration: none; color: inherit;" href="admin-add-data.jsp"><h3>Add Customer / Reservation</h3></a>
        <a style="text-decoration: none; color: inherit;" href="admin-modify-data.jsp"><h3>Modify Reservation</h3></a>
        <a style="text-decoration: none; color: inherit;" href="admin-delete-data.jsp"><h3>Delete Customer / Reservation</h3></a>
        <a style="text-decoration: none; color: inherit;" href="AdminMessages"><h3>View Messages</h3></a>
        <a style="text-decoration: none; color: inherit;" href="AdminDashboard"><h3>Dashboard</h3></a>
        <a style="text-decoration: none; color: inherit;" href="sign-out.jsp"><h3>Log Out</h3></a>
      </div>
      <div class="div-block-50">
        <h2 class="heading-15">Update Reservation Details</h2>
        <div class="div-block-54">
          <div class="form-block-5 w-form">
            <form
              id="wf-form-Data-Update-Form"
              name="wf-form-Data-Update-Form"
              data-name="Data Update Form"
              method="post"
              class="form-6"
              action="ModifysReservation"
              aria-label="Data Update Form"
            >
              <label for="rid">Reservation ID</label
              ><input
                type="number"
                class="w-input"
                maxlength="10"
                name="rid"
                placeholder=""
                id="rid"
                required=""
              /><label for="adults">No. of Adults</label
              ><input
                type="number"
                class="w-input"
                maxlength="9"
                name="adults"
                placeholder=""
                id="adults"
                value="0"
                required=""
              /><label for="children">No. of Children</label
              ><input
                type="number"
                class="w-input"
                maxlength="9"
                name="children"
                placeholder=""
                id="children"
                value="0"
                required=""
              /><label for="cidate">New Check-In Date</label
              ><input
                type="date"
                class="w-input"
                maxlength="256"
                name="cidate"
                placeholder=""
                id="cidate"
                required=""
              /><label for="codate">New Check-Out Date</label
              ><input
                type="date"
                class="w-input"
                maxlength="256"
                name="codate"
                placeholder=""
                id="codate"
                required=""
              /><input
                type="submit"
                value="Update Reservation"
                data-wait="Please wait..."
                class="w-button"
              />
            </form>
            <div
              class="w-form-done"
              tabindex="-1"
              role="region"
              aria-label="Data Update Form success"
            >
              <div>Your submission has been received!</div>
            </div>
            <div
              class="w-form-fail"
              tabindex="-1"
              role="region"
              aria-label="Data Update Form failure"
            >
              <div>Oops! Something went wrong while submitting the form.</div>
            </div>
          </div>
        </div>
      </div>
    </div>
        <!--
    <script
      src="Admin%20Modify%20Data_files/jquery-3.js"
      type="text/javascript"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"
    ></script>
    <script
      src="Admin%20Modify%20Data_files/webflow.js"
      type="text/javascript"
    ></script>
        !-->
    </body>
</html>
