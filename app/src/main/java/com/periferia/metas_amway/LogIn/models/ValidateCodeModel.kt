package com.periferia.metas_amway.LogIn.models

import com.periferia.metas_amway.LogIn.interfaces.Code

class ValidateCodeModel(presenter:Code.Presenter) : Code.Model{

    private val presenter : Code.Presenter

    init {
        this.presenter = presenter
    }


    override fun validateCode(code: String) {
        if (code.substring(0,3).equals("123")) {
            presenter.validCode("Colombia")
        } else if (code.substring(0,3).equals("345")){
            presenter.validCode("Brasil")
        } else {
            presenter.validCode("las demas")
        }
    }
}