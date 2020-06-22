package com.ako.lgmpj1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import android.os.AsyncTask
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.PrecomputedTextCompat
import kotlinx.android.synthetic.main.fragment_signup.*
import java.util.jar.Attributes

class SignupFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_signup, container, false)
        // signup().execute()
        var Signup = view.findViewById<Button>(R.id.register)
        Signup.setOnClickListener() {
            var content = activity as AppCompatActivity
            var handlersignup = databaseHelper(content)
            var signupid = handlersignup.getid(
                newemail.text.toString(),
                newpassward.text.toString()
            )

            if (name.text.toString().length > 0 &&
                newemail.text.toString().length > 0 &&
                newpassward.text.toString().length > 0
            ) {
                if (handlersignup.insertUserData(
                        name.text.toString(), newemail.text.toString(),
                        newpassward.text.toString()
                    )
                ) {

                    Toast.makeText(content, "Register successful", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(content, "Fill all filed", Toast.LENGTH_LONG).show()
                }

            }
        }
        return view
    }
}
//    inner class signup():AsyncTask<String,Unit,Unit>(){
//        override fun doInBackground(vararg params: String?) {
//               register.setOnClickListener{
//                   var content = activity as AppCompatActivity
//                   var handlersignup=databaseHelper(content)
//                   if(name.text.toString().length>0&&
//                           newemail.text.toString().length>0&&
//                           newpassward.text.toString().length>0){
//                       handlersignup.insertUserData(name.text.toString(),newemail.text.toString(),
//                           newpassward.text.toString())
//                       Toast.makeText(content,"Register successful",Toast.LENGTH_LONG).show()
//                   }
//                   else{
//                       Toast.makeText(content,"Fill all field",Toast.LENGTH_LONG).show()
//                   }
//               }
//        }
//
//    }
//    }

