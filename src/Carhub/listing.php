<?php 
session_start();
include('config.php');
error_reporting(0);
?>
<!DOCTYPE HTML>
<html lang="en">
<head>
	<link rel="stylesheet" href="./css/kuka2.css">
	
	<link href="assets/css/font-awesome.min.css" rel="stylesheet">

	<style>
   li {
    list-style-type: none; 
   }
   ul {
    margin-left: 0; 
    padding-left: 0; 
   }
  </style>
</head>
<body>
	<?php include('headerwithout.php');?>
	
  <div class="container">
    <div class="row">
      <div class="col-md-9 col-md-push-3">

<?php 
//Query for Listing count
$sql = "SELECT id from tblvehicles";
$query = $dbh -> prepare($sql);
$query->bindParam(':vhid',$vhid, PDO::PARAM_STR);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
$cnt=$query->rowCount();
?>
<p class="listings"><span><?php echo htmlentities($cnt);?> Listings</span></p>
</div>
</div>
 <div class="header_search">
          <div id="search_toggle"><i class="fa fa-search" aria-hidden="true"></i></div>
          <form action="search.php" method="post" id="header-search-form">
            <input type="text" placeholder="Search..." name="searchdata" class="form-control-search" required="true">
            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
          </form>
        </div>

<?php $sql = "SELECT tblvehicles.*,tblbrands.BrandName,tblbrands.id as bid  from tblvehicles join tblbrands on tblbrands.id=tblvehicles.VehiclesBrand";
$query = $dbh -> prepare($sql);
$query->execute();
$results=$query->fetchAll(PDO::FETCH_OBJ);
$cnt=1;
if($query->rowCount() > 0)
{
foreach($results as $result)
{  ?>
        <div class="product-listing-m gray-bg">
        <div class="all_d">
          <div class="product-listing-img"><img src="./img/vehicleimages/<?php echo htmlentities($result->Vimage1);?>" class="img-responsive" alt="Image" /> </a> 
          </div>
          <div class="listd">
          <h5 class="list_name"><a href="vehical-details.php?vhid=<?php echo htmlentities($result->id);?>"><?php echo htmlentities($result->BrandName);?> , <?php echo htmlentities($result->VehiclesTitle);?></a></h5>
          <div class="product-listing-content">
            <p class="list-price">$<?php echo htmlentities($result->PricePerDay);?> Per Day</p>
            <ul class="machine">
              <li><i class="fa fa-user" aria-hidden="true"></i><?php echo htmlentities($result->SeatingCapacity);?> seats</li>
              <li><i class="fa fa-calendar" aria-hidden="true"></i><?php echo htmlentities($result->ModelYear);?> model</li>
              <li><i class="fa fa-car" aria-hidden="true"></i><?php echo htmlentities($result->FuelType);?></li>
            </ul>
            <a href="vehical-details.php?vhid=<?php echo htmlentities($result->id);?>" class="btn">View Details <span class="angle_arrow"><i class="fa fa-angle-right" aria-hidden="true"></i></span></a>
            </div>
          </div>
        </div>
      <?php }} ?>
         </div>
                 
        </select>
              

        
    </div>
  </div>
</section>
<!-- /Listing--> 

<!--Footer -->
<?php include('footer.php');?>
<!-- /Footer--> 

</body>