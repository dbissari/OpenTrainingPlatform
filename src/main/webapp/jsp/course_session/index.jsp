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

    <!-- Clients list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <c:if test="${!empty courseSessions}">
                <div class="table-responsive">
                    <table class="table table-hover" id="courseSessionsDataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Course</th>
                                <th>Start</th>
                                <th>End</th>
                                <th>Location</th>
                                <th>Max places</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${courseSessions}" var="courseSession">
                            <tr>
                                <td>${courseSession.course}</td>
                                <td>${courseSession.startDate}</td>
                                <td>${courseSession.endDate}</td>
                                <td>${courseSession.location}</td>
                                <td>${courseSession.max}</td>
                                <td>
                                    <a href="<c:url value='course-session/${courseSession.id}/edit' />" class="btn btn-sm btn-primary">
                                        <i class="fas fa-pen fa-sm text-white-50"></i> Edit
                                    </a>
                                    <!--<a href="#" class="btn btn-sm btn-danger">
                                        <i class="fas fa-trash fa-sm text-white-50"></i> Delete
                                    </a>-->
                                </td>
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