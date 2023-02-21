package com.example.koachy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var koreanVocab = arrayOf("Word One", "Word Two", "Word Three", "Word Four", "Word Five", "Word Six", "Word Seven")
    private var englishVocab = arrayOf("Translation One", "Translation Two", "Translation Three", "Translation Four", "Translation Five", "Translation Six", "Translation Seven")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
    return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return koreanVocab.size
        return englishVocab.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
    holder.koreanVocab.text = koreanVocab[position]
    holder.englishVocab.text = englishVocab[position]
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var koreanVocab: TextView
    var englishVocab: TextView

    init {
        koreanVocab = koreanVocab.findViewById(R.id.koreanVocab)
        englishVocab = englishVocab.findViewById(R.id.englishVocab)
        }
    }
}