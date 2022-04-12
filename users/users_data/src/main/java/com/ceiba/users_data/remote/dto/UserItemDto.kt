package com.ceiba.users_data.remote.dto

data class UserItemDto(
    val address: AddressDto,
    val company: CompanyDto,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)