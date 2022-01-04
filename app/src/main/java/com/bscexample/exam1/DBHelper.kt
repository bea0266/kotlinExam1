package com.bscexample.exam1

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version) {
    override fun onConfigure(db: SQLiteDatabase?) {
        super.onConfigure(db)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val create = "create table hero ("+
                "name text ," +
                "pos text ," +
                "line text );"
        if (db != null) {
            db?.execSQL(create)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldversion: Int, newversion: Int) {}
}