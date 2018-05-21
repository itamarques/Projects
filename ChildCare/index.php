<?php include("header.php");
	include("config.php");

	if(!isset($_SESSION['username'])) {
    	include("login.php"); 
 	}else{ ?>
 	<div class="top">
 		<h2>Welcome To Child Care Finder</h2>
 		<h4>"Your Search is Over"</h4>
 	</div>
<?php 
}
include("footer.php");?>

