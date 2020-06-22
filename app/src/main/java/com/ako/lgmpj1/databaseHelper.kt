package com.ako.lgmpj1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class databaseHelper(context: Context):SQLiteOpenHelper(context,dbname,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
            db.execSQL(
                "create table user(id integer primary key autoincrement," +
                        "name varchar(30),email varchar(40),passward varchar(20))"
            )
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists user")
    }

    fun insertUserData(name: String, email: String, passward: String) :Boolean{
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("name", name)
        values.put("email", email)
        values.put("passward", passward)
        var cursor=db.insert("user", null, values)
        if(cursor.equals(-1))
            return false
           return true
        db.close()
    }
    fun Userpresent(email: String, passward: String): Boolean {
        val db = writableDatabase
        val query = "select * from user where email='$email' and passward='$passward'"
        val cursor = db.rawQuery(query, null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
     fun readname(id:Int) : String {
         val db = readableDatabase
         val query = "select * from user where id = $id"
         val cursor = db.rawQuery(query, null)
         if (cursor.moveToFirst()) {
             val name = cursor.getString(cursor.getColumnIndex("name"))
             return name
         }
         return "error!"
     }
    fun reademail(id:Int) : String {
        val db = readableDatabase
        val query = "select * from user where id=$id"
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
             val email = cursor.getString(cursor.getColumnIndex("email"))
            return email
        }
        return "error!"
    }
     fun update(id:Int,name:String,email: String,passward: String){
         var db=writableDatabase
         var values=ContentValues()
         values.put("name",name)
         values.put("email",email)
         values.put("passward",passward)
         db.update("user",values,"id="+id,null)
     }
     private var databaseInstance : databaseHelper?= null
    fun getInstance(context: Context):databaseHelper?{
        if(databaseInstance==null){
            databaseInstance= databaseHelper(context)
        }
        return databaseInstance
    }
    fun getid(email: String,passward: String): Cursor {
        val db=readableDatabase
        val que="select id from user where email='$email' and passward='$passward'"
        val cursor=db.rawQuery(que,null)
        return cursor
    }
    companion object{
        internal val dbname="userDB"
        internal val factory = null
        internal val version=1
    }
}



