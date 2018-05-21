<?php require_once("header.php");
	  require_once("config.php");

function removeSitter($connect, $id) {
	$query = "delete from sitters where id = {$id}";
	return mysqli_query($connect,$query);
}


$id = $_GET['id'];
removeSitter($connect, $id);
header("Location: list-sitters.php")
?>

<p class="text-success">Sitter <?= $id ?> Remove</p>