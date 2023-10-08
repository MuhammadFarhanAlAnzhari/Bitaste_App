package com.aplikasi.bitasteapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RoomEntity::class], version = 2)
abstract class FoodDatabase:RoomDatabase() {
    abstract fun roomDao(): RoomDAO

    companion object {
        private var INSTANCE: FoodDatabase? = null
        fun getInstance(context: Context): FoodDatabase? {
            if (INSTANCE == null) {
                synchronized(FoodDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        FoodDatabase::class.java, "AppFood.db"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }


        fun destroyInstance() {
            INSTANCE = null
        }
    }
}