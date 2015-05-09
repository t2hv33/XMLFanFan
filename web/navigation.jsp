<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <script type="text/javascript" src="js/detailPage.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"><span class="glyphicon glyphicon-home"></span>Fan Fan</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a href="#">Khuyến Mãi</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicons glyphicons-earphone" aria-hidden="true"></span> Bản Đồ</a>
                </li>
                <li>
                    <a href="#">Hỗ Trợ?</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>Giỏ Hàng</a>
                </li>


                <c:if test="${empty sessionScope.account}">
                    <li>
                        <a href="login.jsp"><span class="glyphicon glyphicon-play" aria-hidden="true"></span>Đăng Nhập</a>
                    </li>
                </c:if>
                <c:if test="${not empty sessionScope.account}">
                    <li>
                        <a href="#"><span aria-hidden="true" class="glyphicon glyphicon-user"></span>Welcome <b>${sessionScope.account.username}</b></a>
                    </li>

                    <c:if test="${sessionScope.account.role =='Admin'}">
                        <li>
                            <a href="#"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Manage Product</a>
                        </li>
                    </c:if>
                    <li>
                        <a href="AccountController?action=Logout"><span aria-hidden="true">Logout</span></a>
                    </li>
                </c:if>
            </ul>  
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>