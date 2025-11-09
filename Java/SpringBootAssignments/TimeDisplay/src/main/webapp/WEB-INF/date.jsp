<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy");
    String formattedDate = formatter.format(date);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Date</title>
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>

    </head>
    <body class="flex flex-col justify-center items-center h-screen ">
        <h1 class="text-3xl font-medium text-blue-400 text-center">
            <%= formattedDate %>
        </h1>

        <script>
            document.addEventListener("DOMContentLoaded", function() {
                setTimeout(() => {
                    alert("This is the date template");
                }, 200);
            });
        </script>
    </body>
</html>
