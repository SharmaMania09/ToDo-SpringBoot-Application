<%@ include file="header.jsp"%>
<%@ include file="navigation.jsp"%>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">Home Page</div>
        <div class="panel-body">
            Welcome ${name}!! <a href="/list-todos">Click here</a> to manage your todo's.
        </div>
    </div>
</div>
<%@ include file="footer.jsp"%>