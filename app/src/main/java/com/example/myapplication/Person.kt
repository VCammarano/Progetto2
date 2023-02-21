package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Gender {
    MALE, FEMALE
}

@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var surname: String,
    var birthdate: String,
    var birthplace: String,
    var gender: String
)