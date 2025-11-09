<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Display</title>
        <script src="https://cdn.jsdelivr.net/npm/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <div class="flex w-50/100 justify-between h-[100vh] items-center text-2xl mx-auto">
            <a href="/date" class="underline text-blue-400">Date Template</a>
            <a href="/time" class="underline text-blue-400">Time Template</a>
        </div>
    </body>
</html>
