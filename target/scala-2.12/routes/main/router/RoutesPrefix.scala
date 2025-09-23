
// @GENERATOR:play-routes-compiler
// @SOURCE:D:/VHT_Projects/cmp-fe-dev-dev_multiLang/conf/routes
// @DATE:Mon Sep 22 16:32:39 ICT 2025


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
