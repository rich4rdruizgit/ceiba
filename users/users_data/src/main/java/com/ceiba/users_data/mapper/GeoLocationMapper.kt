package com.ceiba.users_data.mapper

import com.ceiba.core.database.domain.entities.GeoLocationEntity
import com.ceiba.users_domain.models.Geo

fun GeoLocationEntity.toGeoLocationModel(): Geo {
    return Geo(
        lat = latitud,
        lng = longitud,
        id = idGeoLocationEntity
    )
    fun Geo.toGeoLocationEntity(): GeoLocationEntity {
        return GeoLocationEntity(
            latitud = latitud,
            longitud = longitud,
            idGeoLocationEntity = id
        )
    }
}