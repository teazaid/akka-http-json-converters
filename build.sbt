name := "akka-http-json-parser"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("snapshots")

resolvers ++= Seq(Resolver.url(
  "gatling-sbt-plugins",
  url("http://dl.bintray.com/content/gatling/sbt-plugins/"))(Resolver.ivyStylePatterns))

//resolvers += Resolver.bintrayRepo("hseeberger", "maven")
enablePlugins(GatlingPlugin)

libraryDependencies ++= List(
  "de.heikoseeberger" %% "akka-http-circe" % "1.17.0",
  "de.heikoseeberger" %% "akka-http-argonaut" % "1.17.0",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % "2.2.5" % "test,it",
  "io.gatling" % "gatling-test-framework" % "2.2.5" % "test,it",
  "io.argonaut" %% "argonaut" % "6.2"
)

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor_2.11
//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.5.3"

// https://mvnrepository.com/artifact/io.circe/circe-core_2.11
libraryDependencies += "io.circe" % "circe-core_2.11" % "0.8.0"

// https://mvnrepository.com/artifact/io.circe/circe-generic_2.11
libraryDependencies += "io.circe" % "circe-generic_2.11" % "0.8.0"

// https://mvnrepository.com/artifact/io.circe/circe-parser_2.11
libraryDependencies += "io.circe" % "circe-parser_2.11" % "0.8.0"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-http_2.11
libraryDependencies += "com.typesafe.akka" % "akka-http_2.11" % "10.0.9"

// https://mvnrepository.com/artifact/de.heikoseeberger/akka-http-circe_2.11
libraryDependencies += "de.heikoseeberger" % "akka-http-circe_2.11" % "1.17.0"

