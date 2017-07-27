package routes.circe

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import de.heikoseeberger.akkahttpcirce.FailFastCirceSupport
import models.BaseRequest

import scala.util.Random

/**
  * Created by Alexander on 27.07.2017.
  */
object CirceRoute {

  import io.circe.generic.auto._
  import FailFastCirceSupport._

  val route =
    path("circe") {
      post {
        entity(as[BaseRequest]) { request =>
          complete(HttpEntity(ContentTypes.`application/json`, Random.nextLong().toString))
        }

      }
    }
}
