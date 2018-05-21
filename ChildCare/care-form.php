<?php 
include("header.php");
require_once("config.php");

if(!isset($_SESSION['username']) || !isset($_SESSION['accessLevel'])) {
	header("location: login.php");
} 

if($_SESSION['accessLevel'] ==1) { ?>
<div class="registration-form">
	<h1> Registration Form</h1>

	<form action="addcare.php" class="form">
		<table class="table">
			<tr>
				<td>First Name:</td>
				<td><input class="form-control" type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input class="form-control" type="text" name="lastName"></td>
				</tr>
			<tr>
				<td>Age:</td>
				<td><input class="form-control"type="number" name="age"></td>
			</tr>

			<tr>
				<td>Gender:</td>
				<td><input class="form-control" type="text" name="gender"></td>
			</tr>

			<tr>
			<td></td>
			<td><input type="checkbox" name="available" <?=$available?> value="true">
		Available</td>	

	</tr>
		</table>


	<button class="btn btn-primary" type="submit" value="Register">Register<br/>
</form>

<?php 

	
} else {
	echo "no permission";
	header("Location: index.php");
	//header("Refresh: 2; url=index.php", true, 303);
}
?>


<?php require_once("footer.php");





