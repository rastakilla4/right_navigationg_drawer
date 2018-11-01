package com.periferia.metas_amway.LogIn.views

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView

import com.periferia.metas_amway.R
import com.periferia.metas_amway.LogIn.interfaces.Info
import com.periferia.metas_amway.LogIn.presenters.RegisterInfoPresenter

import java.text.SimpleDateFormat
import java.util.*


class RegisterInfo : androidx.fragment.app.Fragment(), Info.View, DatePickerDialog.OnDateSetListener {

    private var country: String? = null
    private lateinit var presenter: Info.Presenter

    private lateinit var edtx_country:EditText
    private lateinit var txv_fecha:TextView
    private lateinit var btn_registro:Button

    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            country = it.getString("country")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_register_info, container, false)

        presenter = RegisterInfoPresenter(this)

        edtx_country = view.findViewById(R.id.edtx_pais)
        txv_fecha = view.findViewById(R.id.txv_fecha_nacimiento)
        btn_registro = view.findViewById(R.id.btn_registro)


        edtx_country.setText(country)

        txv_fecha.setOnClickListener() {
            selectDate()
        }

        btn_registro.setOnClickListener(){
            val crearClave = CreatePassword()
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.contenedor_registro, crearClave)
                    .addToBackStack("aa").commit()
        }

        return view
    }

    private fun selectDate() {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy/MM/dd ")
        val date = format.format(calendar.time)
        val parts = date.trim { it <= ' ' }.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val dialog = DatePickerDialog(context!!, this,
                Integer.valueOf(parts[0]),
                Integer.valueOf(parts[1]),
                Integer.valueOf(parts[2]))
        dialog.show()
    }


    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun saveDataConfirmation() {
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        txv_fecha.setText("$dayOfMonth / ${month+1} / $year")
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                RegisterInfo().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
