package com.skeleton.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.skeleton.rickandmorty.data.local.dao.CharacterDao
import com.skeleton.rickandmorty.data.local.dao.RemoteKeysDao
import com.skeleton.rickandmorty.data.local.entity.CharacterEntity
import com.skeleton.rickandmorty.data.local.entity.RemoteKeys
import com.skeleton.rickandmorty.utils.ConvertersList

@Database(
    entities = [CharacterEntity::class, RemoteKeys::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ConvertersList::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun remoteKeysDao(): RemoteKeysDao
}