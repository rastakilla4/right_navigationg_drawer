package com.periferia.metas_amway.LogIn.interfaces

interface Password {

    interface View{
        fun confirmPasswordChange()
    }

    interface Presenter{
        fun createPassword(pass1:String, pass2:String)
        fun confirmStorage()
    }

    interface Model{
        fun createPassword(pass1: String, pass2: String)
    }


}