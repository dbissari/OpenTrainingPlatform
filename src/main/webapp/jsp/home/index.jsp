<%-- 
    Document   : index
    Created on : 17 mai 2019, 20:22:51
    Author     : bright
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/fragment/layout_head.jsp" />

<!-- Begin Page Content -->
<div class="container-fluid mt-4">

    <!-- Page Title -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <!-- Page Title -->
        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
    </div>

    <!-- Row -->
    <div class="row justify-content-center">

        <!-- Api routes Card -->
        <div class="col-xl-10">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">API routes</h6>
                </div>

                <div class="card-body">

                    <div class="accordion" id="accordionApiRoutes">

                        <div class="list-group list-group-flush">
                            <div id="headingLocationsRoutes" class="list-group-item" data-toggle="collapse" data-target="#collapseLocationsRoutes" aria-expanded="true" aria-controls="collapseLocationsRoutes" style="cursor: pointer;">
                                <h6 class="m-0 font-weight-bold text-primary">Locations</h6>
                            </div>

                            <div class="list-group mt-1 collapse show" id="collapseLocationsRoutes" aria-labelledby="headingLocationsRoutes" data-parent="#accordionApiRoutes">
                                <li class="list-group-item">
                                    List all locations : <samp>GET</samp> <kbd>api/location</kbd>
                                </li>
                                <li class="list-group-item">
                                    Create a new location : <samp>POST</samp> <kbd>api/location</kbd>
                                </li>
                                <li class="list-group-item">
                                    Get a location by its id : <samp>GET</samp> <kbd>api/location/<code>{id}</code></kbd>
                                </li>
                            </div>
                        </div>

                        <div class="list-group list-group-flush">
                            <div  id="headingCoursesRoutes" class="list-group-item" data-toggle="collapse" data-target="#collapseCoursesRoutes" aria-expanded="true" aria-controls="collapseCoursesRoutes" style="cursor: pointer;">
                                <h6 class="m-0 font-weight-bold text-primary">Courses</h6>
                            </div>

                            <div class="list-group collapse" id="collapseCoursesRoutes" aria-labelledby="headingCoursesRoutes" data-parent="#accordionApiRoutes">
                                <li class="list-group-item">
                                    List all courses : <samp>GET</samp> <kbd>api/course</kbd>
                                </li>
                                <li class="list-group-item">
                                    Create a new course : <samp>POST</samp> <kbd>api/course</kbd>
                                </li>
                                <li class="list-group-item">
                                    Get a course by its code : <samp>GET</samp> <kbd>api/course/<code>{code}</code></kbd>
                                </li>
                            </div>
                        </div>

                        <div class="list-group list-group-flush">
                            <div id="headingCourseSessionsRoutes" class="list-group-item" data-toggle="collapse" data-target="#collapseCourseSessionsRoutes" aria-expanded="true" aria-controls="collapseCourseSessionsRoutes" style="cursor: pointer;">
                                <h6 class="m-0 font-weight-bold text-primary">Course sessions</h6>
                            </div>

                            <div class="list-group collapse" id="collapseCourseSessionsRoutes" aria-labelledby="headingCourseSessionsRoutes" data-parent="#accordionApiRoutes">
                                <li class="list-group-item">
                                    List all course sessions : <samp>GET</samp> <kbd>api/course-session</kbd>
                                </li>
                                <li class="list-group-item">
                                    Create a new course session : <samp>POST</samp> <kbd>api/course-session</kbd>
                                </li>
                                <li class="list-group-item">
                                    Get a course session by its id : <samp>GET</samp> <kbd>api/course-session/<code>{id}</code></kbd>
                                </li>
                                <li class="list-group-item">
                                    Get a course session attendees' by its id : <samp>GET</samp> <kbd>api/course-session/<code>{id}</code>/attendees</kbd>
                                </li>
                                <li class="list-group-item">
                                    Register a new client to a course session with its id : <samp>POST</samp> <kbd>api/course-session/<code>{id}</code>/register</kbd>
                                </li>
                                <li class="list-group-item">
                                    List all course sessions filtered : <samp>GET</samp> <kbd>api/course-session/filter?course_keyword=<code>{keyword}</code>&date=<code>{date}</code>&location_id=<code>{location_id}</code></kbd>
                                </li>
                            </div>
                        </div>

                    </div>
                    
                </div>
            </div>
        </div>

    </div>
    <!-- End of Row -->

</div>
<!-- /.container-fluid -->

<jsp:include page="/jsp/fragment/layout_foot.jsp" />