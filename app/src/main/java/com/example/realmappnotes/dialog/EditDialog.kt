package com.example.realmappnotes.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.realmappnotes.R

class EditDialog:DialogFragment() {
    var saveClick:((String)->Unit)? = null
    var cancelClick:(()->Unit)? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.CustomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notes,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var cancel = view.findViewById<TextView>(R.id.cancel_tv)
        var save = view.findViewById<TextView>(R.id.save_tv)
        var edit_note = view.findViewById<EditText>(R.id.edt_notes)

        save.setOnClickListener {
            saveClick?.invoke(edit_note.text.toString())
            edit_note.setText("")
            dismiss()
        }
        cancel.setOnClickListener {
            cancelClick?.invoke()
            edit_note.setText("")
            dismiss()
        }
    }
}