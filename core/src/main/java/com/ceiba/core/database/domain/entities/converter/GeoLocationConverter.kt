package com.ceiba.core.database.domain.entities.converter

import androidx.room.TypeConverter
import com.ceiba.core.database.domain.entities.GeoLocationObject
import com.google.gson.Gson

class GeoLocationConverter {

    @TypeConverter
    fun fromGeoLocationToGson(geo: GeoLocationObject): String? {
        return Gson().toJson(geo)
    }

    @TypeConverter
    fun fromJsonToGeoLocation(geo: String): GeoLocationObject {
        return Gson().fromJson(geo, GeoLocationObject::class.java)
    }


}