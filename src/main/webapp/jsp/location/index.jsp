<%-- 
    Document   : index
    Created on : 19 mai 2019, 01:15:21
    Author     : edemos
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Locations</h1>
        <!-- Button -->
        <a href="<c:url value='/location/new' />" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Add a location</a>
    </div>

    <!-- Locations list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <c:if test="${!empty locations}">
                <div class="table-responsive">
                    <table class="table table-hover" id="locationsDataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>City</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${locations}" var="location">
                            <tr>
                                <td>${location.city}</td>
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
