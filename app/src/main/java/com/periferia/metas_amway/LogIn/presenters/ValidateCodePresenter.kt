package com.periferia.metas_amway.LogIn.presenters

import com.periferia.metas_amway.LogIn.interfaces.Code
import com.periferia.metas_amway.LogIn.models.ValidateCodeModel

class ValidateCodePresenter(view:Code.View) : Code.Presenter {

    private val view:Code.View
    private val model:Code.Model

    init {
        this.view = view
        model = ValidateCodeModel(this)
    }


    override fun validateCode(code: String) {
        if (view != null) {
            model.validateCode(code)
        }
    }

    override fun validCode(country: String) {
        if (view != null) {
            view.successfulValidation(country)
        }
    }
}