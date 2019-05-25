<%-- 
    Document   : index
    Created on : 19 mai 2019, 01:59:14
    Author     : edemos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Courses</h1>
        <!-- Button -->
        <a href="<c:url value='/course/new' />" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Add a course</a>
    </div>

    <!-- Courses list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <c:if test="${!empty courses}">
                <div class="table-responsive">
                    <table class="table table-hover" id="coursesDataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Title</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courses}" var="course">
                            <tr>
                                <td>${course.code}</td>
                                <td>${course.title}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />