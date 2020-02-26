package com.marcin.wac.mvvmv2.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.marcin.wac.mvvmv2.R
import com.marcin.wac.mvvmv2.data.models.JokeResponse
import com.marcin.wac.mvvmv2.utilities.di.DaggApp
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as DaggApp).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeUi()
    }

    private fun initializeUi(){
        val viewModel = ViewModelProviders.of(this, factory)
            .get(MainViewModel::class.java)
        viewModel.init()
        viewModel.getNewRepository()!!.observe(this, Observer {
                jokeResponse: JokeResponse ->
            Toast.makeText(this, jokeResponse.value.joke, Toast.LENGTH_SHORT).show()
        })

    }


}
