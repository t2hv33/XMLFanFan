<%-- 
    Document   : index
    Created on : Apr 21, 2015, 9:57:43 PM
    Author     : ThanhHV
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.xmlprojectContextListener"%>
<!DOCTYPE html>
<%
    String path = application.getRealPath("/");
    String fileName = path + "xml/thanh.xml";
    xmlprojectContextListener.prepareProductXML(fileName);
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<html lang="en">
    <%@ include file="header.jsp" %>    
    <script type="text/javascript" src="js/sort.js"></script>
    <script type="text/javascript" src="js/detailPage.js"></script>
    


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
                                        <img class="slide-image" src="img/banner1.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="img/banner2.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="img/banner3.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="img/banner4.jpg" alt="">
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
                    <div class="row" id="result">
                        <c:import url="xml/thanh.xml" var="xmldoc"/>
                        <c:import url="xsl/product.xsl" var="xsldoc"/>
                        <x:transform xml="${xmldoc}" xslt="${xsldoc}"/>
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
