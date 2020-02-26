package com.marcin.wac.mvvmv2.modules

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
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
        initialization()
    }

    private fun initialization() {
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.getJokeResponseLiveData()!!.observe(this, Observer {
                jokeResponse: JokeResponse? ->
            if (jokeResponse != null) {
                Toast.makeText(this, jokeResponse.value[0].joke, Toast.LENGTH_LONG).show()
            } else
                Toast.makeText(this, "null", Toast.LENGTH_LONG).show()

        })
    }


}
