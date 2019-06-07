<%-- 
    Document   : infos
    Created on : 7 juin 2019, 11:53:39
    Author     : bright
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                    <div class="col-sm-4">Registers</div>
                    <div class="col-sm-8">${courseSession.attendees.size()}</div>
                </div>

                <div class="form-group row">
                    <div class="col-sm-4">Max places</div>
                    <div class="col-sm-8">${courseSession.max}</div>
                </div>

                <div class="form-group row">
                    <div class="col">
                        <div>Filling percentage <span class="float-right">${courseSession.fillingPercentage}%</span></div>
                        <div class="progress">
                            <div class="progress-bar bg-success" role="progressbar" style="width: ${courseSession.fillingPercentage}%" aria-valuenow="${courseSession.fillingPercentage}" aria-valuemin="0" aria-valuemax="100"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
