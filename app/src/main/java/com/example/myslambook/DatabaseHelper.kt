package com.example.myslambook

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Database helper class to handle the SQLite database
class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        // Create the users table
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_USERNAME TEXT, $COLUMN_PASSWORD TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Drop old table if it exists and create a new one
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addUser(username: String, password: String) {
        val db = writableDatabase
        val insertQuery = "INSERT INTO $TABLE_NAME ($COLUMN_USERNAME, $COLUMN_PASSWORD) VALUES ('$username', '$password')"
        db.execSQL(insertQuery)
        db.close()
    }

    fun validateUser(username: String, password: String): Boolean {
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_USERNAME = '$username' AND $COLUMN_PASSWORD = '$password'"
        val cursor = db.rawQuery(query, null)
        val isValid = cursor.count > 0
        cursor.close()
        db.close()
        return isValid
    }

    companion object {
        const val DATABASE_NAME = "UserDB"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"
        const val COLUMN_ID = "id"
        const val COLUMN_USERNAME = "username"
        const val COLUMN_PASSWORD = "password"
    }
}
