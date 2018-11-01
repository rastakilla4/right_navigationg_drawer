package com.periferia.metas_amway.LogIn.presenters

import com.periferia.metas_amway.LogIn.interfaces.Password
import com.periferia.metas_amway.LogIn.models.CreatePasswordModel

class CreatePasswordPresenter(view:Password.View): Password.Presenter {

    private val view: Password.View = view
    private var model: Password.Model

    init {
        model = CreatePasswordModel(this)
    }


    override fun createPassword(pass1: String, pass2: String) {
        model.createPassword(pass1, pass2)
    }

    override fun confirmStorage() {
        view.confirmPasswordChange()
    }


}