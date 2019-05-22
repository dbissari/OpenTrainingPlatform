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
        <h1 class="h3 mb-0 text-gray-800">Clients</h1>
        <!-- Button -->
        <a href="<c:url value='/client/new' />" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-plus fa-sm text-white-50"></i> Add a client</a>
    </div>

    <!-- Clients list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <c:if test="${!empty clients}">
                <div class="table-responsive">
                    <table class="table table-hover" id="clientsDataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Firstname</th>
                                <th>Lastname</th>
                                <th>Address</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${clients}" var="client">
                            <tr>
                                <td>${client.firstName}</td>
                                <td>${client.lastName}</td>
                                <td>${client.address}</td>
                                <td>${client.phone}</td>
                                <td>${client.email}</td>
                                <td>
                                    <a href="<c:url value='/client/${client.id}/edit' />" class="btn btn-sm btn-primary">
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