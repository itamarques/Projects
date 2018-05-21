<?php
   $connect = mysqli_connect("localhost", "root", "itamar", "ChildCare");
   session_start();
   
   // Check connection
if($connect=== false){
    die("ERROR: Could not connect. " . mysqli_connect_error());
}
// good practicing not closing if there is only php code