<%-- 
    Document   : register
    Created on : 25 mai 2019, 10:44:43
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
        <div class="col-xl-5 col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Infos</h6>
                </div>
                <div class="card-body">
                    <div class="row justify-content-center mt-3">
                        <div class="col">

                            <div class="form-group row">
                                <div class="col-sm-3">Course</div>
                                <div class="col-sm-9">${courseSession.course}</div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">Location</div>
                                <div class="col-sm-9">${courseSession.location}</div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">Start date</div>
                                <div class="col-sm-9"><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.startDate}" /></div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">End date</div>
                                <div class="col-sm-9"><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.endDate}" /></div>
                            </div>

                            <div class="form-group row">
                                <div class="col-sm-3">Max places</div>
                                <div class="col-sm-9">${courseSession.max}</div>
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
        <div class="col-xl-7 col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Register</h6>
                </div>
                <div class="card-body">
                    <div class="row justify-content-center">
                        <div class="col">

                            <form:form method="POST" modelAttribute="client">

                                <form:hidden path="id"/>

                                <div class="form-group row">
                                    <form:label path="firstName" cssClass="col-sm-3 col-form-label">
                                        Firstname
                                    </form:label>
                                    <div class="col-sm-9">
                                        <form:input path="firstName" cssClass="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <form:label path="lastName" cssClass="col-sm-3 col-form-label">
                                        Lastname
                                    </form:label>
                                    <div class="col-sm-9">
                                        <form:input path="lastName" cssClass="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <form:label path="address" cssClass="col-sm-3 col-form-label">
                                        Address
                                    </form:label>
                                    <div class="col-sm-9">
                                        <form:input path="address" cssClass="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <form:label path="phone" cssClass="col-sm-3 col-form-label">
                                        Phone
                                    </form:label>
                                    <div class="col-sm-9">
                                        <form:input path="phone" cssClass="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <form:label path="email" cssClass="col-sm-3 col-form-label">
                                        Email
                                    </form:label>
                                    <div class="col-sm-9">
                                        <form:input path="email" cssClass="form-control" />
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-9">
                                        <button type="reset" class="btn btn-secondary">
                                            <i class="fas fa-eraser fa-sm text-white-50"></i> Reset
                                        </button>
                                        <button type="submit" class="btn btn-primary">
                                            <i class="fas fa-check fa-sm text-white-50"></i> Submit
                                        </button>
                                    </div>
                                </div>

                            </form:form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />