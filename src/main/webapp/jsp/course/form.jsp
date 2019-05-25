<%-- 
    Document   : form
    Created on : 19 mai 2019, 02:02:07
    Author     : edemos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Course</h1>
    </div>

    <!-- Courses list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="row justify-content-center mt-3">
                <div class="col-sm-10 col-md-8 col-lg-6">

                    <form:form method="POST" modelAttribute="course">

                        <div class="form-group row">
                            <form:label path="code" cssClass="col-sm-3 col-form-label">
                                Code
                            </form:label>
                            <div class="col-sm-9">
                                <form:input path="code" cssClass="form-control" readonly="${!empty course.code}"/>
                                <small class="text-danger">
                                    <form:errors path="code" />
                                </small>
                            </div>
                        </div>
                            
                        <div class="form-group row">
                            <form:label path="title" cssClass="col-sm-3 col-form-label">
                                Title
                            </form:label>
                            <div class="col-sm-9">
                                <form:input path="title" cssClass="form-control" />
                                <small class="text-danger">
                                    <form:errors path="title" />
                                </small>
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