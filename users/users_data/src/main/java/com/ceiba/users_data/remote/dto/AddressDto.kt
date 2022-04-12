package com.ceiba.users_data.remote.dto

data class AddressDto(
    val city: String,
    val geo: GeoDto,
    val street: String,
    val suite: String,
    val zipcode: String
)