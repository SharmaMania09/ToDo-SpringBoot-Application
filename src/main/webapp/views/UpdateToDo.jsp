<%@ page import="org.json.JSONArray" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 ">
            <div class="panel panel-primary">
                <div class="panel-heading">Update TODO</div>
                <div class="panel-body">
                    <c:forEach items="${toDo}" var="todo">
                        <form action="updateToDo?id=${todo.id}" method="post">
                            <div class="form-group">
                                <label>Description</label>
                                <input class="form-control" value="${todo.description}" type="text" name="description" />
                                <label style="margin-top: 15px;">Target Date </label>
                                <input type="text" class="form-control" value="${todo.toDoDate}" name="toDoDate">
                                <button class="btn btn-primary" style="margin-top: 15px;" name="submit" type="submit">Update</button>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    </script>
</div>
<%@ include file="footer.jsp"%>