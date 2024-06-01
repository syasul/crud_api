package com.example.api_pbb.presenter

import com.example.api_pbb.model.DataItem

interface CrudView {
    fun successAdd (msg: String)
    fun onErrorAdd (msg: String)

    fun onSuccessGet (data: List<DataItem>?)
    fun onFailedGet (msg: String)

    fun onSuccessUpdate (msg: String)
    fun onErrorUpdate (msg: String)

    fun onSuccessDelete (msg: String)
    fun onErrorDelete (msg: String)

}