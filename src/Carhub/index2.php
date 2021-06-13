<?php 
session_start();
include('config.php');
error_reporting(0);
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Online Car Rental System</title>
  <link rel="stylesheet" href="./css/kuka2.css">
  <script src="./js/java.js"></script>
</head>
<body>    
<!--Header-->
<header class="nachalo">
        <div class="wrapper">
            <div class="nachalo__wrapper">
                <div class="nachalo__logo">
                    <a href="#menu" class="nachalo__connect js-scroll">
                        <img src="./img/logo.png" alt="kukafs" class="nachalo__logo-connect" style=" max-width: 100%;
    height: auto;">
                    </a>
                </div>
    
                <nav class="kukasd">
                     <ul class="nachalo__vse">
                        <li class="nachalo__icon">
                            <a href="index2.php" class="nachalo__connect js-scroll">Menu</a>
                        </li>
                        
                        <li class="nachalo__icon">
                            <a href="aboutus.php" class="nachalo__connect js-scroll">About us</a>
                        </li>
                        <li class="nachalo__icon">
                            <a href="listing.php" class="nachalo__connect js-scroll">Car Listing</a>
                        </li>
                        <li class="nachalo__icon">
                            <a href="./contactus.php" class="nachalo__connect js-scroll">Contact Us</a>
                        </li>
                        <li class="nachalo__icon">
                          <div class="dropdown">
    <button class="dropbtn">Panel 
      <i class="fa fa-caret-down"></i>
    </button>
    <div class="dropdown-content">
      <a href="profiles.php">Profile Settings</a>
      <a href="update.php">Update Password</a>
      <a href="my-booking.php">My Booking</a>
      <a href="my-testimonials.php">My Testimonials</a>
      <a href="index.php">Sign Out</a>
    </div>
  </div> </a>
           
                        </li>
                    </ul>
                    
          <div class="nachalo__nav-close">
            <span class="nachalo__nav-close-line"></span>
            <span class="nachalo__nav-close-line"></span>
          </div>
        </nav>
        <div class="nachalo__burger burger">
          <span class="burger__line burger__line_first"></span>
          <span class="burger__line burger__line_second"></span>
          <span class="burger__line burger__line_third"></span>
        </div>
            </div>
        </div>

    </header>
    <div class="video">
      <video class="video__media" src="./img/toyota.mp4" autoplay muted loop></video>
    </div>


    <script src="./js/java.js"></script>
    <!-- /Header -->

    <!--Banner-->
    <section id="banner" class="banner-section">
  <div class="container">
    <div class="div_zindex">
      <div class="row">
        <div class="col-md-5 col-md-push-7">
          <div class="banner_content">
            <h1>Find the ideal car for you.</h1>
            <p>Save money on rental cars by searching for car rental deals on Carhub. Carhub searches for rental car deals on hundreds of car rental sites to help you find the cheapest car rental. Whether you are looking for an airport car rental or just a cheap car rental near you, you can compare discount car rentals and find the best deals faster at Carhub.</p>
        </div>
      </div>
    </div>
  </div>
</section>
    <!-- /Banner -->


      <?php include('recent.php');?>

<!-- /Recent -->
<section class="section-padding testimonial-section parallex-bg">
  <div class="container div_zindex">
    <div class="section-header white-text text-center">
      <h2 class="satis">Review</h2> 

    <div class="row">
      <div id="testimonial-slider">
<?php 
$tid=1;
$sql = "SELECT tbltestimonial.Testimonial,tblusers.FullName from tbltestimonial join tblusers on tbltestimonial.UserEmail=tblusers.EmailId where tbltestimonial.status=:tid limit 4";
$query = $dbh -> prepare($sql);
$query->bindParam(':tid',$tid, PDO::PARAM_STR);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
$cnt=1;
if($query->rowCount() > 0)
{
foreach($results as $result)
{  ?>


        <div class="testimonial-m">
 
          <div class="testimonial-content">
            <div class="testimonial-heading">
              <h5><?php echo htmlentities($result->FullName);?></h5>
            <p><?php echo htmlentities($result->Testimonial);?></p>
          </div>
        </div>
        </div>
        <?php }} ?>
        
       
  
      </div>
    </div>
  </div>

</section>

<?php include('footer.php');?>

<!--/Footer-->



    <script src="./js/java.js"></script>



</body>

</html>