<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
    Date time = new Date(); // get current time
    SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
    String formattedTime = formatter.format(time);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Time</title>

        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>

    </head>
    <body class="flex flex-col justify-center items-center h-screen">
        <h1 class="text-3xl font-medium text-blue-400 text-center">
            <%= formattedTime %>
        </h1>

        <script>
            document.addEventListener("DOMContentLoaded", function() {
                setTimeout(() => {
                    alert("This is the time template");
                }, 200);
            });
        </script>
    </body>
</html>
