package com.ceiba.core.database.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CompanyEntity(
    val name: String? = "",
    val catchPhrase: String? = "",
    val bs: String? = "",
    @PrimaryKey val idCompanyEntity: Int? = null
)
