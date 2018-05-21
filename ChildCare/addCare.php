<?php 
require_once("header.php");
require_once("config.php");
?>


<?php

$firstName = $_GET['firstName'];
$lastName = $_GET['lastName'];
$age = $_GET['age'];
$gender = $_GET['gender'];
if(array_key_exists('available', $_GET)){
	$available = "true";

}else {
	$available = "false";
}
// $available = $_GET['available'];

$query = "insert into Sitters(firstName,lastName,age,gender,available) values('{$firstName}' , '{$lastName}' , {$age}, '{$gender}' , {$available})";

if(mysqli_query($connect, $query)) { ?>
	<p class="alert-success">
	Sitter <?php echo $firstName; ?> was added with success!!</p>

<?php } else { 

	$msg = mysqli_error($connect);
?>

	<p class="alert-danger">
	The Sitter <?= $firstName ?> was not added: <?= $msg?></p>
<?php 
}
?>

<?php require_once("footer.php");