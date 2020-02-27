package com.marcin.wac.mvvmv2.modules

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.marcin.wac.mvvmv2.R
import com.marcin.wac.mvvmv2.adapters.JokesAdapter
import com.marcin.wac.mvvmv2.data.models.JokeResponse
import com.marcin.wac.mvvmv2.utilities.di.DaggApp
import kotlinx.android.synthetic.main.activity_main.*
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
        main_recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.getJokeResponseLiveData()!!.observe(this, Observer {
                jokeResponse: JokeResponse? ->
            main_recyclerview.adapter = JokesAdapter(jokeResponse?.value) {onJokeClick(it) }

        })
    }

    private fun onJokeClick(joke: String){
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show()
    }
}
