package com.example.echopal.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Session::class], version = 1)
abstract class EchoPalDatabase : RoomDatabase() {
    abstract fun sessionDao(): SessionDao

    companion object {
        @Volatile
        private var INSTANCE: EchoPalDatabase? = null

        fun getDatabase(context: Context): EchoPalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EchoPalDatabase::class.java,
                    "echopal_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
