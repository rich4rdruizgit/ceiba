package com.ceiba.core.database.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ceiba.core.database.domain.entities.AddressEntity
import com.ceiba.core.database.domain.entities.CompanyEntity
import com.ceiba.core.database.domain.entities.GeoLocationEntity
import com.ceiba.core.database.domain.entities.UserEntity
import com.ceiba.core.database.domain.entities.converter.AddressConverter
import com.ceiba.core.database.domain.entities.converter.CompanyConverter
import com.ceiba.core.database.domain.entities.converter.GeoLocationConverter

@Database(
    entities = [UserEntity::class, AddressEntity::class, GeoLocationEntity::class, CompanyEntity::class],
    version = 1
)
@TypeConverters(AddressConverter::class, GeoLocationConverter::class, CompanyConverter::class)

abstract class UserPostDatabase : RoomDatabase() {
    abstract val dao: UserPostDao
}