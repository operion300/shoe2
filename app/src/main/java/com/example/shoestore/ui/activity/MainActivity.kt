package com.example.shoestore.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val navController:NavController by lazy { this.findNavController(R.id.host_fragment) }
    //private val navFragment:NavHostFragment = supportFragmentManager.findFragmentById(R.id.host_fragment) as NavHostFragment
    //private val navController = navFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(this,navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController:NavController = this.findNavController(R.id.host_fragment)
        return navController.navigateUp()
    }

    override fun onBackPressed() {
        val navController:NavController = this.findNavController(R.id.host_fragment)
        navController.navigateUp()
    }
}

/**
 * alterações para fazer (revisão):
 * 3 - binding as editViews da detailScreen usando a tag <data>;
 * 4 - adicionar um menu na shoeList screen com a opção de logout (levar o usuário para  a tela de login); esse menu
 * só deve aparecer nessa tela;
 * 5 - reparar o add item na lista; professor colocou algumas dicas na revisão (ver)
 */