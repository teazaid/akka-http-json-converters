logLevel := Level.Warn

resolvers ++= Seq(Resolver.url(
  "gatling-sbt-plugins",
  url("http://dl.bintray.com/content/gatling/sbt-plugins/"))(Resolver.ivyStylePatterns))

addSbtPlugin("io.gatling" % "gatling-sbt" % "2.2.1")

