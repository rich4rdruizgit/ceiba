package com.ceiba.core.database.domain.entities.converter

import androidx.room.TypeConverter
import com.ceiba.core.database.domain.entities.CompanyObject
import com.google.gson.Gson

class CompanyConverter {

    @TypeConverter
    fun fromComapnyToGson(company: CompanyObject): String? {
        return Gson().toJson(company)
    }

    @TypeConverter
    fun fromJsonToCompany(company: String): CompanyObject {
        return Gson().fromJson(company, CompanyObject::class.java)
    }


}