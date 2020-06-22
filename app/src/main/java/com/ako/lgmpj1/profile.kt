package com.ako.lgmpj1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ako.lgmpj1.databaseHelper.Companion.dbname
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.fragment_signup.*

class profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val handler=databaseHelper(this)
       var id= intent.getIntExtra("id",-1)
        var name=handler.readname(id)
        username.setText(name)
        var email=handler.reademail(id)
        useremail.setText(email.toString())
        userupdate.setOnClickListener(){
         if(username.text.toString().length>0&&
                 useremail.text.toString().length>0&&
                 newuserpassward.text.toString().length>0&&
                 newusercomfirmpassward.text.toString().length>0){
             if(newuserpassward.text.toString().equals(newusercomfirmpassward.text.toString())){
                 handler.update(id,username.text.toString(),useremail.text.toString()
                 ,newuserpassward.text.toString())
                  Toast.makeText(this,"Successfully update",Toast.LENGTH_LONG).show()
             }
             else{
                 Toast.makeText(this,"Please give the same passward",Toast.LENGTH_LONG).show()
             }
         }
            else{
             Toast.makeText(this,"Enter all field",Toast.LENGTH_LONG).show()
         }
        }
    }
}
