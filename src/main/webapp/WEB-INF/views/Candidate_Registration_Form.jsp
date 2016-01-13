<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html>
<head>
    <title>Candidate Registration</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="utf-8">
	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/Login Page.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/footer.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.css">
	
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</head>

<body style="background-image: none">

    <div class="container" style="margin-left:60px">
    	
    	<form:form action="home" method="post">
              <input type="Submit" value="Go Back" class="btn btn-warning" />
        </form:form>
    	
      
         <h1 id="h1" style="margin-top: -10px;font-size:35px;margin-left:-30px">Candidate Registration</h1>
         <h5 style="color:red;">*All fields are required</h5>
		 <form:form name="registration-form" action="RegisterUser" method="post" class="registration-form" commandName="job_Seeker">
            
            <h3>Personal Information</h3>
			
			<div class="form-group">
				<label  class="col-sm-2 control-label">First Name</label>
					<div class="row"><div class="col-md-4">
					<form:input path="first_name" type="text" id="textbox" class="form-control" placeholder="First Name" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Last Name</label>
					<div class="row"><div class="col-md-4">
					<form:input path="last_name" type="text" id="textbox" class="form-control" placeholder="Last Name" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Mobile</label>
					<div class="row"><div class="col-md-4">
					<form:input path="contact_number" type="number" min="10000" id="textbox" class="form-control" placeholder="617-000-9999" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Date of Birth</label>
					<div class="row"><div class="col-md-4">
					<form:input path="dateOfBirth" type="date" id="textbox" class="form-control" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Street</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.street" type="text" id="textbox" class="form-control" placeholder="street Name, Apt Number" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">City</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.city" type="text" id="textbox" class="form-control" placeholder="city" required="true"/></div></div>
			</div>
			
			
			<div class="form-group">
				<label class="col-sm-2 control-label">State</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.state" type="text" id="textbox" class="form-control" placeholder="state" required="true"/></div></div>
			</div>
            
            <div class="form-group">
				<label class="col-sm-2 control-label">Country</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.country" type="text" id="textbox" class="form-control" placeholder="country" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Zip Code</label>
					<div class="row"><div class="col-md-4">
					<form:input path="address.zipcode" type="number" min="1000" id="textbox" class="form-control" placeholder="e.g.02120" required="true"/></div></div>
			</div>
			
			<hr id="hr">
			
			
			<h3>Qualifications</h3>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Degree</label>
					<div class="row"><div class="col-md-4">
						<form:input path="degree" type="text" id="textbox" class="form-control" placeholder="e.g. Master of Science" required="true"/>
					</div></div>
			</div>
            
            <div class="form-group">
				<label class="col-sm-2 control-label">Major</label>
					<div class="row"><div class="col-md-4">
					<form:input path="major" type="text" id="textbox" class="form-control" placeholder="e.g. Computer Science" required="true"/></div></div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label">Work Experience</label>
					<div class="row"><div class="col-md-4">
					<form:input path="work_experience"  type="number" id="textbox" class="form-control" placeholder="in months" required="true"/></div></div>
			</div>
 
            <hr id="hr">
            
            
            <div class="form-group">
				<label class="col-sm-2 control-label">LinkedIn URL</label>
					<div class="row"><div class="col-md-4">
					<form:input path="linkedInUrl" type="url" id="textbox" class="form-control" placeholder="https://www.LinkedIn.com/swapnil" required="true"/></div></div>
			</div>
			
			<div class="form-group">
			    <label class="col-sm-2 control-label">Attach a Resume</label>
			    <div class="row"><div class="col-md-4"><input type="file" id="exampleInputFile">
			    <p class="help-block">Include only pdf or word file</p></div></div>
			</div>
			
			<hr id="hr">
            
			
            <h3>Create Login</h3>
			
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
					<div class="row"><div class="col-md-4">
					<form:input path="user_Account.emailID" type="email" id="textbox" class="form-control" placeholder="Email@email.com" required="true"/></div></div>
			</div>
			
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
				  <div class="row"><div class="col-md-4">
				  <form:input path="user_Account.password" type="password" id="textbox" class="form-control" placeholder="Password" required="true"/></div></div>
			  </div>
			  
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">Confirm Password</label>
				  <div class="row"><div class="col-md-4">
				  <input type="password" id="textbox" class="form-control" placeholder="Password" required/></div></div>
			  </div>
            
            <!-- <a type="button" href="Login Page.html" class="btn btn-default">Cancel</a> -->
			<input type="submit" value="Submit" class="btn btn-success btn-lg" style="font-weight:bold"/>
			
        </form:form>

     </div>
     <br/><br/></br><br/>
	
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