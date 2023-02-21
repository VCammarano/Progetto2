package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class PersonListAdapter(private val context: Context, private val personList: LiveData<List<Person>>) :
    RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tvName)
        val surnameTextView: TextView = itemView.findViewById(R.id.tvSurname)
        val cityTextView: TextView = itemView.findViewById(R.id.tvBirthplace)
        val genderTextView: TextView = itemView.findViewById(R.id.tvGender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_person_activity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val person = personList[Position]
        holder.nameTextView.text = person.name
        holder.surnameTextView.text = person.surname
        holder.itemView.setOnClickListener {
            val intent = Intent(context, PersonDetailActivity::class.java)
            intent.putExtra("personId", person.id)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}