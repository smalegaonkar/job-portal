<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>My Applied Jobs</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Login Page.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>

<body style="background-image: none;">
	
	<%-- ******************Vertical Menu bar********************* --%>
	<div style="float:left; width:200px; ">

		<ul class="nav nav-pills nav-justified">
			<form action="SeekerHomePage" method="post">
                 <input type="Submit" value="Candidate Home" class="btn btn-default btn-block" />
            </form>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<li class="active"><a>My Applied Jobs</a></li>
		</ul>
		
		<ul class="nav nav-pills nav-justified">
			<form:form action="Logout" method="get">
                 <input type="Submit" value="Logout" class="btn btn-default btn-block" />
            </form:form>
		</ul>
	</div>
<!-- ******************End of Vertical Menu bar********************* -->

	
	<div style="float:left; margin-left:30px; ">
		<h1 id="h1" style="margin-top: -20px; margin-bottom: -5px">Jobs you have applied :</h1>
	
		<table class="table table-hover table-bordered">
				
			<tr>
				<td>Job ID</td>
				<td>Job Title</td>
				<td>Company Name</td>
			</tr>
		<c:forEach var="jobApplication" items="${myJobApplicationsList}">
			<tr>
				<td>${jobApplication.job.jobID}</td>
				<td>${jobApplication.job.jobTitle}</td>
				<td>${jobApplication.job.hr.company.companyName}</td>
			</tr>
	  	</c:forEach>
		</table>
		<br/><br/><br/><br/>	
	</div>
	
	
<%-- *******************************MENU BAR************************************** --%>

	<div class="navbar navbar-inverse navbar-static-top" id="stickyHeader">
		<a href="javascript:void(0)" class="navbar-brand" id="logo">
		<img  src="${pageContext.request.contextPath}/resources/images/logo.jpg" class="img-responsive" alt="Responsive image"  width="50px" style="margin-top:-15px"></a>
		
		<div class="container" id="topbar">
			
			<button class="navbar-toggle" data-toggle="collapse" data-target=".navHeaderCollapse" >
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			
			<div class="collapse navbar-collapse navHeaderCollapse">
				<ul class="nav navbar-nav navbar-right">
					<li class="active"><a href="#">Home</a></li>
				
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Job Network</a>
						<ul class="dropdown-menu">
							<li><a href="#">Financial Aid</a></li>
							<li><a href="#">Scholarship</a></li>
						</ul>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Career Advice<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Interview Preparation</a></li>
							<li><a href="#">Interview Questions</a></li>
							<li><a href="#">Resume Tips</a></li>
							<li><a href="#">Resume Samples</a></li>
						</ul>
					</li>
					
					<li>
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Products & Services<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="#">Resume Salary Service</a></li>
							<li><a href="#">Online Training</a></li>
							<li><a href="#">Resume Distribution Service</a></li>
						</ul>
					</li>
					
					<li><a href="#contact" data-toggle="modal">About us</a></li>
				</ul>
			</div>
			
		</div>
	</div>
	<%-- ****************************END OF MENU BAR************************************** --%>
	
	
	
<!-- *************Footer**************** -->	
    <footer>
      <div class="container">
        <p > 
			<a href="#" style="margin-left:60px;">Privacy Policy</a>
			<span style="margin-left:20px;">|</span>
			<a href="#" style="margin-left:20px;">Information</a>
			<span style="margin-left:20px;">|</span>
			<a href="#" style="margin-left:20px;">Contact Us</a>
			<span style="margin-left:20px;">|</span>
			<span style="margin-left:20px;">360 Huntington Ave., Boston, Massachusetts 02115 | 617.893.6361</span>
		</p>
      </div>
    </footer>
<!-- *************End of Footer**************** -->
		
</body>
</html>