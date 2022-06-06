package com.nike.wordstest

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RVAdapter (val context: Context, val word: ArrayList<String>, val wordLast: ArrayList<String>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder (itemView){

        var oneLetter: TextView = itemView.findViewById(R.id.recText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_raw_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.oneLetter.text = word[position]

        holder.oneLetter.setOnClickListener {
            word.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, word.size)

            wordLast.add(word[position])

            val bundle = Bundle()
            bundle.putStringArray("arrayOfLetters", arrayOf(word[position]))
            Intent(context, MainActivity::class.java).putExtras(bundle)

            Log.d("devx",bundle.toString())

        }

//        val removeIndex = 2
//        data.remove(removeIndex)
//        adapter.notifyItemRemoved(removeIndex)




    }

    override fun getItemCount(): Int {
        return word.size
    }
}