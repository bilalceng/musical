package com.bilalberek.musical.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.bilalberek.musical.R
import com.bilalberek.musical.repository.ItunesRepo
import com.bilalberek.musical.service.ItunesService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class MusicActivity : AppCompatActivity() {

     val TAG = javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itunesService = ItunesService.instance
        val itunesRepo = ItunesRepo(itunesService)

        GlobalScope.launch {
            val result = itunesRepo.getMusics("barrack obama")
            Log.d(TAG, "${result.body()}")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        menuInflater.inflate(R.menu.search_menu,menu)

        return true

    }



}