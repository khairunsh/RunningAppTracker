package com.androiddevs.runningappyt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Run::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class RunningDatabase: RoomDatabase() {

    abstract fun getRunDAO(): RunDAO

    // We'll use Dagger so don't worry about singleton for creating database like NewsApp
}