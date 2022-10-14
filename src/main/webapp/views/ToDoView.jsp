<%@ page import="org.json.JSONArray" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="container">
    <div>
        <a type="button" class="btn btn-primary btn-md" href="/add-todo">Add Todo</a>
    </div>
    <br>
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3>List of TODO's</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th width="40%">Description</th>
                        <th width="40%">Target Date</th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todolist}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.toDoDate}</td>
                            <td><a type="button" class="btn btn-success" href="/update-todo?id=${todo.id}">Update</a>
                             <a type="button" class="btn btn-warning" href="/delete-todo?id=${todo.id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>