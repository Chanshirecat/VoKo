package com.example.koachy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VocabActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vocab)

        layoutManager = LinearLayoutManager(this)

        val recyclerView: RecyclerView = findViewById(R.id.vocabRecycler)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter

        val button: Button = findViewById(R.id.addBtn)
        button.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }
}