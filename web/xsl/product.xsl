<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : product.xsl
    Created on : May 4, 2015 10:35 AM
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
        
            <li class="ProductLi">
                <div class="thumbnails" align="center">
                    <a href="#">
                        <img draggable ="true" ondragstart="drag(event)"
                            id="news-image">
                            <xsl:attribute name="onclick">
                                <xsl:value-of select="'ViewDetail('"/>
                                <xsl:value-of select="PID"/>
                                <xsl:value-of select="')'"/>
                            </xsl:attribute>
                            <xsl:attribute name="src">
                                <xsl:value-of select="Image"/>
                            </xsl:attribute>
                            <xsl:attribute name="alt">
                                <xsl:value-of select="Name"/>
                            </xsl:attribute>
                            <xsl:attribute name="onmouseover">
                                <xsl:value-of select="'productonmouseover('"/>
                                <xsl:value-of select="PID"/>
                                <xsl:value-of select="')'"/>
                            </xsl:attribute>
                            <xsl:attribute name="onmouseout">
                                <xsl:value-of select="'productmouseout()'"/>
                            </xsl:attribute>
                        </img>
                    </a>
                </div>

              <!--  <div class="rating"></div>  -->
                <div class="description" align="center">
                    <p class="product-title">
                        <a id="details" href="#">
                            <xsl:attribute name="onclick">
                                <xsl:value-of select="'ViewDetail('"/>
                                <xsl:value-of select="PID"/>
                                <xsl:value-of select="')'"/>
                            </xsl:attribute>
                            <xsl:value-of select="Name"/>
                        </a>
                    </p>
                    <div class="sales-info"></div>
                    <div class="lower-section">
                        <p>
                            <span class="p-price">
                                <xsl:value-of select="Price"/> (<xsl:value-of select="Promotion"/>)
                            </span>
                            <span class="p-unit"> VND</span>
                        </p>
                    </div>
                    <a>
                        <xsl:attribute name="href">
                        <xsl:value-of select="'Cart?action=addcart'"/><![CDATA[&]]><xsl:value-of select="'pid='"/>
                        <xsl:value-of select="PID"/><![CDATA[&]]><xsl:value-of select="'name='"/>
                        <xsl:value-of select="Name"/><![CDATA[&]]><xsl:value-of select="'price='"/>
                        <xsl:value-of select="Price"/><![CDATA[&]]><xsl:value-of select="'instock='"/>
                        <xsl:value-of select="Instock"/><![CDATA[&]]><xsl:value-of select="'image='"/>
                        <xsl:value-of select="Image"/>
                    </xsl:attribute>
                        <div class="p-order"></div>
                    </a>
                </div>
            </li>
        
        </xsl:for-each>
    </xsl:template>



</xsl:stylesheet>
