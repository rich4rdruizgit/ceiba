package com.ceiba.core.database.domain.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddressEntity(
    val street: String? = "",
    val suite: String? = "",
    val city: String? = "",
    val zipcode: String? = "",
    @PrimaryKey val idAddressEntity: Int? = null,
    // Relation with geoLocationEntity one to one
    //val addressGeoId: Int
    @Embedded
    val geoLocationObject: GeoLocationObject
)