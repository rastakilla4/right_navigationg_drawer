package com.periferia.metas_amway.Goals

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentTransaction
import com.periferia.metas_amway.Goals.Audios.views.AudiosList
import com.periferia.metas_amway.Goals.Events.views.EventsList
import com.periferia.metas_amway.Goals.Lectures.views.LectureGolasList
import com.periferia.metas_amway.Goals.Projects.views.ProjectsList

import com.periferia.metas_amway.Goals.Training.views.TrainingList

import com.periferia.metas_amway.R
import com.periferia.metas_amway.persistence.AppDb

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [GoalsType.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [GoalsType.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class GoalsType : androidx.fragment.app.Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var menuLectura:ImageView
    private lateinit var menuPlans:ImageView
    private lateinit var menuEvents:ImageView
    private lateinit var menuAudios:ImageView
    private lateinit var menuTrainig:ImageView

    private lateinit var transaction:FragmentTransaction

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
        val view:View = inflater.inflate(R.layout.fragment_goals_type, container, false)

        menuLectura = view.findViewById(R.id.menu_lectura)
        menuPlans = view.findViewById(R.id.menu_planes)
        menuEvents = view.findViewById(R.id.menu_eventos)
        menuAudios = view.findViewById(R.id.menu_audios)
        menuTrainig = view.findViewById(R.id.menu_entrenamiento)

        transaction = fragmentManager!!.beginTransaction()

        menuLectura.setOnClickListener() { callLecturePlan() }
        menuPlans.setOnClickListener() { callCreatePlans() }
        menuEvents.setOnClickListener() { callCreateEvents() }
        menuAudios.setOnClickListener() { callCreateAudios() }
        menuTrainig.setOnClickListener() { callCreateTraining() }

        return view
    }

    fun callCreateTraining() {
        val training: Fragment = TrainingList()
        transaction.replace(R.id.contenedor_principal, training)
                .addToBackStack("aa").commit()
    }

    fun callCreateAudios() {
        val audio: Fragment = AudiosList()
        transaction.replace(R.id.contenedor_principal, audio)
                .addToBackStack("aa").commit()
    }

    fun callCreateEvents() {
        val events: Fragment = EventsList()
        transaction.replace(R.id.contenedor_principal, events)
                .addToBackStack("aa").commit()
    }

    fun callLecturePlan() {
        val lecture_list: Fragment = LectureGolasList()
        transaction.replace(R.id.contenedor_principal, lecture_list)
                .addToBackStack("aa").commit()
    }

    fun callCreatePlans() {
        val cretatePlans: Fragment = ProjectsList()
        transaction.replace(R.id.contenedor_principal, cretatePlans)
                .addToBackStack("aa").commit()
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
         * @return A new instance of fragment GoalsType.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                GoalsType().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
