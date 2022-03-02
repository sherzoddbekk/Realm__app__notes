package com.example.realmappnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.realmappnotes.RealmManager.RealmManager
import com.example.realmappnotes.adapter.NotesAdapter
import com.example.realmappnotes.dialog.EditDialog
import com.example.realmappnotes.model.Notes
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.security.Key
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var fab_notes:FloatingActionButton
    lateinit var recyclerView_notes: RecyclerView
    lateinit var dialog: EditDialog
     var realmManager: RealmManager = RealmManager.instance!!
    lateinit var notesAdapter: NotesAdapter
    private val  KEY ="Notes"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }
    fun initView(){
        dialog = EditDialog()
        recyclerView_notes = findViewById(R.id.recycler_view_note)
        recyclerView_notes.layoutManager = GridLayoutManager(this,1)
        refreshAdapter(RealmManager.instance!!.loadPosts())
        fab_notes = findViewById(R.id.float_note)
        fab_notes.setOnClickListener {
            realmNotes()
        }
    }
    fun refreshAdapter(items:ArrayList<Notes>){
        notesAdapter = NotesAdapter(this,items)
        recyclerView_notes.adapter = notesAdapter
    }



    fun realmNotes(){
        dialog.show(supportFragmentManager,"")
        dialog.saveClick = {
            if (it.isNotEmpty()){
                val  data: String = Calendar.getInstance().time.toString()
                val note = Notes(notesAdapter.itemCount+1,data,it)
                realmManager.saveNoteListdata(note)
                notesAdapter.items.add(note)
                notesAdapter.notifyDataSetChanged()
            }
        }
    }

}