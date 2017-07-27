package routes.argonaut

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import models.{BaseRequest, DmcHotelMapping, DmcRoomMapping, SearchCriteria}
import argonaut._, Argonaut._
import scala.util.Random
import argonaut.Argonaut._

/**
  * Created by Alexander on 27.07.2017.
  */
object ArgonautRoute {

  import de.heikoseeberger.akkahttpargonaut.ArgonautSupport._


  implicit val SearchCriteriaCodecJson =
    casecodec4(SearchCriteria.apply, SearchCriteria.unapply)("checkIn", "checkOut", "adults", "children")

  implicit val DmcRoomMappingCodecJson =
    casecodec2(DmcRoomMapping.apply, DmcRoomMapping.unapply)("roomId", "dmcRoomId")

  implicit val DmcHotelMappingCodecJson =
    casecodec5(DmcHotelMapping.apply, DmcHotelMapping.unapply)("dmcId", "hotelId", "dmcHotelId", "cityId", "dmcRoomMappings")

  implicit val BaseRequestCodecJson =
    casecodec2(BaseRequest.apply, BaseRequest.unapply)("searchCriteria", "dmcHotelMappings")

  val route =
    path("argonaut") {
      post {
        entity(as[BaseRequest]) { request =>
          complete(HttpEntity(ContentTypes.`application/json`, Random.nextLong().toString))
        }

      }
    }
}
