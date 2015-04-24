<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" indent="yes"/>
    <xsl:template match="/">
        <html>
            <body>
                <xsl:apply-templates/>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="Products">
        <table border="2" width="75%">
            <xsl:for-each select="Items">
                <tr>
                    <td>
                        <xsl:value-of select="code"/>
                    </td>
                    <td>
                        <xsl:value-of select="name"/>
                    </td>
                    <td>
                        <xsl:value-of select="price"/>
                    </td>
                    <td>
                        <xsl:value-of select="description"/>
                    </td>
                </tr>
              </xsl:for-each>
        </table>
        
    </xsl:template>
</xsl:stylesheet>

