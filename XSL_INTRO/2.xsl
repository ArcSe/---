<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
<html><head><title></title></head>
<body>
  <xsl:apply-templates/>
  </body ></html>
  </xsl:template>
  <xsl:template match="графика">
    <svg>
    <xsl:attribute name="height"><xsl:value-of select="@ширина"/> </xsl:attribute>
    <xsl:attribute name="width"><xsl:value-of select="@высота"/> </xsl:attribute>
      <xsl:for-each select="эллипс">
        <ellipse> 
          <xsl:attribute name="cx"><xsl:value-of select="@cx"/> </xsl:attribute>
          <xsl:attribute name="cy"><xsl:value-of select="@cy"/> </xsl:attribute>
          <xsl:attribute name="rx"><xsl:value-of select="@rx"/> </xsl:attribute>
          <xsl:attribute name="ry"><xsl:value-of select="@ry"/> </xsl:attribute>
          <xsl:attribute name="fill"><xsl:value-of select="@заливка"/> </xsl:attribute>
          <xsl:attribute name="stroke"><xsl:value-of select="@ободок"/> </xsl:attribute>
          <xsl:attribute name="stroke-width"><xsl:value-of select="@ширина-ободка"/> </xsl:attribute>
      </ellipse>
        </xsl:for-each>
    </svg> 
  </xsl:template>
 
</xsl:stylesheet>