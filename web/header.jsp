<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>XML LEO N&#218;I – TREKKING – D&#195; NGOẠI | SHOP ĐỒ DU LỊCH TP.HCM, ĐỒ ĐI PHƯỢT, LEO N&#218;I, D&#195; NGOẠI - THE TRAVEL SHOP</title>
    <link rel="SHORTCUT ICON" href="img/fav.ico">
    <meta name="author" content="ThanhHV">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/shop-homepage.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style type="text/css">
        /*********************************************
                        Call Bootstrap
*********************************************/

        /*********************************************
                                Theme Elements
        *********************************************/

        .gold{
            color: #FFBF00;
        }

        /*********************************************
                                                PRODUCTS
        *********************************************/

        .product{
            border: 1px solid #dddddd;
            height: 321px;
        }

        .product>img{
            max-width: 230px;
        }

        .product-rating{
            font-size: 20px;
            margin-bottom: 25px;
        }

        .product-title{
            font-size: 20px;
        }

        .product-desc{
            font-size: 14px;
        }

        .product-price{
            font-size: 22px;
        }

        .product-stock{
            color: #74DF00;
            font-size: 20px;
            margin-top: 10px;
        }

        .product-info{
            margin-top: 50px;
        }

        /*********************************************
                                                VIEW
        *********************************************/

        .content-wrapper {
            max-width: 1140px;
            background: #fff;
            margin: 0 auto;
            margin-top: 25px;
            margin-bottom: 10px;
            border: 0px;
            border-radius: 0px;
        }

        .container-fluid{
            max-width: 1140px;
            margin: 0 auto;
        }

        .view-wrapper {
            float: right;
            max-width: 70%;
            margin-top: 25px;
        }

        .container {
            padding-left: 0px;
            padding-right: 0px;
            max-width: 100%;
        }

        /*********************************************
                                        ITEM 
        *********************************************/

        .service1-items {
            padding: 0px 0 0px 0;
            float: left;
            position: relative;
            overflow: hidden;
            max-width: 100%;
            height: 321px;
            width: 130px;
        }

        .service1-item {
            height: 107px;
            width: 120px;
            display: block;
            float: left;
            position: relative;
            padding-right: 20px;
            border-right: 1px solid #DDD;
            border-top: 1px solid #DDD;
            border-bottom: 1px solid #DDD;
        }

        .service1-item > img {
            max-height: 110px;
            max-width: 110px;
            opacity: 0.6;
            transition: all .2s ease-in;
            -o-transition: all .2s ease-in;
            -moz-transition: all .2s ease-in;
            -webkit-transition: all .2s ease-in;
        }

        .service1-item > img:hover {
            cursor: pointer;
            opacity: 1;
        }

        .service-image-left {
            padding-right: 50px;
            width: 60%;
        }

        .service-image-right {
            padding-left: 50px;
        }

        .service-image-left > center > img,.service-image-right > center > img{
            max-height: 155px;


        }

    </style>
</head>