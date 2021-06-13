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
	<title>CarHub</title>
	<link rel="stylesheet" href="./css/kuka3.css">
	<script src="./js/java.js"></script>

	

</head>
<body>    
<!--Header-->
<?php include('header.php');?>
<!-- /Header -->



    <!--Banner-->
    <section id="banner" class="banner-section">
  <div class="container">
    <div class="div_zindex">
      <div class="row">
        <div class="col-md-5 col-md-push-7">
          <div class="banner_content">
            <h1 class="qwer">Find the ideal car for you.</h1>
            <p>Save money on rental cars by searching for car rental deals on Carhub. Carhub searches for rental car deals on hundreds of car rental sites to help you find the cheapest car rental. Whether you are looking for an airport car rental or just a cheap car rental near you, you can compare discount car rentals and find the best deals faster at Carhub.</p>
        </div>
      </div>
    </div>
  </div>
</section>
    <!-- /Banner -->


    <!--Recent-->
    <main class="notforall">
    	<?php include('recent.php');?>
    </main>
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
 
          <div class="testimonial-content" style="
    padding-right: 0px;
    padding-left: 0px;
">
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
</div>
<?php include('footer.php');?>

<!--/Footer-->






</body>

</html>