<?php
if(isset($_POST['emailsubscibe']))
{
$subscriberemail=$_POST['subscriberemail'];
$sql ="SELECT SubscriberEmail FROM tblsubscribers WHERE SubscriberEmail=:subscriberemail";
$query= $dbh -> prepare($sql);
$query-> bindParam(':subscriberemail', $subscriberemail, PDO::PARAM_STR);
$query-> execute();
$results = $query -> fetchAll(PDO::FETCH_OBJ);
$cnt=1;
if($query -> rowCount() > 0)
{
echo "<script>;</script>";
}
else{
$sql="INSERT INTO  tblsubscribers(SubscriberEmail) VALUES(:subscriberemail)";
$query = $dbh->prepare($sql);
$query->bindParam(':subscriberemail',$subscriberemail,PDO::PARAM_STR);
$query->execute();
$lastInsertId = $dbh->lastInsertId();
if($lastInsertId)
{
echo "<script>alert('Subscribed successfully.');</script>";
}
else
{
echo "<script>alert('Something went wrong. Please try again');</script>";
}
}
}
?>



<footer>
     <link rel="stylesheet" href="./css/kuka2.css">
    <div class="footer-top">
        <div class="container">
            <div class="row">

                <div class="about">
                    <h6>About Us</h6>
                    <ol>


                        <li><a href="#">About Us</a></li>
                        <li><a href="#">FAQs</a></li>
                        <li><a href="#">Privacy</a></li>
                        <li><a href="#">Terms of use</a></li>
                        <li><a href="./admin/index.php">Admin Login</a></li>
                    </ol>
                </div>

                <div class="news">
                    <h6>Subscribe Newsletter</h6>
                    <div class="newsletter-form">
                        <form method="post">
                            <div class="form-group">
                                <input type="email" name="subscriberemail" class="form-control newsletter-input" required placeholder="Enter Email Address" />
                            </div>
                            <button type="submit" name="emailsubscibe" class="subs">Subscribe <span class="angle_arrow"><i class="fa fa-angle-right" aria-hidden="true"></i></span></button>
                        </form>
                        <p class="subscribed-text">*We send great deals and latest auto news to our subscribed users very week.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer-bottom">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-pull-6">
                    <p class="copy-right">Copyright &copy; 2021 CarHub.</p>
                </div>
            </div>
        </div>
    </div>
</footer>