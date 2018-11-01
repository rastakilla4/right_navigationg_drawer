package com.periferia.metas_amway.LogIn.models

import com.periferia.metas_amway.LogIn.interfaces.Password

class CreatePasswordModel(presenter:Password.Presenter) : Password.Model{

    private val presenter: Password.Presenter = presenter

    override fun createPassword(pass1: String, pass2: String) {
        presenter.confirmStorage()
    }


}