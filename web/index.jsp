<%-- 
    Document   : index
    Created on : Apr 21, 2015, 9:57:43 PM
    Author     : ThanhHV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.xmlprojectContextListener"%>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="header.jsp" %>    


    <body>
        <!-- Navigation -->
        <%@ include file="navigation.jsp" %>    
        <!-- Page Content -->
        <div class="container">
            <div class="row">
                <%@ include file="menu.jsp" %>    
                <div class="col-md-9">
                    <div class="row carousel-holder">
                        <div class="col-md-12">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img class="slide-image" src="images/banner1.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="images/banner2.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="images/banner3.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="images/banner4.jpg" alt="">
                                    </div>
                                </div>
                                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>
                    </div>
                    <!--Chỗ ADD Product transfom jstl+doc-->
                    <div class="row">

                        
                        
                        
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="images/banner1.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">$24.99</h4>
                                    <h4><a href="product-detail.jsp">First Product</a>
                                    </h4>
                                    <p>See more snippets like this online store item at</p>
                                </div>
                                <div class="ratings">
                                    <p class="pull-right">15 reviews</p>
                                    <p>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                        <span class="glyphicon glyphicon-star"></span>
                                    </p>
                                </div>
                            </div>
                        </div>



                    </div>

                </div>

            </div>

        </div>
        <!-- /.container Footer -->
        <%@ include file="footer.jsp" %>    
        <!-- /.container -->

        <!-- jQuery -->
        <script src="js/jquery.js"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min.js"></script>

    </body>

</html>
