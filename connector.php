<?php
/*connect to database*/
function connectToDB() {
		$dbhost = "acadmysql.auburn.edu";
		$username = "jdw0091";
		$password = "1234"
		$dbname = "jdw0091db"
		return $con = mysqli($servername, $username, $password, $dbname);
}
?>
