package com.example.koachy

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHandler (context: Context): SQLiteOpenHelper(context, dbName, null, 1) {
    companion object VocabDatabase{
        private const val dbName:String ="VocabDatabase"
        private const val tableName = "vocabs"
        private const val id = "id"
        private const val koreanVocab = "koreanVocab"
        private const val englishVocab = "englishVocab"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS $tableName ($id INTEGER PRIMARY KEY, $koreanVocab VARCHAR(60), $englishVocab VARCHAR(60));")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $tableName")
        onCreate(db)
    }

    fun insertData(message: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(koreanVocab, englishVocab, message)
        db.insert(tableName, null, contentValues)
    }

    fun listOfVocabs(): MutableList<String> {
        val db = this.readableDatabase
        val cursor = db.rawQuery("select * from $tableName", null)
        val allVocabs: MutableList<String> = mutableListOf()
        while (cursor.moveToNext()) {
            val i = cursor.getColumnIndex(koreanVocab);
            val j = cursor.getColumnIndex(englishVocab);
            if (i >= 0; j >= 0)
            allVocabs.add(cursor.getString(i, j))
        }
        return allVocabs
    }

    fun updateData(id: String, message: String): Int {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(koreanVocab, englishVocab, message)
        return db.update(tableName, contentValues, "id = ?", arrayOf(id))
    }

    fun deleteData(id: String) : Int {
        val db = this.writableDatabase
        return db.delete(tableName, "id = ?", arrayOf(id))
    }
}