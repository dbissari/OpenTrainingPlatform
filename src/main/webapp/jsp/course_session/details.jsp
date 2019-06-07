<%-- 
    Document   : details
    Created on : 22 mai 2019, 10:28:55
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Course session</h1>
    </div>

    <!-- Row -->
    <div class="row">

        <!-- Infos Card -->
        <div class="col-lg-5">
            <jsp:include page="infos.jsp" />
        </div>

        <!-- Attendees list card -->
        <div class="col-lg-7">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Attendees</h6>
                </div>
                <div class="card-body">
                    <c:if test="${!empty courseSession.attendees}">
                        <div class="table-responsive">
                            <table class="table table-hover" id="attendeesDataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Firstname</th>
                                        <th>Lastname</th>
                                        <th>Address</th>
                                        <th>Phone</th>
                                        <th>Email</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${courseSession.attendees}" var="attendee">
                                        <tr>
                                            <td>${attendee.firstName}</td>
                                            <td>${attendee.lastName}</td>
                                            <td>${attendee.address}</td>
                                            <td>${attendee.phone}</td>
                                            <td>${attendee.email}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>

    </div>

</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />