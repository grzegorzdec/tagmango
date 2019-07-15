package com.grzegorzdec.tagmango.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "likedMeal")
data class LikedMeal(@PrimaryKey val mealId: String, val liked: Boolean)