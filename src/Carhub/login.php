<?php 
session_start();
include('config.php');
error_reporting(0);
?>
<?php
if(isset($_POST['login']))
{
$email=$_POST['email'];
$password=md5($_POST['password']);
$sql ="SELECT EmailId,Password,FullName FROM tblusers WHERE EmailId=:email and Password=:password";
$query= $dbh -> prepare($sql);
$query-> bindParam(':email', $email, PDO::PARAM_STR);
$query-> bindParam(':password', $password, PDO::PARAM_STR);
$query-> execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
if($query->rowCount() > 0)
{
$_SESSION['login']=$_POST['email'];
$_SESSION['fname']=$results->FullName;
$currentpage=$_SERVER['REQUEST_URI'];
echo "<script type='text/javascript'> document.location = 'index2.php';  </script>";
} else{
  
  echo "<script>alert('Invalid Details');</script>";

}

}

?>
<style type="text/css">
  body{
  margin: 0;
  padding: 0;
  background-color: black;
  background-size: cover;
  font-family: sans-serif;
}

.modal-fade {
  width: 400px;
  height: 500px;
  background: #ffa31a;
  color: #fff;
  top: 50%;
  left: 50%;
  position: absolute;
  transform: translate(-50%,-50%);
  box-sizing: border-box;
  padding: 70px 30px;
}

.form-group input{
  width: 100%;
  margin-bottom: 20px;
}



h3{
  margin: 0;
  padding: 0 0 20px;
  text-align: center;
  font-size: 22px;
  color: black;
}

.form-group input[type="text"], input[type="password"]{
  border: none;
  border-bottom: 1px solid #fff;
  background: transparent;
  outline: none;
  height: 20px;
  color: #fff;
  font-size: 16px;
}

.form-group input[type="text"], input[type="email"]{
  border: none;
  border-bottom: 1px solid #fff;
  background: transparent;
  outline: none;
  height: 20px;
  color: #fff;
  font-size: 16px;
}

.form-group input[type="submit"]{
  margin-top: 25px;
  width: 265px;
  border: none;
  outline: none;
  height: 40px;
  background: black;
  color: white;
  font-size: 18px;
}

.close{
  background-image: url("https://img.favpng.com/12/1/0/back-button-png-favpng-FSBzU9PGVTL07E2V0wpZnUbKk.jpg");
}

.modal-footer a{
  text-decoration: none;
  font-size: 12px;
  line-height: 20px;
  color: black;
}

.modal-footer a:hover{
  color: white;
}
</style>
<div class="modal-fade" id="loginform">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button"  class="close" data-dismiss="modal" aria-label="Close"><a href="index.php"> <img src="krest.png" width="10" height="10" alt=""></a> </button>
        <h3 class="modal-title">Login</h3>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="login_wrap">
            <div class="col-md-12 col-sm-6">
              <form method="post">
                <div class="form-group">
                  <input type="email" class="form-control" name="email" placeholder="Email address*">
                </div>
                <div class="form-group">
                  <input type="password" class="form-control" name="password" placeholder="Password*">
                </div>
                <div class="form-group-checkbox">
                  <input type="checkbox" id="remember">
               
                </div>
                <div class="form-group">
                  <input type="submit" name="login" value="Login" class="btn btn-block">
                </div>
              </form>
            </div>
           
          </div>
        </div>
      </div>
      <div class="modal-footer text-center">
        <p>Don't have an account? <a href="registration.php" data-toggle="modal" data-dismiss="modal">Signup Here</a></p>
        <p><a href="forgotpass.php" data-toggle="modal" data-dismiss="modal">Forgot Password ?</a></p>
      </div>
    </div>
  </div>
</div>