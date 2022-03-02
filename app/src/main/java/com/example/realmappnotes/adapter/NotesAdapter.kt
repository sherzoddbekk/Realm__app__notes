package com.example.realmappnotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.realmappnotes.R
import com.example.realmappnotes.model.Notes

class NotesAdapter(var context: Context,var items:ArrayList<Notes>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is NotesViewHolder){
            var time = holder.time
            var text = holder.text

            time.text = item.time
            text.text = item.text
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class NotesViewHolder(view: View):RecyclerView.ViewHolder(view){
        var time:TextView = view.findViewById(R.id.tv_time)
        var text:TextView = view.findViewById(R.id.tv_text)
    }
}