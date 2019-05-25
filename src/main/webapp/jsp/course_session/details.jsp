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
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Infos</h6>
                </div>
                <div class="card-body">
                    <div class="row justify-content-center mt-3">
                        <div class="col">

                            <div class="form-group row">
                                <div class="col-sm-4">Course</div>
                                <div class="col-sm-8">${courseSession.course}</div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-4">Location</div>
                                <div class="col-sm-8">${courseSession.location}</div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-4">Start date</div>
                                <div class="col-sm-8"><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.startDate}" /></div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-4">End date</div>
                                <div class="col-sm-8"><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.endDate}" /></div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-4">Max places</div>
                                <div class="col-sm-8">${courseSession.max}</div>
                            </div>

                            <div class="form-group row">
                                <div class="col">
                                    <div>Filling percentage <span class="float-right">${fillingPercentage}%</span></div>
                                    <div class="progress mb-4">
                                        <div class="progress-bar bg-success" role="progressbar" style="width: ${fillingPercentage}%" aria-valuenow="${fillingPercentage}" aria-valuemin="0" aria-valuemax="100"></div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Attendees list card -->
        <div class="col-lg-7">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Attendees</h6>
                </div>
                <div class="card-body">
                    <c:if test="${!empty attendees}">
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
                                    <c:forEach items="${attendees}" var="attendee">
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