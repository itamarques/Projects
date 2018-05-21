<?php
require_once 'config.php';
require_once("header.php");



?>
	  <style type="text/css">
        body{ font: 14px sans-serif; text-align: center; 
        		padding-top: 20px;
        }
    </style>
    <div class="page-header">
        <h1>Hi, <b><?php echo $_SESSION['username']; ?></b>. Registration successfull</h1>
        <p class="text-success"> You are logged in as 
    <?= $_SESSION['username']; ?>
    </div>
    <p><a href="logout.php" class="btn btn-danger">Sign Out of Your Account</a></p>



<?php include("footer.php");
