<%-- 
    Document   : sign-in
    Created on : Jan 9, 2022, 10:20:20 AM
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
    <title>Log In</title>
    <meta content="Log In" property="og:title" />
    <meta content="Log In" property="twitter:title" />
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
            <section class="section-9 wf-section">
      <div class="block-1">
        <div class="content-wrapper">
          <div class="content-box">
            <img
              src="images/Hotel Rajapaksha Logo 1.png"
              loading="lazy"
              alt="logo"
              class="image-7"
              height="75"
            />
            <h1 class="heading-1">The choice of the new generation<br /></h1>
            <div class="feature-box">
              <img
                src="images/tag.svg"
                alt=""
                class="feature-icon"
              />
              <div class="feature-text">Unbeatable deals.</div>
            </div>
            <div class="feature-box">
              <img
                src="images/dismiss.svg"
                alt=""
                class="feature-icon"
              />
              <div class="feature-text">Trusted Service.</div>
            </div>
            <div class="feature-box">
              <img
                src="images/close.svg"
                alt=""
                class="feature-icon"
              />
              <div class="feature-text">Cancel Anytime.</div>
            </div>
          </div>
          <div class="legal-box _2">
            <div class="legal-text">
              © 2022 HR&nbsp;Hotel and Resort. All rights reserved.
            </div>
          </div>
        </div>
      </div>
      <div class="block-2">
        <a href="./index.html" class="button-3 w-button">Return To Home</a>
        <div class="form-wrapper-2">
          <h2 class="heading-2">Log In<br /></h2>
          <div class="form-box-2">
            <div class="form-block-4 w-form">
              <form
                id="email-form"
                name="email-form"
                method="post"
                action="userlogin"
                class="form-3"
                aria-label="Email Form"
              >
                <div class="form-field-wrapper">
                  <div class="text-field-box _2">
                    <label for="email" class="field-label-15">Email</label
                    ><input
                      type="email"
                      class="text-field-2 w-input"
                      maxlength="50"
                      name="email"
                      placeholder="you@email.com"
                      id="email"
                      required=""
                    />
                  </div>
                  <div class="text-field-box _2">
                    <label for="password" class="field-label-15"
                      >Password</label
                    ><input
                      type="password"
                      class="text-field-2 w-input"
                      maxlength="20"
                      name="password"
                      placeholder="Password"
                      id="password"
                      required=""
                    />
                  </div>
                </div>
                <label class="w-checkbox checkbox-field"
                  ><div
                    class="w-checkbox-input w-checkbox-input--inputType-custom checkbox"
                  ></div>
                  <input
                    type="checkbox"
                    id="Checkbox-2"
                    name="Checkbox-2"
                    data-name="Checkbox 2"
                    required=""
                    style="opacity: 0; position: absolute; z-index: -1"
                    /><span for="Checkbox-2" class="checkbox-label w-form-label"
                    >I agree to the
                    <a href="#" class="link-4">Terms &amp; Conditions</a> and
                    <a href="#" class="link-4">Privacy Policy</a></span
                  ></label
                ><input
                  type="submit"
                  value="Sign In"
                  data-wait="Please wait..."
                  class="button-2 registration w-button"
                />
              </form>
              <div
                class="w-form-done"
                tabindex="-1"
                role="region"
                aria-label="Email Form success"
              >
                <div>Thank you! Your submission has been received!</div>
              </div>
              <div
                class="w-form-fail"
                tabindex="-1"
                role="region"
                aria-label="Email Form failure"
              >
                <div>Oops! Something went wrong while submitting the form.</div>
              </div>
            </div>
            <div class="div-block-41">
              <div class="text-block-8">Don't have an account?</div>
              <a href="./sign-up.jsp" class="link-3">Sign up now</a>
            </div>
          </div>
        </div>
        <div class="legal-box _2-copy">
          <div class="legal-text _3">
            © 2022 HR Hotels. All rights reserved.
          </div>
        </div>
      </div>
    </section>
    <div class="footer-wrapper wf-section">
      <div class="wrap-2">
        <div class="w-layout-grid footer">
          <img
            src="images/Hotel Rajapaksha Logo 1.png"
            loading="lazy"
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cabc-652ecb72"
            alt="logo"
            height="70"
          />
          <p
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cabd-652ecb72"
            class="small-paragraph"
          >
            The only hotel you would ever need to enjoy your vacation.
          </p>
          <p
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cabf-652ecb72"
            class="small-paragraph cc-copyright-footer"
          >
            HR&nbsp;Hotel and Resort © 2022
          </p>
          <div
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cac1-652ecb72"
            class="label cc-footer-section-headline w-inline-block"
          >
            Menu
          </div>
          <div
            id="w-node-_10f5453d-df0e-9a6e-797f-8700de66fdd8-32e85472"
            class="footer-grid-column"
          >
            <a href="./" class="footer-link">Home</a
            ><a href="./about.jsp" class="footer-link">About</a
            ><a href="./contact.jsp" class="footer-link">Contact</a
            ><a href="./privacy-policy.jsp" class="footer-link">Privacy Policy</a>
          </div>
          <div
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cacc-652ecb72"
            class="label cc-footer-section-headline w-inline-block"
          >
            Follow Us
          </div>
          <div
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cace-652ecb72"
            class="footer-grid-column"
          >
            <a href="https://fb.com/" target="_blank" class="footer-link"
              >Facebook</a
            ><a
              href="https://instagram.com/"
              target="_blank"
              class="footer-link"
              >Instagram</a
            ><a href="https://twitter.com/" target="_blank" class="footer-link"
              >Twitter</a
            >
          </div>
          <div
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cad5-652ecb72"
            class="label cc-footer-section-headline w-inline-block"
          >
            Contact Us
          </div>
          <div
            id="w-node-_4e0a6947-b527-b432-f5fa-bb331d29cad7-652ecb72"
            class="footer-grid-column"
          >
            <a href="mailto:hi@rajapaksha.hotels" class="footer-email-link"
              >hi@rajapaksha.hotels</a
            >
          </div>
        </div>
      </div>
    </div>
        <!---
    <script
      src="Log%20In_files/jquery-3.js"
      type="text/javascript"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"
    ></script>
    <script src="Log%20In_files/webflow.js" type="text/javascript"></script>
        !--->
    </body>
</html>
