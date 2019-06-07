<%-- 
    Document   : table
    Created on : 22 mai 2019, 15:44:42
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                    <th>Filling percentage</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${courseSessions}" var="courseSession">
                <tr>
                    <td>${courseSession.course.title}</td>
                    <td><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.startDate}" /></td>
                <td><fmt:formatDate type="date" dateStyle="short" value = "${courseSession.endDate}" /></td>
                <td>${courseSession.location}</td>
                <td>${courseSession.max}</td>
                <td>${courseSession.fillingPercentage}%</td>
                <td>
                    <a href="<c:url value='/course-session/${courseSession.id}/register' />" class="btn btn-sm btn-primary">
                        <i class="fas fa-pen fa-sm text-white-50"></i> Register
                    </a>
                    <a href="<c:url value='/course-session/${courseSession.id}/details' />" class="btn btn-sm btn-info">
                        <i class="fas fa-eye fa-sm text-white-50"></i> Show
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