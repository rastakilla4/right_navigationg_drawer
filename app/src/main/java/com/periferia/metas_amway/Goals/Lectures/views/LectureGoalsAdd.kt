package com.periferia.metas_amway.Goals.Lectures.views

import android.app.DatePickerDialog
import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.recyclerview.widget.LinearLayoutManager
import com.periferia.metas_amway.Goals.Lectures.adapters.ListGoalsHistoryAdapter

import com.periferia.metas_amway.R
import com.periferia.metas_amway.persistence.AppDb
import com.periferia.metas_amway.persistence.Entities.Book
import com.periferia.metas_amway.persistence.Entities.DetailBook
import kotlinx.android.synthetic.main.fragment_lecture_goals_add.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [LectureGoalsAdd.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [LectureGoalsAdd.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class LectureGoalsAdd : Fragment(), DatePickerDialog.OnDateSetListener {
    // TODO: Rename and change types of parameters
    private var goalId: Int? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var viewItem:View
    val detail: ArrayList<DetailBook> = ArrayList()

    private var lastPageRead:Int = 0

    private lateinit var db: AppDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDb.getInstance(context!!)
        addData()
        arguments?.let {
            goalId = it.getInt("goalID")
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        viewItem = inflater.inflate(R.layout.fragment_lecture_goals_add, container, false)

        viewItem.img_detail_date.setOnClickListener { selectDate() }

        viewItem.btn_detail_save.setOnClickListener { saveData() }

        val date = getDate()

        viewItem.edtx_detail_date.setText("${date[2]}/${date[1]}/${date[0]}")

        viewItem.recycler_detail_history.layoutManager = LinearLayoutManager(context)
        viewItem.recycler_detail_history.adapter = ListGoalsHistoryAdapter(detail.asReversed())

        viewItem.edtx_detail_number.setText(lastPageRead.toString())

        return viewItem
    }

    private fun addData() {
        AsyncTask.execute{
            db.detailBookDao().historyList(goalId!!).forEach{
                detail.add(it)
                lastPageRead = it.lastPageRead!!
            }
        }
    }

    private fun saveData() {
        val detail = DetailBook()
        detail.idGoal = goalId
        detail.lastPageRead = viewItem.edtx_detail_number.text.toString().toInt()
        detail.created = viewItem.edtx_detail_date.text.toString()

        val book = Book()
        book.id = goalId
        book.currentPage = viewItem.edtx_detail_number.text.toString().toInt()

        AsyncTask.execute {
            db.detailBookDao().saveDetailBook(detail)
            db.bookDao().setCurrentPage(book)
        }
        activity!!.supportFragmentManager.popBackStack()
    }

    private fun selectDate() {
        val data = getDate()
        val dialog = DatePickerDialog(context!!, this,
                Integer.valueOf(data[0]),
                Integer.valueOf(data[1]),
                Integer.valueOf(data[2]))
        dialog.show()
    }


    private fun getDate(): Array<String> {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy/MM/dd ")
        val date = format.format(calendar.time)
        val parts = date.trim { it <= ' ' }.split("/".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        return parts
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        viewItem.edtx_detail_date.setText("$dayOfMonth/${month+1}/$year")
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
         * @return A new instance of fragment LectureGoalsAdd.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                LectureGoalsAdd().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
