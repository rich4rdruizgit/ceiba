package com.ceiba.users_data.mapper

import com.ceiba.core.database.domain.entities.AddresObject
import com.ceiba.core.database.domain.entities.CompanyObject
import com.ceiba.core.database.domain.entities.GeoLocationObject
import com.ceiba.core.database.domain.entities.UserEntity
import com.ceiba.users_domain.models.Address
import com.ceiba.users_domain.models.Company
import com.ceiba.users_domain.models.Geo
import com.ceiba.users_domain.models.UserItem


fun UserEntity.toUserModel(): UserItem {
    return UserItem(
        name = name,
        username = userName,
        email = email,
        phone = phone,
        website = website,
        //Primary Key UserEntity
        id = id,
        // Foreign Key UserEntity
        address =
        Address(
            street = addressObject.street,
            suite = addressObject.suite,
            city = addressObject.city,
            zipcode = addressObject.zipcode,
            geo = Geo(
                lat = addressObject.geoLocationObject.latitud,
                lng = addressObject.geoLocationObject.longitud
            )
        ),
        company =
        Company(
            name = companyObject.nameCompany,
            catchPhrase = companyObject.catchPhrase,
            bs = companyObject.bs
        )
    )
}

fun UserItem.toUserEntity(): UserEntity {
    return UserEntity(
        name = name,
        userName = username,
        email = email,
        phone = phone,
        website = website,
        id = id,
        addressObject =
        AddresObject(
            address.street, address.suite, address.city, address.zipcode,
            GeoLocationObject(
                address.geo.lat, address.geo.lng
            )
        ),
        companyObject = CompanyObject(company.name, company.catchPhrase, company.bs)
    )
}