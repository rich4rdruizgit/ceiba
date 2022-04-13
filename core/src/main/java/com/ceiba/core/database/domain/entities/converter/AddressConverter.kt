package com.ceiba.core.database.domain.entities.converter

import androidx.room.TypeConverter
import com.ceiba.core.database.domain.entities.AddresObject
import com.google.gson.Gson

class AddressConverter {

    @TypeConverter
    fun fromAddressToGson(add: AddresObject): String? {
        return Gson().toJson(add)
    }

    @TypeConverter
    fun fromJsonToAddress(add: String): AddresObject {
        return Gson().fromJson(add, AddresObject::class.java)
    }


}