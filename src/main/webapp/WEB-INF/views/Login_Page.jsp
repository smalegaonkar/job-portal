<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Login Page.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	
	<link href="${pageContext.request.contextPath}/resources/css/jquery-ui-1.10.4.custom.css" rel="stylesheet">
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/jquery-ui-1.10.4.custom.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/autocomplete.js"> </script>
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>

<body>
	
	<!-- ****************************Search Box************************************** -->	
	<div class="col-sm-6 col-sm-offset-2" id="search">
        <form class="navbar-form" role="search">
			<div class="input-group">
				<input type="text" id="tags" class="form-control input-lg" placeholder="Search Jobs" name="srch-term" id="srch-term">
				<div class="input-group-btn">
					<button id="tags" class="btn btn-primary btn-lg" id="tags" type="submit"><i class="glyphicon glyphicon-search"></i></button>
					 
				</div>
			</div>
			
        </form>
    </div>
	
<!-- ****************************END OF Search Box************************************** -->
	
	<div class="clear"></div>
	
	<div class="row">	
	
		<div class="col-sm-5 col-sm-offset-2">
			<div class="info">
			
					<h1 id="h1">Welcome to the Job Portal</h1>
				
					<div class="content">
						<strong>Register yourself with us and let us help you to find your dream job</strong>
						<div class="clearfix"></div>
						<div style="margin-top:10px; margin-bottom:35px">
							<form:form action="candidateRegistration" method="post">
								<input type="submit" value="Register as Job Seeker" class="btn btn-primary" style="float:left;margin-right:15px"/>
							</form:form>
							
							 <form:form action="HrRegistration" method="post">
								<input type="submit" value="Register as HR" class="btn btn-primary" style="float:left;"/>
							</form:form>
						</div>
					</div>

					<div class="footer">
						<div title="We are available on Apple store. Download our mobile app Now" style="float:left; margin-right:10px"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/Apple.png" class="img-responsive" width="135px" alt="Responsive image"></a></div>
						<div title="We are available on google Android. Download our mobile app Now" style="float:left"><a href="#"><img src="${pageContext.request.contextPath}/resources/images/android.png" class="img-responsive" width="135px" alt="Responsive image"></a></div>
						<div class="clear"></div>
					</div>
			</div>
		</div>	
		
		
		<div class="col-sm-3">
			<div class="login-form" >
				
				<h1 id="h1">Log In</h1>
				
				<form:form action="LoginSuccess" method="post" commandName="user_Account">
					<div class="content">
						<form:input path="emailID"  type="text" class="form-control" id="input" placeholder="Username" required="true"/><br/>
						<form:input path="password" type="password" class="form-control" id="input" placeholder="Password" required="true"/>
					</div>

					<div class="footer">
						<input type="submit" value="Login" class="btn btn-success btn-lg btn-block" style="font-weight:bold"/>
						<div class="checkbox">
							<label><input type="checkbox">Remember me</label>
						</div>
					</div>
				</form:form>
			</div>
		</div>	
	</div>
	<br/><br/>
<%-- ****************************END OF MAIN BODY************************************** --%>
	
	
	
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
	
	
	<%-- *******************************ABOUT US************************************** --%>	
	<div class="modal fade" id="contact" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				
				<div class="modal-header">
					<h3>Who We Are</h3>
				</div>
				<div class="modal-body">
					<p>We are the premier global online employment solution for people seeking jobs and the employers who need great people.
					We've been doing this for over many years, and have expanded from our roots as a "job board" to a global provider of a
					full array of job seeking, career management, recruitment and talent management products and services.</p>
					<p> At the heart of our success and our future is innovation: we are changing the way people think about work, and we're 
					helping them actively improve their lives and	their workforce performance with new technology, tools and practices.</p>
				</div>
				<div class="modal-footer">
					<a class="btn btn-warning" data-dismiss="modal">Close</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>