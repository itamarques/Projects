<?php 
require_once("header.php");
require_once("config.php");

if(!isset($_SESSION['username']) || !isset($_SESSION['accessLevel'])) {
	header("location: login.php");
} 


function listOfSitters($connect) {
	$sitters = array();
	$result = mysqli_query($connect, "select * from Sitters");
	while($sitter = mysqli_fetch_assoc($result)){
		array_push($sitters, $sitter);
	}
	return $sitters;
}
?>
<br/>
<table class="table table-striped table-bordered">


	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Age </td>
		<td>Gender</td>
		<td>Available</td>
		<td></td>
	</tr>


	<?php 
	$sitters = listOfSitters($connect);
	foreach($sitters as $sitter) : ?>
	
	<tr>	
		<td><?=$sitter['FirstName']?></td>
		<td><?=$sitter['LastName'] ?></td>
		<td><?=$sitter['Age']?></td>
		<td><?=$sitter['Gender']?></td>
		<td><?=$sitter['available']?></td>

	
		
		<!-- <td><input type="checkbox" name="used" <?=$used?> value="true"> -->

		<td><a class="btn btn-primary" href="remove-sitter.php?id=<?=$sitter['id']?>" class="text-danger">Remove</a></td>
	</tr>


	<?php
	endforeach
	?>
</table>


<?php require_once("footer.php");  ?>