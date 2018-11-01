package com.periferia.metas_amway.LogIn.interfaces

interface Info {

    interface View{
        fun saveDataConfirmation()
    }

    interface Presenter {
        fun saveData(id:String, name:String,
                     birthday:String, country:String,
                     city:String, email:String)

        fun confirmStorage()
    }

    interface Model {
        fun storageData(id:String, name:String,
                        birthday:String, country:String,
                        city:String, email:String)
    }
}