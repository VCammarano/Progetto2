package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dao.PersonDao
import com.example.myapplication.dao.PersonDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AddPersonActivity : AppCompatActivity() {

    private lateinit var binding: AddPersonActivityBinding
    private lateinit var personDao: PersonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AddPersonActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personDao = PersonDatabase.getDatabase(this).personDao()

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val surname = binding.etSurname.text.toString()
            val birthdate = binding.etBirthdate.text.toString()
            val birthplace = binding.etBirthplace.text.toString()
            val gender = if (binding.radioMale.isChecked) "M" else "F"

            val person = Person(name = name, surname = surname, birthdate = birthdate, birthplace = birthplace, gender = gender)
            GlobalScope.launch {
                personDao.insert(person)
                finish()
            }
        }
    }
}