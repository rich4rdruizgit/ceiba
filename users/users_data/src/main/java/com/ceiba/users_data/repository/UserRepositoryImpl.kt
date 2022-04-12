package com.ceiba.users_data.repository

import com.ceiba.users_data.remote.UserApi
import com.ceiba.users_domain.models.Address
import com.ceiba.users_domain.models.Company
import com.ceiba.users_domain.models.Geo
import com.ceiba.users_domain.models.UserItem
import com.ceiba.users_domain.repository.UserRepository

class UserRepositoryImpl(private val api: UserApi) : UserRepository {
    override suspend fun getUsers(): Result<List<UserItem>> {
        return try {
            val userDto = api.getUsers()
            Result.success(
                userDto.map {
                    UserItem(
                        Address(
                            it.address.city,
                            Geo(it.address.geo.lat, it.address.geo.lng),
                            it.address.street,
                            it.address.suite,
                            it.address.zipcode
                        ),
                        Company(it.company.bs, it.company.catchPhrase, it.company.name),
                        it.email,
                        it.id,
                        it.name,
                        it.phone,
                        it.username,
                        it.website
                    )
                }
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Result.failure(e)
        }
    }

}