package com.androiddevs.runningappyt.dagger

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.room.Room
import com.androiddevs.runningappyt.database.RunningDatabase
import com.androiddevs.runningappyt.other.Constants
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

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context) =
        context.getSharedPreferences(Constants.SHARED_PREFERENCES_NAME, MODE_PRIVATE)

    @Provides
    fun provideName(sharedPref: SharedPreferences) = sharedPref.getString(Constants.KEY_NAME, "")

    @Provides
    fun provideWeight(sharedPref: SharedPreferences) = sharedPref.getFloat(Constants.KEY_WEIGHT, 0f)

    @Provides
    fun provideFirstTimeToggle(sharedPref: SharedPreferences) = sharedPref.getBoolean(Constants.KEY_FIRST_TIME_TOGGLE, true)
}