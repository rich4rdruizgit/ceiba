package com.ceiba.users_data.mapper

import com.ceiba.users_data.remote.dto.UserItemDto
import com.ceiba.users_domain.models.Address
import com.ceiba.users_domain.models.Company
import com.ceiba.users_domain.models.Geo
import com.ceiba.users_domain.models.UserItem

fun UserItemDto.toUserModelView(): UserItem {
    val addressCity = address.city
    val addressStreet = address.street
    val addressSuite = address.suite
    val addressZipCode = address.zipcode
    val geoLat = address.geo.lat
    val geoLong = address.geo.lng

    val companyName = company.name
    val companyCatchPhrase = company.catchPhrase
    val companyBs = company.bs

    return UserItem(
        id = id,
        name = name,
        username = username,
        email = email,
        phone = phone,
        website = website,
        address =
        Address(
            street = addressStreet, suite = addressSuite, city = addressCity, zipcode = addressZipCode,
            geo = Geo(geoLat,geoLong)
        ),
        company =
        Company(
            companyName, companyCatchPhrase, companyBs
        )

    )
}
