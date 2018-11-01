package com.periferia.metas_amway.Goals.Lectures.views

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.periferia.metas_amway.Goals.GoalsType

import com.periferia.metas_amway.R
import com.periferia.metas_amway.persistence.AppDb
import com.periferia.metas_amway.persistence.Entities.Book
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LecturePlan.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LecturePlan.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LectureGoalsCreate : androidx.fragment.app.Fragment(), DatePickerDialog.OnDateSetListener {


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var selectDate:ImageView
    private lateinit var initialDate:EditText

    private lateinit var numPages:EditText
    private lateinit var edtxName:EditText
    private lateinit var edtxDate:EditText
    private lateinit var btnCreateGoal:Button
    private var daysToFinish:Int = 0

    private lateinit var db:AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_lecture_goals_create, container, false)

        selectDate = view.findViewById(R.id.btn_selec_date)
        initialDate = view.findViewById(R.id.edtx_initial_date)
        btnCreateGoal = view.findViewById(R.id.btn_create_goal)
        numPages = view.findViewById(R.id.edtx_num_pages)
        edtxName = view.findViewById(R.id.edtx_book_name)
        edtxDate = view.findViewById(R.id.edtx_initial_date)


        db = AppDb.getInstance(context!!)

        val date = getDate()

        initialDate.setText("${date[2]}/${date[1]}/${date[0]}")

        val calendar:Calendar = Calendar.getInstance()
        val lastDayMonth = calendar.getActualMaximum(Calendar.DATE)

        daysToFinish = lastDayMonth - date[2].toInt()

        selectDate.setOnClickListener() { selectDate() }

        btnCreateGoal.setOnClickListener { saveData() }


        return view
    }

    private fun saveData(){

        val goal = Book()
        goal.totalPages = numPages.text.toString().toInt()
        goal.name = edtxName.text.toString()
        goal.created = edtxDate.text.toString()
        goal.finished = daysToFinish

        AsyncTask.execute {
            db.bookDao().saveBook(goal)
        }
        //Toast.makeText(context, "Datos almacenados",Toast.LENGTH_SHORT).show()
        val menu:Fragment = GoalsType()
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.contenedor_principal, menu)
                .commit()
    }

    private fun getDate(): Array<String> {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy/MM/dd ")
        val date = format.format(calendar.time)
        val parts = date.trim { it <= ' ' }.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return parts
    }

    private fun selectDate() {
        val data = getDate()
        val dialog = DatePickerDialog(context!!, this,
                Integer.valueOf(data[0]),
                Integer.valueOf(data[1]),
                Integer.valueOf(data[2]))
        dialog.show()
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        initialDate.setText("$dayOfMonth/${month+1}/$year")
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
         * @return A new instance of fragment LecturePlan.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LectureGoalsCreate().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
