<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="com.google.appinventor.server.util.UriBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<%
   String error = request.getParameter("error");
   String useGoogleLabel = (String) request.getAttribute("useGoogleLabel");
   String locale = request.getParameter("locale");
   String redirect = request.getParameter("redirect");
   String repo = (String) request.getAttribute("repo");
   String galleryId = (String) request.getAttribute("galleryId");
   if (locale == null) {
       locale = "en";
   }

%>
<html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta HTTP-EQUIV="pragma" CONTENT="no-cache"/>
    <meta HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate"/>
    <meta HTTP-EQUIV="expires" CONTENT="0"/>


     <title>HydrIDE</title>
    <meta charset="utf-8" />
    <meta name="theme-color" content="#44336">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Place icon.png in the root directory -->
    <link rel="shortcut icon" href="https://cdn.reactiveide.com/hybrostudiologo500.png">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

  
<style>

@import url('https://fonts.googleapis.com/css?family=Josefin+Sans');



.material-spinner {
    /* The height and width can be
    whatever you want, so long as
    you adjust the border radius
    to compensate. I added a 
    "max-height" because for some
    reason the spinner was
    "squishing" when I resized the
    screen vertically. "max-height"
    fixed this. */
    height: 50px;
    min-height: 50px;
    width: 50px;
    /* "border-radius" defines how
    much "curve" there is on the
    edge of a square element. If
    you give it enough curve, it
    makes the element appear to be
    circular. */
    border-radius: 100px;
    /* So there's a five pixel
    transparent solid border
    around a 50px square box, which
    has edges curved so much that
    it looks circular... */
    border: 5px transparent solid;
    /* ... with one side, the top
    border, given a color. This
    creates the quarter-circle 
    curve. */
    border-top: 5px #3F51B5 solid;
    /* "animation" specifies an
    animation to use on the element,
    including how long the animation
    should take, how many times it 
    should play, and even whether 
    or not it should ease into the
    different steps of the animation.
    By default the animation eases,
    which is what we want for our
    Google-esque spinner, so we 
    don't need to set that. 
    
    The "material-spinner" part is
    the name of the animation that 
    we want to use. We could've
    called it "funky-bunny" or
    anything else so long as we 
    use the same name when
    specifying the keyframes. */
    animation: material-spinner 4s infinite;
}

@keyframes material-spinner {
    /* "material-spinner" is the name
    of the animation. Each percentage
    represents an individual step
    in the animation. The transform
    rotation needs to increase from
    0 throughout. If you did 
    "rotate(0deg)" then 
    "rotate(180deg)" and then 
    "rotate(0deg)" back again,
    instead of continously spinning
    right, it would spin right,
    then left, then right.*/ 
    0% {
        transform: rotate(0deg);
        border-top: 5px #3F51B5 solid;
    }
    25% {
        transform: rotate(360deg);
        border-top: 5px #F44336 solid;
    }
    50% {
        transform: rotate(720deg);
        border-top: 5px #FFC107 solid;
    }
    75% {
        transform: rotate(1080deg);
        border-top: 5px #4CAF50 solid;
    }
    100% {
        transform: rotate(1440deg);
        border-top: 5px #3F51B5 solid;
    }
}





#splash {
    display: block;
    height: 100%;
     width: 100%;
    margin: 0;
    font-family: 'Josefin Sans';
    background-color: white;
}

  @media screen and (max-width: 900px) {
    .middle{
      margin-top: 350px;
    }
     #splash {
     .img {
     height:150px;
  }
}  
}

  @media screen and (max-width: 580px) {
    .middle{
      margin-top: 300px;
    }
 #splash {
     .img {
     height:200px;
     }
}
}


#main {
 display:none;
 height: 100%;
 width: 100%;
 background-color: #282828;
background-position: center;
background-size: cover;
position: relative;
color: white;
}



</style>

<style>
  /* Progress Bar */
}
.progress {
  position: relative;
  height: 4px;
  display: block;
  width: 100%;
  background-color: #ffcdd2;
  border-radius: 2px;
  background-clip: padding-box;
  margin: 0.5rem 0 1rem 0;
  overflow: hidden; }

  .progress .indeterminate {
    height: 4px;
    background-color: #44336; }

    .progress .indeterminate:before {
      height: 4px;
      content: '';
      position: absolute;
      background-color: #f44336;
      top: 0;
      left: 0;
      bottom: 0;
      will-change: left, right;
      -webkit-animation: indeterminate 2.1s cubic-bezier(0.65, 0.815, 0.735, 0.395) infinite;
              animation: indeterminate 2.1s cubic-bezier(0.65, 0.815, 0.735, 0.395) infinite; }
    .progress .indeterminate:after {
      height: 4px;
      content: '';
      position: absolute;
      background-color: #f44336;;
      top: 0;
      left: 0;
      bottom: 0;
      will-change: left, right;
      -webkit-animation: indeterminate-short 2.1s cubic-bezier(0.165, 0.84, 0.44, 1) infinite;
              animation: indeterminate-short 2.1s cubic-bezier(0.165, 0.84, 0.44, 1) infinite;
      -webkit-animation-delay: 1.15s;
              animation-delay: 1.15s; }

@-webkit-keyframes indeterminate {
  0% {
    left: -35%;
    right: 100%; }
  60% {
    left: 100%;
    right: -90%; }
  100% {
    left: 100%;
    right: -90%; } }
@keyframes indeterminate {
  0% {
    left: -35%;
    right: 100%; }
  60% {
    left: 100%;
    right: -90%; }
  100% {
    left: 100%;
    right: -90%; } }
@-webkit-keyframes indeterminate-short {
  0% {
    left: -200%;
    right: 100%; }
  60% {
    left: 107%;
    right: -8%; }
  100% {
    left: 107%;
    right: -8%; } }
@keyframes indeterminate-short {
  0% {
    left: -200%;
    right: 100%; }
  60% {
    left: 107%;
    right: -8%; }
  100% {
    left: 107%;
    right: -8%; } }

@font-face {
  font-family: 'Josefin Sans';
  font-style: normal;
  font-weight: 400;
  src: local('Open Sans'), local('OpenSans'), url(https://fonts.gstatic.com/s/productsans/v5/HYvgU2fE2nRJvZ5JFAumwegdm0LZdjqr5-oayXSOefg.woff2) format('woff2');
}


* { box-sizing:border-box; }

/* basic stylings ------------------------------------------ */
body        
{ 
    font-family: 'Josefin Sans';
    background: none;
    
}

/* form starting stylings ------------------------------- */
.group        { 
  position:relative; 
  margin-top:5%;
  margin-bottom:45px;
  padding:20px 20px 30px 30px;
  background-color:white;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
  transition: all 0.3s cubic-bezier(.25,.8,.25,1); 
  font-family: 'Josefin Sans';

}


.mtl-input        { 
  position:relative; 
  margin-bottom:25px;
  font-family: 'Josefin Sans';
}

.mtl-grn-link         { 
    color:#f44336;
    text-decoration: none;
  font-family: 'Josefin Sans';
font-style: normal;
font-weight: 100;
}

.mtl-grn-link:hover     { 
    opacity: 0.6;
    text-decoration: none;
    font-family: 'Josefin Sans';
}





.login-btn        { 

    /* border: 1px solid #4CAF50; */
    color: #f44336;
    background-color: transparent;
    font-family: 'Josefin Sans';
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    position: relative;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
    transition: all 0.3s cubic-bezier(.25,.8,.25,1);
    border-radius: 3.5px;
    width: 300px;
}

.login-btn:hover        { 
    color:white;
    background-color:#ff4433;
    
}

input         {
  font-size:18px;
  font-family: 'Josefin Sans';
  padding:10px 10px 10px 5px;
  background-color:transparent;
  color:black;
  display:block;
  width:300px;
  border:none;
  border-bottom:1px solid #757575;
}
input:focus     { outline:none; }

::placeholder {
    color: #757575;
    opacity:0.6;
    font-family: 'Josefin Sans';
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
   color: #757575;
   opacity:0.6;
   font-family: 'Josefin Sans';
}

::-ms-input-placeholder { /* Microsoft Edge */
   color: #757575;
   opacity:0.6;
   font-family: 'Josefin Sans';
}

/* BOTTOM BARS ================================= */
.bar  { position:relative; display:block; width:300px; }
.bar:before, .bar:after   {
  content:'';
  height:2px; 
  width:0;
  bottom:1px; 
  position:absolute;
  background:#ff4433; 
  transition:0.2s ease all; 
  -moz-transition:0.2s ease all; 
  -webkit-transition:0.2s ease all;
}
.bar:before {
  left:50%;
}
.bar:after {
  right:50%; 
}

/* active state */
input:focus ~ .bar:before, input:focus ~ .bar:after {
  width:50%;
}

/* HIGHLIGHTER ================================== */
.highlight {
  position:absolute;
  height:60%; 
  width:100px; 
  top:25%; 
  left:0;
  pointer-events:none;
  opacity:0.5;
}

/* active state */
input:focus ~ .highlight {
  -webkit-animation:inputHighlighter 0.3s ease;
  -moz-animation:inputHighlighter 0.3s ease;
  animation:inputHighlighter 0.3s ease;
}

/* ANIMATIONS ================ */
@-webkit-keyframes inputHighlighter {
  from { background:#5264AE; }
  to  { width:0; background:transparent; }
}
@-moz-keyframes inputHighlighter {
  from { background:#5264AE; }
  to  { width:0; background:transparent; }
}
@keyframes inputHighlighter {
  from { background:#5264AE; }
  to  { width:0; background:transparent; }
}


.bgdarklayer{
    background-color: rgba(0,0,0,0.5); 
    height: 100%;
    width: 100%;
}

.topleft {
    position: absolute;
    top: 0;
    left: 16px;
    font-family: 'Josefin Sans';
    font-size: 25px;
}

.topright {
    position: absolute;
    top: 0;
    right: 16px;
}

.bottomleft {
    position: absolute;
    bottom: 0;
    left: 16px;
    font-family: 'Josefin Sans';
}

.bottomright {
    position: absolute;
    bottom: 0;
    right: 16px;
    font-family: 'Josefin Sans';
}

.middle {
    position: absolute;
    margin-top:400px;
    left: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
    font-family: 'Josefin Sans';
}

.bottomleft {
    font-size:14px;
}

hr {
    margin: auto;
    width: 40%;
}

#login {
}

#register {
 display:none;
}


@media only screen and (max-width: 600px) {
    body {
        font-size:70%;
    }
    
    
}


</style>
   
  </head>
<body>
<div id="splash">
    <center>
  <div class="progress">
      <div class="indeterminate">
      </div>
      </div>
</center>
      <center>
  <div class="spacetop" style="margin-top:150px;">
  </div>
<img src="https://cdn.reactiveide.com/hydridelogo.png" height="120px" style="padding-top:20px;">
<br>
<br>
<p style="color:#f44336; font-size:26px;"><b>HydrIDE</b></p>
<br>
<div class="material-spinner"></div>
<br>
<br>
<br>
<br>
<p style="color:#f44336;">Product of Hybro</p>
</center>
</div>


<div id="main">
<div class="bgimg">
  <div class="bgdarklayer">
  <div class="topleft">
    <p style="color:#f44336; font-size:16px;"><b style="font-size:28px;">HydrIDE</b></p>
  </div>

    <div class="topright">
   <p><i class="fa fa-close"></i></p>
  </div>
  </div>




<div id="login">
  <div class="middle">
<div class="group">

<center>
  <br><br>
     <img src="https://cdn.reactiveide.com/hydridelogo.png" height="100">
  <br>
  <p style="color:#f44336; font-size:16px;"><b style="font-size:28px;">HydrIDE</b></p>
  <br><br>
</center>

    <form method=POST action="/login">


<% if (error != null) {
out.println("<center><font color=red><b>" + error + "</b></font></center><br/>");
   } %>


    <div class="mtl-input">
      <input type=text name=email value="" placeholder="Username" required>
      <span class="bar"></span>
 </div>

      
       <div class="mtl-input">
      <input type=password name=password value="" placeholder="Password" required>
      <span class="bar"></span>
  </div>
<br>
<% if (locale != null && !locale.equals("")) {
   %>
<input type=hidden name=locale value="<%= locale %>">
<% }
   if (repo != null && !repo.equals("")) {
   %>
<input type=hidden name=repo value="<%= repo %>">
<% }
   if (galleryId != null && !galleryId.equals("")) {
   %>
<input type=hidden name=galleryId value="<%= galleryId %>">
<% } %>
<% if (redirect != null && !redirect.equals("")) {
   %>
<input type=hidden name=redirect value="<%= redirect %>">
<% } %>
<p></p>
<center><input class="login-btn" type=Submit value="LOGIN" ></center>
     
  </form>
  

<p></p>
<%    if (useGoogleLabel != null && useGoogleLabel.equals("true")) { %>
<center><p><a class="login-btn" href="<%= new UriBuilder("/login/google")
                              .add("locale", locale)
                              .add("repo", repo)
                              .add("galleryId", galleryId)
                              .add("redirect", redirect).build() %>" style="text-decoration:none;"><i class="fab fa-google"></i> SIGN IN WITH GOOGLE</a></p></center>
<%    } %>
<center><p><a class="mtl-grn-link" href="/login/sendlink"  style="text-decoration:none;">Forgot password ?</a></p></center>


<center>

   <div id="google_translate_element"></div><script type="text/javascript">
function googleTranslateElementInit() {
  new google.translate.TranslateElement({pageLanguage: 'en', includedLanguages: 'de,el,en,es,fi,fr,id,it,ja,ko,la,ms,pt,zh-CN,zh-TW', layout: google.translate.TranslateElement.InlineLayout.SIMPLE}, 'google_translate_element');
}
</script><script type="text/javascript" src="//translate.google.com/translate_a/element.js?cb=googleTranslateElementInit"></script>

  </div>
</div>
</div>
</form>
</div>

<script>
    setTimeout('ShowLogin()', 4000); 
    function ShowLogin()  {  
        $("#splash").fadeOut();
        document.body.style.backgroundColor = "none";
document.body.style.background = "white";
        $("#main").fadeIn(500);
    }
  
</script>

</body></html>

