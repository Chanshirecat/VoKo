package com.example.koachy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddActivity : AppCompatActivity() {
    private var myDb = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

    fun saveVocab(view: View){
        myDb.insertData(findViewById<EditText>(R.id.koreanVocab).text.toString())
        myDb.insertData((findViewById<EditText>(R.id.englishVocab).text.toString())
        startActivity(Intent(this,AddActivity::class.java))

            val addBtn = view.findViewById<Button>(R.id.addBtn)

        addBtn.setOnClickListener {
            save(id)
        }
    }
        val button: Button = findViewById(R.id.vocabBtn)
        button.setOnClickListener {
            val intent = Intent(this, VocabActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


