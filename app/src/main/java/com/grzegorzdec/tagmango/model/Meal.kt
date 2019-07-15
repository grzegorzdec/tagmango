package com.grzegorzdec.tagmango.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal")
data class Meal(val price: String = "",
                val name: String = "",
                val description: String = "",
                @PrimaryKey val id: String = ""
)