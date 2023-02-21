package com.example.myapplication.dao

import androidx.lifecycle.LiveData
import com.example.myapplication.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonRepository(private val personDao: PersonDao) {

    val allPersons: LiveData<List<Person>> = personDao.getAllPersons()

    suspend fun insert(person: Person) {
        withContext(Dispatchers.IO) {
            personDao.insert(person)
        }
    }

    suspend fun delete(person: Person) {
        withContext(Dispatchers.IO) {
            personDao.delete(person)
        }
    }

    suspend fun update(person: Person) {
        withContext(Dispatchers.IO) {
            personDao.update(person)
        }
    }

}