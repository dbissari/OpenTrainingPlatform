<%-- 
    Document   : layout_head
    Created on : 18 mai 2019, 08:39:18
    Author     : bright
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>OpenTrainingPlatform</title>

        <!-- Custom fonts for this template-->
        <link href="<c:url value="/resources/fontawesome-free/css/all.min.css" />" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="<c:url value="/resources/sb-admin-2/css/sb-admin-2.min.css" />" rel="stylesheet">

    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value='/' />">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">OTP</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/' />">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Courses
                </div>

                <!-- Nav Item - Collapse - Courses -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" id="headingCourses" data-toggle="collapse" data-target="#collapseCourses" aria-expanded="true" aria-controls="collapseCourses">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Courses</span>
                    </a>
                    <div id="collapseCourses" class="collapse" aria-labelledby="headingCourses" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="<c:url value='/course/new' />">New</a>
                            <a class="collapse-item" href="<c:url value='/course' />">List</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Collapse - Locations -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" id="headingLocations" data-toggle="collapse" data-target="#collapseLocations" aria-expanded="true" aria-controls="collapseLocations">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Locations</span>
                    </a>
                    <div id="collapseLocations" class="collapse" aria-labelledby="headingLocations" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="<c:url value='/location/new' />">New</a>
                            <a class="collapse-item" href="<c:url value='/location' />">List</a>
                        </div>
                    </div>
                </li>

                <!-- Nav Item - Collapse - Sessions -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" id="headingSessions" data-toggle="collapse" data-target="#collapseSessions" aria-expanded="true" aria-controls="collapseSessions">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Sessions</span>
                    </a>
                    <div id="collapseSessions" class="collapse" aria-labelledby="headingSessions" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="<c:url value='/course-session/new' />">New</a>
                            <a class="collapse-item" href="<c:url value='/course-session' />">List</a>
                            <a class="collapse-item" href="<c:url value='/course-session/search' />">Search</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Clients
                </div>

                <!-- Nav Item - Collapse - Clients -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#" id="headingClients" data-toggle="collapse" data-target="#collapseClients" aria-expanded="true" aria-controls="collapseClients">
                        <i class="fas fa-fw fa-folder"></i>
                        <span>Clients</span>
                    </a>
                    <div id="collapseClients" class="collapse" aria-labelledby="headingClients" data-parent="#accordionSidebar">
                        <div class="bg-white py-2 collapse-inner rounded">
                            <a class="collapse-item" href="<c:url value='/client/new' />">New</a>
                            <a class="collapse-item" href="<c:url value='/client' />">List</a>
                        </div>
                    </div>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar static-top shadow d-md-none">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                    </nav>
                    <!-- End of Topbar -->