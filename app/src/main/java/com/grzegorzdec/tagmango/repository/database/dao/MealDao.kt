package com.grzegorzdec.tagmango.repository.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grzegorzdec.tagmango.model.Meal

@Dao
abstract class MealDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(meals: List<Meal>)

    @Query("Select * from meal")
    abstract fun getAllMeals(): LiveData<List<Meal>>
}