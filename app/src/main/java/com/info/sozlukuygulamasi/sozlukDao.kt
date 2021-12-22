package com.info.sozlukuygulamasi

import android.annotation.SuppressLint

class sozlukDao {
    fun tumKelimeler(vt:VeritabaniYardimcisi):ArrayList<Kelimeler>{
        val kelimelerliste=ArrayList<Kelimeler>()

        val db =vt.writableDatabase
        val c= db.rawQuery("SELECT * FROM kelimeler",null)
           while (c.moveToNext()){
               val kelimeler =Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
               c.getString(c.getColumnIndex("ingilizce")),
               c.getString(c.getColumnIndex("turkce")))
               kelimelerliste.add(kelimeler)
           }
 return kelimelerliste
    }


    @SuppressLint("Recycle")
    fun aramaYap(vt:VeritabaniYardimcisi, aramaKelime:String):ArrayList<Kelimeler>{
        val kelimelerliste=ArrayList<Kelimeler>()

        val db =vt.writableDatabase
        val c= db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%'",null)
        while (c.moveToNext()){
            val kelimeler =Kelimeler(c.getInt(c.getColumnIndex("kelime_id")),
                c.getString(c.getColumnIndex("ingilizce")),
                c.getString(c.getColumnIndex("turkce")))
            kelimelerliste.add(kelimeler)
        }
        return kelimelerliste
    }
}