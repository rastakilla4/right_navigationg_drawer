package com.periferia.metas_amway

import android.os.Bundle
import android.view.Gravity
import com.google.android.material.navigation.NavigationView
import androidx.fragment.app.Fragment
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.periferia.metas_amway.Goals.GoalsList

import kotlinx.android.synthetic.main.activity_menu_principal.*
import kotlinx.android.synthetic.main.app_bar_menu_principal.*

class MenuPrincipal : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var menu_goals:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)
        setSupportActionBar(toolbar)


        menu_goals = findViewById(R.id.menu1)

        menu_goals.setOnClickListener() {goToGoals()}


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }


    private fun goToGoals(){
        val fragment:Fragment = GoalsList()
        supportFragmentManager.beginTransaction()
                .replace(R.id.contenedor_principal,fragment)
                .addToBackStack("aa").commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.END)) {
            drawer_layout.closeDrawer(GravityCompat.END)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> {
                if(drawer_layout.isDrawerOpen(Gravity.RIGHT)){
                    drawer_layout.closeDrawer((Gravity.RIGHT))
                } else {
                    drawer_layout.openDrawer(Gravity.RIGHT)
                }
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        var fragment: Fragment? = null
        var fragmentIsSelected = false

        when (item.itemId) {
            R.id.nav_metas -> {
                fragment = GoalsList()
                fragmentIsSelected = true
            }
            R.id.nav_inventario -> {

            }
            R.id.nav_clientes -> {

            }
            R.id.nav_perfil -> {

            }
            R.id.nav_sincronizar -> {

            }
        }

        if (fragmentIsSelected) {
            supportFragmentManager.beginTransaction().replace(R.id.contenedor_principal, fragment!!).addToBackStack("aa").commit()
        }

        drawer_layout.closeDrawer(GravityCompat.END)
        return true
    }
}
