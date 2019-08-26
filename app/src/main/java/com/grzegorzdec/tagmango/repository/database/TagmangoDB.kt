package com.grzegorzdec.tagmango.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grzegorzdec.tagmango.model.LikedMeal
import com.grzegorzdec.tagmango.model.Meal
import com.grzegorzdec.tagmango.repository.database.dao.LikedMealDao
import com.grzegorzdec.tagmango.repository.database.dao.MealDao

@Database(entities = [Meal::class, LikedMeal::class], version = 1)
abstract class TagmangoDB : RoomDatabase() {

    abstract fun mealDao(): MealDao
    abstract fun likedMealDao(): LikedMealDao

    companion object {
        @Volatile
        private var INSTANCE: TagmangoDB? = null

        fun getInstance(context: Context): TagmangoDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TagmangoDB::class.java,
                "TagmangoDB.db"
            ).build()
    }
}