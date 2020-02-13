package com.github.rafaelsilvestri

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class PersonSimulation extends Simulation {
  val users = Integer.getInteger("users", 100) toDouble
  val testTime = Integer.getInteger("duration", 30)
  val baseUrl = System.getProperty("baseurl", "http://localhost:8080/person")

  val httpProtocol = http
    .baseUrl(baseUrl)
    .contentTypeHeader( """application/json""")
    //.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Windows NT 5.1; rv:31.0) Gecko/20100101 Firefox/31.0")

  val scn = scenario("POST Person")
    .exec(http("POST Person Result")
      .post("/person")
      .body(StringBody("""{"name":"Rafael","email":"rafaelcechinel@gmail.com","address":"Boulevard Street"}"""))
    ).pause(5)

  setUp(
    scn.inject(constantUsersPerSec(users).during(testTime))
  ).protocols(httpProtocol)
}