package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.dao.PersonDao
import com.example.myapplication.dao.PersonDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var personDao: PersonDao

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inizializza il database
        val db = PersonDatabase.getDatabase(this)

        // Inizializza il DAO delle persone
        personDao = db.personDao()

        // Inizializza la RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = PersonListAdapter(this, personList)
        recyclerView.adapter = adapter


        // Aggiorna la lista delle persone
        updatePersonList()

        // Imposta il listener sul pulsante di aggiunta persona
        val addButton: Button = findViewById(R.id.addPersonButton)
        addButton.setOnClickListener {
            val intent = Intent(this, AddPersonActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updatePersonList() {
        val personList = personDao.getAllPersons()
        recyclerView.adapter = PersonListAdapter(this, personList)
    }
}