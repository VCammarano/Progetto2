package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.dao.PersonDao
import com.example.myapplication.dao.PersonDatabase

class PersonDetailActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var surnameTextView: TextView
    private lateinit var birthdateTextView: TextView
    private lateinit var birthplaceTextView: TextView
    private lateinit var sexTextView: TextView
    private lateinit var personDao: PersonDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_detail_activity)

        // Inizializza il database
        val db = PersonDatabase.getDatabase(this)

        // Inizializza il DAO delle persone
        personDao = db.personDao()

        // Recupera l'ID della persona dall'extra nell'Intent
        val personId = intent.getLongExtra("personId", -1)

        // Recupera la persona dal database
        val person = personDao.getPersonById(personId)

        // Inizializza i TextView
        nameTextView = findViewById(R.id.tvName)
        surnameTextView = findViewById(R.id.tvSurname)
        birthdateTextView = findViewById(R.id.tvBirthdate)
        birthplaceTextView = findViewById(R.id.tvBirthplace)
        sexTextView = findViewById(R.id.tvGender)

        // Imposta i valori dei TextView
        nameTextView.text = person.name
        surnameTextView.text = person.surname
        birthdateTextView.text = person.birthdate.toString()
        birthplaceTextView.text = person.birthplace
        sexTextView.text = person.gender
    }
}