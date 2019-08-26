package com.grzegorzdec.tagmango.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grzegorzdec.tagmango.model.LikedMeal

@Dao
abstract class LikedMealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun setLike(liked: LikedMeal)

    @Query("Select mealId from likedMeal where liked = 1")
    abstract fun getLikes(): LiveData<List<String>>
}