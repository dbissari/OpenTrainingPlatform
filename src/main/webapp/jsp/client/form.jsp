<%-- 
    Document   : new_form
    Created on : 18 mai 2019, 09:53:48
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Client</h1>
    </div>

    <!-- Clients list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="row justify-content-center mt-3">
                <div class="col-sm-10 col-md-8 col-lg-6">

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
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />