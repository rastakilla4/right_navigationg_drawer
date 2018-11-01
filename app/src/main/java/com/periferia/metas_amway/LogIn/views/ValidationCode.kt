package com.periferia.metas_amway.LogIn.views

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText


import com.periferia.metas_amway.R
import com.periferia.metas_amway.LogIn.interfaces.Code
import com.periferia.metas_amway.LogIn.presenters.ValidateCodePresenter


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ValidationCode.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ValidationCode.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ValidationCode : androidx.fragment.app.Fragment(), Code.View, View.OnClickListener {




    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_guardar -> {
                val codigo = number1.text.toString() +
                        number2.text.toString() +
                        number3.text.toString() +
                        number4.text.toString() +
                        number5.text.toString() +
                        number6.text.toString() +
                        number7.text.toString() +
                        number8.text.toString() +
                        number9.text.toString() +
                        number10.text.toString();

                if (codigo.length == 10) {
                    presenter.validateCode(codigo)
                }else{
                    Log.wtf("ERROR", "CODIGO INCOMPLETO")
                }
            }
        }
    }


    // TODO: Rename and change types of parameters

    /*@BindView(R.id.number1)
    private  var number1: EditText? = null

    @BindView(R.id.number2)
    private var number2: EditText? = null

    @BindView(R.id.number3)
    private var number3: EditText? = null

    @BindView(R.id.number4)
    private var number4: EditText? = null

    @BindView(R.id.number5)
    private  var number5: EditText? = null

    @BindView(R.id.number6)
    private var number6: EditText? = null

    @BindView(R.id.number7)
    private var number7: EditText? = null

    @BindView(R.id.number8)
    private var number8: EditText? = null

    @BindView(R.id.number9)
    private var number9: EditText? = null

    @BindView(R.id.number10)
    private var number10: EditText? = null*/

    private var currentIndex: Int = 0
    private var touched: Boolean = false
    private lateinit var presenter:Code.Presenter

    private lateinit var number1:EditText
    private lateinit var number2:EditText
    private lateinit var number3:EditText
    private lateinit var number4:EditText
    private lateinit var number5:EditText
    private lateinit var number6:EditText
    private lateinit var number7:EditText
    private lateinit var number8:EditText
    private lateinit var number9:EditText
    private lateinit var number10:EditText

    private lateinit var btn_guardar:Button





    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_validation_code, container, false)
        presenter = ValidateCodePresenter(this)

        //ButterKnife.bind(this,view)

        number1 = view.findViewById(R.id.number1)
        number2 = view.findViewById(R.id.number2)
        number3 = view.findViewById(R.id.number3)
        number4 = view.findViewById(R.id.number4)
        number5 = view.findViewById(R.id.number5)
        number6 = view.findViewById(R.id.number6)
        number7 = view.findViewById(R.id.number7)
        number8 = view.findViewById(R.id.number8)
        number9 = view.findViewById(R.id.number9)
        number10 = view.findViewById(R.id.number10)

        btn_guardar = view.findViewById(R.id.btn_guardar)

        btn_guardar.setOnClickListener(this)



        number1.addTextChangedListener(whatcher)
        number2.addTextChangedListener(whatcher)
        number3.addTextChangedListener(whatcher)
        number4.addTextChangedListener(whatcher)
        number5.addTextChangedListener(whatcher)
        number6.addTextChangedListener(whatcher)
        number7.addTextChangedListener(whatcher)
        number8.addTextChangedListener(whatcher)
        number9.addTextChangedListener(whatcher)
        number10.addTextChangedListener(whatcher)

        number1.requestFocus()
        Log.wtf("IS FOCUSED","${number1.isFocused}")

        number1.setOnKeyListener(keyListener)
        number2.setOnKeyListener(keyListener)
        number3.setOnKeyListener(keyListener)
        number4.setOnKeyListener(keyListener)
        number5.setOnKeyListener(keyListener)
        number6.setOnKeyListener(keyListener)
        number7.setOnKeyListener(keyListener)
        number8.setOnKeyListener(keyListener)
        number9.setOnKeyListener(keyListener)
        number10.setOnKeyListener(keyListener)


        return view
    }

    private fun getCurrentCodeIndex() {
        if (number1.isFocused) {
            currentIndex = 0
        } else if (number2.isFocused) {
            currentIndex = 1
        } else if (number3.isFocused) {
            currentIndex = 2
        } else if (number4.isFocused) {
            currentIndex = 3
        } else if (number5.isFocused) {
            currentIndex = 4
        } else if (number6.isFocused) {
            currentIndex = 5
        } else if (number7.isFocused) {
            currentIndex = 6
        } else if (number8.isFocused) {
            currentIndex = 7
        } else if (number9.isFocused) {
            currentIndex = 8
        } else if (number10.isFocused) {
            currentIndex = 9
        }

    }

    private val whatcher = object:TextWatcher {

        override fun afterTextChanged(s: Editable?) {
           getCurrentCodeIndex()

            Log.wtf("INDEX","$currentIndex")

            if (!s.toString().isEmpty()){
                when (currentIndex) {
                    0 -> {
                        number2.requestFocus()
                        currentIndex = 1
                    }
                    1 -> {
                        number3.requestFocus()
                        currentIndex = 2
                    }
                    2 -> {
                        number4.requestFocus()
                        currentIndex = 3
                    }
                    3 -> {
                        number5.requestFocus()
                        currentIndex = 4
                    }
                    4 -> {
                        number6.requestFocus()
                        currentIndex = 5
                    }
                    5 -> {
                        number7.requestFocus()
                        currentIndex = 6
                    }
                    6 -> {
                        number8.requestFocus()
                        currentIndex = 7
                    }
                    7 -> {
                        number9.requestFocus()
                        currentIndex = 8
                    }
                    8 -> {
                        number10.requestFocus()
                        currentIndex = 9
                    }
                    else -> {Log.wtf("No INDEX","no hay index")}
                }
            }
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }

    private val keyListener = View.OnKeyListener {v, keyCode, event ->

        if (touched) {
            return@OnKeyListener true;
        }else{
            touched = true
        }
        if (keyCode == KeyEvent.KEYCODE_DEL){
            when (currentIndex) {
                9  -> if (number10.text.toString().isEmpty()) {
                    number9.requestFocus()
                    number9.setText("")
                    currentIndex = 8
                }
                8 -> if (number9.text.toString().isEmpty()) {
                    number8.requestFocus()
                    number8.setText("")
                    currentIndex = 7
                }
                7 -> if (number8.text.toString().isEmpty()) {
                    number7.requestFocus()
                    number7.setText("")
                    currentIndex = 6
                }
                6 -> if (number7.text.toString().isEmpty()){
                    number6.requestFocus()
                    number6.setText("")
                    currentIndex = 5
                }
                5 -> if (number6.text.toString().isEmpty()) {
                    number5.requestFocus()
                    number5.setText("")
                    currentIndex = 4
                }
                4 -> if (number5.text.toString().isEmpty()) {
                    number4.requestFocus()
                    number4.setText("")
                    currentIndex = 3
                }
                3 -> if (number4.text.toString().isEmpty()) {
                    number3.requestFocus()
                    number3.setText("")
                    currentIndex = 2
                }
                2 -> if (number3.text.toString().isEmpty()) {
                    number2.requestFocus()
                    number2.setText("")
                    currentIndex = 1
                }
                1 -> if (number2.text.toString().isEmpty()) {
                    number1.requestFocus()
                    number1.setText("")
                    currentIndex = 0
                }
            }
        }
        Handler().postDelayed({ touched = false }, 100)
        false
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



    override fun successfulValidation(country: String) {
        //val bundle = Bundle()
        //bundle.putString("country", country)
        val login = LogIn()
        //login.setArguments(bundle)
        val transaction = fragmentManager!!
                .beginTransaction()
        transaction.replace(R.id.contenedor_registro, login)
                .addToBackStack("aa").commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ValidationCode.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ValidationCode().apply {
                    arguments = Bundle().apply {
                    }
                }
    }
}
