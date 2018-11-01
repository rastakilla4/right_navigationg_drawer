package com.periferia.metas_amway.LogIn

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.periferia.metas_amway.R
import com.periferia.metas_amway.LogIn.views.*

class BaseRegistroActivity : AppCompatActivity(),
        ValidationCode.OnFragmentInteractionListener,
        RegisterInfo.OnFragmentInteractionListener,
        CreatePassword.OnFragmentInteractionListener,
        LogIn.OnFragmentInteractionListener,
        ForgotPassword.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_registro)

        val validation: androidx.fragment.app.Fragment = ValidationCode()

        supportFragmentManager.beginTransaction().add(R.id.contenedor_registro, validation).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}