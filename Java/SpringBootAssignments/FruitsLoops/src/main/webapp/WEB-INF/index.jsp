<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Fruit Store</title>
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
    <body class="bg-white flex justify-center items-start min-h-screen py-16">

        <div class="w-11/12 max-w-3xl">
            <h1 class="text-3xl font-bold text-pink-500 mb-6">Fruit Store</h1>

            <div class="border-8 border-pink-200 p-6 rounded-md bg-white shadow-sm">
                <table class="w-full border-collapse">
                    <thead>
                        <tr class="text-left text-gray-700 border-b-2 border-pink-200">
                            <th class="py-3 px-2">Name</th>
                            <th class="py-3 px-2">Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="fruit" items="${fruits}">
                            <tr class="border-b border-pink-100 text-gray-800">
                                <td class="py-3 px-2">${fruit.name}</td>
                                <td class="py-3 px-2">${fruit.price}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
