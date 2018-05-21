<?php

    include('config.php');  // include your code to connect to DB.
    include('header.php');
    
    require_once('Paginator.class.php');

    $limit      = ( isset( $_GET['limit'] ) ) ? $_GET['limit'] : 25;
    $page       = ( isset( $_GET['page'] ) ) ? $_GET['page'] : 1;
    $links      = ( isset( $_GET['links'] ) ) ? $_GET['links'] : 7;
    $query      = "SELECT id, accessLevel AS id, accessLevel FROM Provider";
 
    $Paginator  = new Paginator( $conn, $query );
 
    $results    = $Paginator->getData( $page, $limit );

   ?>
        <div class="container">
                <div class="col-md-10 col-md-offset-1">
                <h1>PHP Pagination</h1>
                <table class="table table-striped table-condensed table-bordered table-rounded">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th width="20%">Access Level</th>
                            </tr>
                        </thead>
                        <tbody>
                            <?php for( $i = 0; $i < count( $results->data ); $i++ ) : ?>
                            <tr>
                                <td><?php echo $results->data[$i]['id']; ?></td>
                                <td><?php echo $results->data[$i]['accessLevel']; ?></td>
                            </tr>
                            <?php endfor; ?>
                        </tbody>
                </table>
                </div>
        </div>
        </body>
</html>