package com.marcin.wac.mvvmv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marcin.wac.mvvmv2.R
import com.marcin.wac.mvvmv2.data.models.Value
import kotlinx.android.synthetic.main.row_joke.view.*

class JokesAdapter(jokesList: List<Value>?,
                   val onJokeClick: (String) -> Unit): RecyclerView.Adapter<JokesAdapter.ViewHolder>() {

    private var mutableJokesList = jokesList?.toMutableList()

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.row_joke, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return mutableJokesList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mutableJokesList.let {
            val current = mutableJokesList?.get(position)

            with(holder.itemView) {
                row_joke_number.text = current?.id.toString()
                row_joke_text.text = current?.joke

                setOnClickListener { onJokeClick(current?.joke ?: "") }
            }
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}