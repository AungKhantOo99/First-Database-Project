package com.ako.lgmpj1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signup.*

class LoginFragment : Fragment()

{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
         inflater: LayoutInflater,
         container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
        {
            val view :View=inflater.inflate(R.layout.fragment_login, container, false)
            val LOGIN=view.findViewById<Button>(R.id.Login)
           LOGIN.setOnClickListener()
            {

                if (loginemail.text.toString().length > 0 &&
                  loginpassward.text.toString().length > 0
              ) {
                    var content = activity as AppCompatActivity
                    var handlerlogin = databaseHelper(content).getInstance(content)
                  if (handlerlogin?.Userpresent(
                          loginemail.text.toString(),
                          loginpassward.text.toString()
                      )!!
                  )
                  { Toast.makeText(content, "Login success", Toast.LENGTH_LONG).show()
                      var intent = activity as Context
                      var bundle=Bundle()
                      var cursor=handlerlogin?.getid(loginemail.text.toString(),
                          loginpassward.text.toString())!!
                      if(cursor!=null && cursor.moveToFirst()){
                         var loginid =cursor.getInt(cursor.getColumnIndex("id"))
                          var intent=Intent(intent,profile::class.java)
                          intent.putExtra("id",loginid)
                          startActivity(intent)
                      }


                  }
                  else{
                      Toast.makeText(
                          content,
                         "email or passward incorrected",
                          Toast.LENGTH_LONG
                      ).show()}
              }
              }
            return view
            }
}

