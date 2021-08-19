package com.androiddevs.runningappyt.dagger

import android.content.Context
import androidx.room.Room
import com.androiddevs.runningappyt.database.RunningDatabase
import com.androiddevs.runningappyt.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRunningDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Provides
    fun provideRunDao(database: RunningDatabase) = database.getRunDAO()
}