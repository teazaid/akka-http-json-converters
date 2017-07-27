import io.gatling.core.scenario.Simulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import io.circe.generic.auto._
import io.circe.syntax._


/**
  * Created by Alexander on 27.07.2017.
  */
class SimpleTest extends Simulation {
  val headers = Map("Content-Type" -> "application/json")
  val httpConf = http
    .baseURL("http://localhost:8080") // Here is the root for all relative URLs
    .acceptHeader("application/json") // Here are the common headers
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(http("request_10") // Here's an example of a POST request
//    .post("/circe")
    .post("/argonaut")
    .headers(headers)
    .body(StringBody(RequestGenerator.generateRequest().asJson.toString()))
  )

  setUp(scn.inject(atOnceUsers(1000)).protocols(httpConf)).maxDuration(1.minute)
}
