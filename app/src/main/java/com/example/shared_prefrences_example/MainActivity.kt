package com.example.shared_prefrences_example

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.databinding.DataBindingUtil
import com.example.shared_prefrences_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mActivityBinding: ActivityMainBinding
    private val sharedPrefFile = "userFile"
    private lateinit var sp: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        sp = getSharedPreferences(sharedPrefFile, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sp.edit()


        mActivityBinding.saveButton.setOnClickListener {
            val userName=mActivityBinding.userNameEt.text.toString()
            val userEmail=mActivityBinding.userEmailEt.text.toString()
            editor.putString("USER_NAME_KER",userName)
            editor.putString("USER_EMAIL_KEY",userEmail)
            editor.apply()
            editor.commit()

        }

        mActivityBinding.viewButton.setOnClickListener {
            val sharedUserName = sp.getString("USER_NAME_KER",null)
            val sharedUserEmail = sp.getString("USER_EMAIL_KEY",null)
            mActivityBinding.userNameTxt.text = sharedUserName
            mActivityBinding.userEmailTxt.text = sharedUserEmail


        }
        mActivityBinding.clearButton.setOnClickListener {
            editor.remove("USER_NAME_KER")
            editor.remove("USER_EMAIL_KEY")

            editor.apply()
            editor.commit()



            mActivityBinding.userNameTxt.text=""
            mActivityBinding.userNameTxt.text=""

        }


    }
}