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
        <h1 class="h3 mb-0 text-gray-800">Course session</h1>
    </div>

    <!-- Clients list Card -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="row justify-content-center mt-3">
                <div class="col-sm-10 col-md-8 col-lg-6">

                    <form:form method="POST" modelAttribute="courseSession">

                        <form:hidden path="id"/>

                        <div class="form-group row">
                            <form:label path="course.code" cssClass="col-sm-3 col-form-label">
                                Course
                            </form:label>
                            <div class="col-sm-9">
                                <form:select path="course.code" class="form-control" >
                                    <c:forEach items="${courses}" var="c" varStatus="status">
                                        <c:choose>
                                            <c:when test="${c.code eq course.code}">
                                                <form:option value="${c.code}" selected="true" label="${c}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${c.code}" label="${c.title}"/>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                                <small class="text-danger">
                                    <form:errors path="course.code" />
                                </small>
                            </div>
                        </div>

                        <div class="form-group row">
                            <form:label path="location.id" cssClass="col-sm-3 col-form-label">
                                Location
                            </form:label>
                            <div class="col-sm-9">
                                <form:select path="location.id" class="form-control">
                                    <c:forEach items="${locations}" var="l" varStatus="status">
                                        <c:choose>
                                            <c:when test="${l.id eq location.id}">
                                                <form:option selected="true" value="${l.id}" label="${l}"/>
                                            </c:when>
                                            <c:otherwise>
                                                <form:option value="${l.id}" label="${l}"/>
                                            </c:otherwise>
                                        </c:choose> 
                                    </c:forEach>
                                </form:select>
                                <small class="text-danger">
                                    <form:errors path="location.id" />
                                </small>
                            </div>
                        </div>

                        <div class="form-group row">
                            <form:label path="startDate" cssClass="col-sm-3 col-form-label">
                                Start date
                            </form:label>
                            <div class="col-sm-9">
                                <form:input path="startDate" cssClass="form-control" type="date" />
                                <small class="text-danger">
                                    <form:errors path="startDate" />
                                </small>
                            </div>
                        </div>

                        <div class="form-group row">
                            <form:label path="endDate" cssClass="col-sm-3 col-form-label">
                                End date
                            </form:label>
                            <div class="col-sm-9">
                                <form:input path="endDate" cssClass="form-control" type="date" />
                                <small class="text-danger">
                                    <form:errors path="endDate" />
                                </small>
                            </div>
                        </div>

                        <div class="form-group row">
                            <form:label path="max" cssClass="col-sm-3 col-form-label">
                                Max places
                            </form:label>
                            <div class="col-sm-9">
                                <form:input path="max" cssClass="form-control" />
                                <small class="text-danger">
                                    <form:errors path="max" />
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