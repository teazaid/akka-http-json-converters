import models.{BaseRequest, DmcHotelMapping, DmcRoomMapping, SearchCriteria}

import scala.util.Random

/**
  * Created by Alexander on 27.07.2017.
  */
object RequestGenerator {
  def main(args: Array[String]) {

  }

  def generateRequest(): BaseRequest = {
    new BaseRequest(generateSearchCriteria(), generateHotelMappings(1000) );
//    new BaseRequest(generateSearchCriteria(), generateHotelMappings(Random.nextInt(1) + 1) );
  }

  private def generateSearchCriteria(): SearchCriteria = {
    SearchCriteria(Random.nextString(10),
      Random.nextString(10),
      Random.nextInt(10) + 1,
      Random.nextInt(8))
  }

  private def generateHotelMappings(size: Int): List[DmcHotelMapping] = {
    (1 to size).map { _ =>
      val roomMappings = generateRoomMappings(10)
//      val roomMappings = generateRoomMappings(Random.nextInt(1))
      val uuid = Random.nextLong()
      DmcHotelMapping(uuid, uuid, uuid.toString, uuid, roomMappings)
    }.toList
  }

  private def generateRoomMappings(size: Int): List[DmcRoomMapping] = {
    (1 to size).map { i =>
      DmcRoomMapping(i, i.toString)
    }.toList
  }
}
