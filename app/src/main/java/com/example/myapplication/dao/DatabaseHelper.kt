package com.example.myapplication.dao

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.myapplication.Person

class DatabaseHelper(context: Context) {

    private val personDao: PersonDao

    private val database = Room.databaseBuilder(
        context.applicationContext,
        PersonDatabase::class.java, "person-database"
    ).build()

    init {
        personDao = database.personDao()
    }

    fun addPerson(person: Person) {
        personDao.insert(person)
    }

    fun getAllPersons(): LiveData<List<Person>> {
        return personDao.getAllPersons()
    }

    fun getPersonById(id: Long): Person? {
        return personDao.getPersonById(id)
    }

    fun updatePerson(person: Person) {
        personDao.update(person)
    }

    fun deletePerson(person: Person) {
        personDao.delete(person)
    }
}