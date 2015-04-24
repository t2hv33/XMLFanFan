<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : product.xsl
    Created on : May 4, 2015, 10:35 AM
    Author     : ThanhHV
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <!-- TODO customize transformation rules 
         syntax recommendation http://www.w3.org/TR/xslt 
    -->
    <xsl:template match="/">
        <html>
            
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>


    <xsl:template match="Allproduct">
        <xsl:for-each select="productList">
            <xsl:sort select="Name"/>
            <div class="col-sm-4 col-lg-4 col-md-4">
                <div class="thumbnail">
                    <img  alt="">
                        <xsl:attribute name="src"> 
                            <xsl:value-of select="Image"/>
                        </xsl:attribute>
                    </img> 
   
                    <div class="caption">
                        <h4 class="">
                            <a href="product-detail.jsp"> 
                                <xsl:value-of select="Name"/>
                            </a>
                        </h4>
                        <p class="price pull-right">
                            <xsl:value-of select="Price"/> VND
                        </p>
                      
                    </div>
            
                    <div class="ratings">
                        <p class="pull-right">   
                            <a href="#" class="btn btn-primary">Buy Now!</a> 
                        </p>
                        <p>
                            <span class="glyphicon glyphicon-star"></span>
                            
                        </p>
                    </div>
                </div>         
            </div>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>