package com.ceiba.core.database.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GeoLocationEntity(
    val latitud: String? = "" ,
    val longitud: String? = "",
    @PrimaryKey val idGeoLocationEntity: Int? = null
)
