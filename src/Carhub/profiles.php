<?php
session_start();
error_reporting(0);
include('config.php');
if(strlen($_SESSION['login'])==0)
{
    header('location:index.php');
}
else{
    if(isset($_POST['updateprofile']))
    {
        $name=$_POST['fullname'];
        $mobileno=$_POST['mobilenumber'];
        $dob=$_POST['dob'];
        $adress=$_POST['address'];
        $city=$_POST['city'];
        $country=$_POST['country'];
        $email=$_SESSION['login'];
        $sql="update tblusers set FullName=:name,ContactNo=:mobileno,dob=:dob,Address=:adress,City=:city,Country=:country where EmailId=:email";
        $query = $dbh->prepare($sql);
        $query->bindParam(':name',$name,PDO::PARAM_STR);
        $query->bindParam(':mobileno',$mobileno,PDO::PARAM_STR);
        $query->bindParam(':dob',$dob,PDO::PARAM_STR);
        $query->bindParam(':adress',$adress,PDO::PARAM_STR);
        $query->bindParam(':city',$city,PDO::PARAM_STR);
        $query->bindParam(':country',$country,PDO::PARAM_STR);
        $query->bindParam(':email',$email,PDO::PARAM_STR);
        $query->execute();
        $msg="Profile Updated Successfully";
    }

    ?>
    <!DOCTYPE HTML>
    <html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <title>Car Rental Portal | My Profile</title>
        <!--Bootstrap -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
        <!--Custome Style -->
        <link rel="stylesheet" href="assets/css/style.css" type="text/css">
        <!--OWL Carousel slider-->
        <link rel="stylesheet" href="assets/css/owl.carousel.css" type="text/css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css" type="text/css">
        <!--slick-slider -->
        <link href="assets/css/slick.css" rel="stylesheet">
        <!--bootstrap-slider -->
        <link href="assets/css/bootstrap-slider.min.css" rel="stylesheet">
        <!--FontAwesome Font Style -->
        <link href="assets/css/font-awesome.min.css" rel="stylesheet">

        <!-- SWITCHER -->
        <link rel="stylesheet" id="switcher-css" type="text/css" href="assets/switcher/css/switcher.css" media="all" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/red.css" title="red" media="all" data-default-color="true" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/orange.css" title="orange" media="all" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/blue.css" title="blue" media="all" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/pink.css" title="pink" media="all" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/green.css" title="green" media="all" />
        <link rel="alternate stylesheet" type="text/css" href="assets/switcher/css/purple.css" title="purple" media="all" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/images/favicon-icon/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/images/favicon-icon/apple-touch-icon-114-precomposed.html">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/images/favicon-icon/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/images/favicon-icon/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="assets/images/favicon-icon/favicon.png">
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900" rel="stylesheet">

    </head>
    <body>

    <!-- Start Switcher -->

    <!-- /Switcher -->

    <!--Header-->

    <!-- /Header -->
    <!--Page Header-->
    <!-- /Page Header-->

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
            height: 1000px;
            background: #ffa31a;
            color: black;
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
        .modal-footer text-center p{
            align-items: center;
            display: block;
            margin-left: auto;
            margin-right: auto
        }



        h3{
            margin: 0;
            padding: 0 0 20px;
            text-align: center;
            font-size: 22px;
            color: black;
        }

        .form-group input[type="text"], input[type="password"]{
            border: 1px solid #fff;
            background: transparent;
            outline: none;
            height: 20px;
            color: black;
            font-size: 16px;
        }
        .form-control.white_bg {
            background:transparent;
            border-bottom:#e6e5e5 solid 1px;
        }

        .form-group input[type="text"], input[type="email"]{
            border: 1px solid #fff;
            background: transparent;
            outline: none;
            height: 20px;
            color: black;
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
        .modal-content{

        }
    </style>
    <?php
    $useremail=$_SESSION['login'];
    $sql = "SELECT * from tblusers where EmailId=:useremail";
    $query = $dbh -> prepare($sql);
    $query -> bindParam(':useremail',$useremail, PDO::PARAM_STR);
    $query->execute();
    $results=$query->fetchAll(PDO::FETCH_OBJ);
    $cnt=1;
    if($query->rowCount() > 0)
    {
    foreach($results as $result)
    { ?>
    <div class="modal-fade" id="updateform">
        <div class="modal-header">
            <button type="button"  class="close" data-dismiss="modal" aria-label="Close"><a href="login.php"> <img src="krest.png" width="10" height="10" alt=""></a> </button>
            <h3 class="modal-title">Sign Up</h3>
            <?php
            /*                    if($msg){*/?><!--<div class="succWrap"><strong>SUCCESS</strong>:<?php /*echo htmlentities($msg); */?> </div>--><?php /*}*/?>
        </div>
        <form  role="form" class="form-horizontal" method="post" name="signup" onSubmit="return valid();">
            <div class="form-group">
                <label class="control-label">Reg Date -</label>
                <?php echo htmlentities($result->RegDate);?>
            </div>
            <?php if($result->UpdationDate!=""){?>
                <div class="form-group">
                    <label class="control-label">Last Update at  -</label>
                    <?php echo htmlentities($result->UpdationDate);?>
                </div>
            <?php } ?>
            <div class="form-group">
                <label class="control-label">Full Name</label>
                <input class="form-control white_bg" name="fullname" value="<?php echo htmlentities($result->FullName);?>" id="fullname" type="text"  required>
            </div>
            <div class="form-group">
                <label class="control-label">Email Address</label>
                <input class="form-control white_bg" value="<?php echo htmlentities($result->EmailId);?>" name="emailid" id="email" type="email" required readonly>
            </div>
            <div class="form-group">
                <label class="control-label">Phone Number</label>
                <input class="form-control white_bg" name="mobilenumber" value="<?php echo htmlentities($result->ContactNo);?>" id="phone-number" type="text" required>
            </div>
            <div class="form-group">
                <label class="control-label">Date of Birth&nbsp;(dd/mm/yyyy)</label>
                <input class="form-control white_bg" value="<?php echo htmlentities($result->dob);?>" name="dob" placeholder="dd/mm/yyyy" id="birth-date" type="text" >
            </div>
            <style>
                textarea {
                    width: 90%; /* Ширина поля в процентах */
                    height: 200px; /* Высота поля в пикселах */
                    resize: none; /* Запрещаем изменять размер */
                }
            </style>
            <div class="form-group">
                <label class="control-label">Your Address</label>
                <textarea class="form-control white_bg" name="address" rows="4" ><?php echo htmlentities($result->Address);?></textarea>
            </div>
            <div class="form-group">
                <label class="control-label">Country</label>
                <input class="form-control white_bg"  id="country" name="country" value="<?php echo htmlentities($result->Country);?>" type="text">
            </div>
            <div class="form-group">
                <label class="control-label">City</label>
                <input class="form-control white_bg" id="city" name="city" value="<?php echo htmlentities($result->City);?>" type="text">
            </div>
            <?php }} ?>
            <center>
            <div class="form-group">
                <button type="submit" name="updateprofile" class="btn">Save Changes <span class="angle_arrow"><i class="fa fa-angle-right" aria-hidden="true"></i></span></button>
            </div>
            </center>
        </form>

        <div class="modal-dialog" role="document">
        </div>
    </div>
    <!--/Profile-setting-->

    <<!--Footer -->

    <!-- /Footer-->

    <!--Back to top-->
    <div id="back-top" class="back-top"> <a href="#top"><i class="fa fa-angle-up" aria-hidden="true"></i> </a> </div>
    <!--/Back to top-->

    <!--Login-Form -->

    <!--/Forgot-password-Form -->

    <!-- Scripts -->
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/interface.js"></script>
    <!--Switcher-->
    <script src="assets/switcher/js/switcher.js"></script>
    <!--bootstrap-slider-JS-->
    <script src="assets/js/bootstrap-slider.min.js"></script>
    <!--Slider-JS-->
    <script src="assets/js/slick.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>

    </body>
    </html>
<?php } ?>