package com.ceiba.core.database.domain.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ceiba.core.utils.Constants

@Entity(tableName = Constants.USERS_ROOM_DATABASE_TABLE)
data class UserEntity(
    val name: String,
    val userName: String,
    val email: String,
    val phone: String? = "",
    val website: String? = "",
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    // Relation with addressEntity one to one
   // val userAddressId: Int,
    // Relation with companyEntity one to one
   // val userCompanyId: Int,
    @Embedded
    val addressObject: AddresObject,
    @Embedded
    val companyObject: CompanyObject

)

data class AddresObject(
    val street: String? = "",
    val suite: String? = "",
    val city: String? = "",
    val zipcode: String? = "",
    val geoLocationObject: GeoLocationObject
)

data class CompanyObject(
    val nameCompany: String? = "",
    val catchPhrase: String? = "",
    val bs: String? = ""
)

data class GeoLocationObject(
    val latitud: String? = "" ,
    val longitud: String? = ""
)