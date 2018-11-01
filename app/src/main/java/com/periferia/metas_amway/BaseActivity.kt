package com.periferia.metas_amway

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.periferia.metas_amway.Goals.Audios.views.AudioCreateGoal
import com.periferia.metas_amway.Goals.Audios.views.AudiosList
import com.periferia.metas_amway.Goals.Events.views.EventCreateGoal
import com.periferia.metas_amway.Goals.Events.views.EventsList
import com.periferia.metas_amway.Goals.GoalsList
import com.periferia.metas_amway.Goals.GoalsType
import com.periferia.metas_amway.Goals.Lectures.views.LectureGoalsAdd
import com.periferia.metas_amway.Goals.Lectures.views.LectureGoalsCreate
import com.periferia.metas_amway.Goals.Lectures.views.LectureGolasList
import com.periferia.metas_amway.Goals.Projects.views.ProjectsCreateGoal
import com.periferia.metas_amway.Goals.Projects.views.ProjectsList
import com.periferia.metas_amway.Goals.Training.views.TrainingCreateGoal
import com.periferia.metas_amway.Goals.Training.views.TrainingList

open class BaseActivity: AppCompatActivity(),  GoalsType.OnFragmentInteractionListener,
        GoalsList.OnFragmentInteractionListener,
        LectureGoalsCreate.OnFragmentInteractionListener,
        LectureGolasList.OnFragmentInteractionListener,
        LectureGoalsAdd.OnFragmentInteractionListener,
        ProjectsList.OnFragmentInteractionListener,
        ProjectsCreateGoal.OnFragmentInteractionListener,
        EventsList.OnFragmentInteractionListener,
        EventCreateGoal.OnFragmentInteractionListener,
        AudiosList.OnFragmentInteractionListener,
        AudioCreateGoal.OnFragmentInteractionListener,
        TrainingList.OnFragmentInteractionListener,
        TrainingCreateGoal.OnFragmentInteractionListener{

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}