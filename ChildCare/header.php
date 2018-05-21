<html>   
<head>
      <title>Childcare Finder</title>
      <link href="css/bootstrap.css" rel="stylesheet">
	  <link href="care.css" rel="stylesheet">
	  
</head>
<body>	
	<div class="container">
		<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="index.php">Child Care Finder</a>
			    <title>Childcare Finder</title>
		</div>
		<div>
			<ul class="nav navbar-nav">
				<li><a href="profile.php">Profile</a></li>
				<li><a href="list-sitters.php">List of Available BabySitter</a></li>
				<li><a href="care-form.php">Add Care</a></li>
				<?php 
					include("config.php");
					if(isset($_SESSION['username'])) {
				?>
					<li><a href="logout.php">Log out</a></li>
				<?php	} else { ?>

					<li><a href="register.php">Register</a></li>
				<?php } ?>	
			</ul>
		</div>
	</div>


		





