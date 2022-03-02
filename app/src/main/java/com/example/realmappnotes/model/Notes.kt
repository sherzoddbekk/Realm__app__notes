package com.example.realmappnotes.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Notes: RealmObject {
    @PrimaryKey
    var id:Int? = null
    var time: String? = null
    var text: String? = null
    constructor(){}
    constructor(id: Int, time: String?, text: String?) : super() {
        this.id = id
        this.time = time
        this.text = text
    }

}