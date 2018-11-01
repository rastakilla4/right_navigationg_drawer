package com.periferia.metas_amway.LogIn.views

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.periferia.metas_amway.MenuPrincipal

import com.periferia.metas_amway.R



class LogIn : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var btn_ingresar:Button
    private lateinit var txv_register:TextView
    private lateinit var txv_forgotpwd:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view:View = inflater.inflate(R.layout.fragment_log_in, container, false)

        btn_ingresar = view.findViewById(R.id.btn_login)
        txv_register = view.findViewById(R.id.txv_register)
        txv_forgotpwd = view.findViewById(R.id.txv_forgot_pwd)

        btn_ingresar.setOnClickListener() {menu()}
        txv_register.setOnClickListener() {register()}
        txv_forgotpwd.setOnClickListener() {sendMail()}

        return view
    }

    private fun sendMail() {
        val send = ForgotPassword()
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.contenedor_registro, send)
                .addToBackStack("aa").commit()
    }

    private fun register() {
        val bundle = Bundle()
        // TODO: crear el mvp para devolver la ciudad
        bundle.putString("country", "colombia")
        val register = RegisterInfo()
        register.setArguments(bundle)
        val transaction = fragmentManager!!
                .beginTransaction()
        transaction.replace(R.id.contenedor_registro, register)
                .addToBackStack("aa").commit()
    }

    private fun menu() {
        val intent = Intent(activity, MenuPrincipal::class.java)
        startActivity(intent)
        activity?.finish()
    }

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LogIn.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LogIn().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
