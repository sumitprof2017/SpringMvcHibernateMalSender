<%-- 
    Document   : jwplayer
    Created on : May 16, 2018, 5:08:08 PM
    Author     : MR.Cutevil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <script type="text/javascript" src="/jwplayer/jwplayer.js"></script>
<script type="text/javascript">jwplayer.key="ABCDEFGHIJKLMOPQ";</script>
    </head>
    <body>
       <div id="myElement">Loading the player...</div>

<script type="text/javascript">
    jwplayer("myElement").setup({
        file: "/uploads/myVideo.mp4",
        image: "/uploads/myPoster.jpg"
    });
</script>
    </body>
</html>
