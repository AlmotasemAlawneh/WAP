<%--
  Created by IntelliJ IDEA.
  User: mot_a
  Date: 7/11/2019
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
<form action="../logout" method="post">
   <h1> Hello <span id="username"></span></h1></br>
    <button type="submit">Logout</button>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>

<script>
    $(function(){
        function getUrlVars(){
            var vars=[],hash;
            var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            for(var i = 0; i < hashes.length; i++)
            {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            return vars;
        }

        var queryString = getUrlVars();
        if(queryString && queryString["username"]) {
            $('span#username').html(queryString["username"]);
            $('input#username').val(queryString["username"]);
        }
    });

</script>
</body>
</html>