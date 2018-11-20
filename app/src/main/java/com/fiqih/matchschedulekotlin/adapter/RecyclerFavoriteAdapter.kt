package com.fiqih.matchschedulekotlin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fiqih.matchschedulekotlin.R
import com.fiqih.matchschedulekotlin.model.Favorite
import kotlinx.android.synthetic.main.card_match.view.*

class RecyclerFavoriteAdapter(private val context : Context, private val matches : List<Favorite>, private val listener : (Favorite) -> Unit ) :
    RecyclerView.Adapter<RecyclerFavoriteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_match, parent, false))
    }

    override fun getItemCount(): Int {
        return matches.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMatch(matches[position], listener)
    }

    class ViewHolder (private val containerView: View) : RecyclerView.ViewHolder(containerView){


        @SuppressLint("SetTextI18n")
        fun bindMatch(match : Favorite, listener : (Favorite) -> Unit){

            containerView.match_date.text = match.dateEvent
            containerView.teamA.text = match.strHomeTeam
            containerView.teamB.text = match.strAwayTeam
            containerView.score.text = match.intHomeScore + " VS " + match.intAwayScore
            containerView.setOnClickListener{listener(match)}
        }
    }
}