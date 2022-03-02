package com.example.realmappnotes.RealmManager

import com.example.realmappnotes.model.Notes
import io.realm.Realm
import io.realm.RealmResults

class RealmManager {
    var TAG = RealmManager :: class.java.simpleName

    companion object{
        private var realmManager :RealmManager? = null
        private lateinit var realm: Realm
        val instance: RealmManager?
        get() {
            if (realmManager == null){
                realmManager = RealmManager()
            }
            return realmManager
        }
    }
    init {
        realm = Realm.getDefaultInstance()
    }
    fun saveNoteListdata(notes: Notes?){
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(notes)
        realm.commitTransaction()
    }
    fun loadPosts():ArrayList<Notes>{
        val notes: ArrayList<Notes> =  ArrayList()
        val results: RealmResults<Notes> = realm.where(Notes::class.java).findAll()

        for (post in results){
            notes.add(post)
        }
        return notes
    }
}