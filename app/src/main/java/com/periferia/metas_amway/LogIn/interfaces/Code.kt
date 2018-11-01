package com.periferia.metas_amway.LogIn.interfaces

interface Code {

    interface View {
        fun successfulValidation(country: String)
    }

    interface Presenter {
        fun validateCode(code: String)
        fun validCode(country: String)
    }

    interface Model {
        fun validateCode(code: String)
    }

}