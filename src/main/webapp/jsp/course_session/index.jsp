<%-- 
    Document   : index
    Created on : 17 mai 2019, 20:22:51
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Course sessions</h1>
        <!-- Button -->
        <a href="<c:url value='/course-session/new' />" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Add a course session</a>
    </div>

    <!-- Course sessions Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <jsp:include page="table.jsp" />
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />