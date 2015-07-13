<!--
  ~ Copyright (c) 2011 Haulmont Technology Ltd. All Rights Reserved.
  ~ Haulmont Technology proprietary and confidential.
  ~ Use is subject to license terms.
  -->
<xsl:stylesheet
        xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:import href="webhelp/xsl/webhelp.xsl"/>
    <xsl:import href="highlight.xsl"/>
    <xsl:param name="webhelp.autolabel">0</xsl:param>

    <xsl:template name="user.header.content">
      <xsl:variable name="codefile">
        <!-- Yandex.Metrika counter -->
        <script type="text/javascript">
          (function (d, w, c) {
          (w[c] = w[c] || []).push(function() {
          try {
          w.yaCounter31327533 = new Ya.Metrika({
          id:31327533,
          clickmap:true,
          trackLinks:true,
          accurateTrackBounce:true,
          webvisor:true,
          trackHash:true
          });
          } catch(e) { }
          });

          var n = d.getElementsByTagName("script")[0],
          s = d.createElement("script"),
          f = function () { n.parentNode.insertBefore(s, n); };
          s.type = "text/javascript";
          s.async = true;
          s.src = "https://mc.yandex.ru/metrika/watch.js";

          if (w.opera == "[object Opera]") {
          d.addEventListener("DOMContentLoaded", f, false);
          } else { f(); }
          })(document, window, "yandex_metrika_callbacks");
        </script>
        <!-- /Yandex.Metrika counter -->
      </xsl:variable>
      <xsl:copy-of select="$codefile"/>
    </xsl:template>
</xsl:stylesheet>