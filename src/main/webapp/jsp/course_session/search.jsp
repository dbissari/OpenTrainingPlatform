<%-- 
    Document   : search
    Created on : 22 mai 2019, 14:05:03
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Course sessions search</h1>
    </div>

    <div class="row">
        <div class="col">

            <!-- Course session search card -->
            <div class="card shadow mb-4">
                <div class="card-body">

                    <form class="row" method="GET">

                        <div class="col-sm-6 col-lg-3 my-2">
                            <h4 class="small font-weight-bold">Course</h4>
                            <input type="text" class="form-control" name="course_keyword" value="${courseKeyword}"/>
                        </div>

                        <div class="col-sm-6 col-lg-3 my-2">
                            <h4 class="small font-weight-bold">Date</h4>
                            <input type="date" class="form-control" name="date" value="${date}" />
                        </div>

                        <div class="col-sm-6 col-lg-3 my-2">
                            <h4 class="small font-weight-bold">Location</h4>
                            <select class="form-control" name="location_id">
                                <option value=""></option>
                                <c:forEach items="${locations}" var="l">
                                    <c:choose>
                                        <c:when test="${l.id eq locationId}">
                                            <option value="${l.id}" selected="true">${l}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${l.id}">${l}</option>
                                        </c:otherwise>
                                    </c:choose> 
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-sm-6 col-lg-3 my-2">
                            <h4 class="small font-weight-bold">&nbsp;</h4>
                            <button type="submit" class="btn btn-primary">
                                <i class="fas fa-search fa-sm text-white-50"></i>  Search
                            </button>
                        </div>

                    </form>

                </div>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col">

            <!-- Course sessions list Card -->
            <div class="card shadow mb-4">
                <div class="card-body">
                    <jsp:include page="table.jsp" />
                </div>
            </div>

        </div>
    </div>


</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />