package models

/**
  * Created by Alexander on 27.07.2017.
  */
case class DmcHotelMapping(dmcId: Long, hotelId: Long, dmcHotelId: String, cityId: Long, dmcRoomMappings: List[DmcRoomMapping])
