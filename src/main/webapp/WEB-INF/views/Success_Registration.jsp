<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Login Page.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>

<body style="background-image: none">
	
<%-- *******************************Main Body************************************** --%>
	<div id="h1">
		<h1 >Success !! Registration is successful.</h1>
		<h4>Please hit below button to go back & login</h4><br/>
		<form:form action="home" method="post">
			<input type="Submit" value="Go Back" class="btn btn-primary" />
		</form:form>
	</div>
	
<%-- *******************************End of Main Body************************************** --%>	
	

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