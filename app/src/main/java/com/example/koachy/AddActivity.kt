package com.example.koachy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddActivity : AppCompatActivity() {
    private var myDb = DatabaseHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

    fun saveVocab(view: View){
        myDb.insertData(findViewById<EditText>(R.id.koreanVocab).text.toString())
        myDb.insertData((findViewById<EditText>(R.id.englishVocab).text.toString())
        startActivity(Intent(this,AddActivity::class.java))
        }
    }
}