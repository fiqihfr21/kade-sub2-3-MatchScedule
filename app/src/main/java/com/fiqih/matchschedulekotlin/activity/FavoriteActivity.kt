package com.fiqih.matchschedulekotlin.activity

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.fiqih.matchschedulekotlin.R
import com.fiqih.matchschedulekotlin.adapter.RecyclerFavoriteAdapter
import com.fiqih.matchschedulekotlin.helper.database
import com.fiqih.matchschedulekotlin.model.Favorite
import kotlinx.android.synthetic.main.activity_favorite.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.intentFor

class FavoriteActivity : AppCompatActivity(), SwipeRefreshLayout.OnRefreshListener {


    private lateinit var adapter: RecyclerFavoriteAdapter
    private var favoriteMatch: MutableList<Favorite> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)

        supportActionBar?.title = getString(R.string.fav_matches)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        fav_swipe_layout.setOnRefreshListener(this)


        adapter = RecyclerFavoriteAdapter(this, favoriteMatch) {
            startActivity(
                intentFor<DetailActivity>(
                    "matchId" to it.idEvent, "teamA" to it.idHomeTeam, "teamB" to it.idAwayTeam
                )
            )
        }

        fav_match_rcy.layoutManager = LinearLayoutManager(this)
        fav_match_rcy.adapter = adapter
        getMatches()
    }

    override fun onRefresh() {
        favoriteMatch.clear()
        getMatches()
    }

    private fun getMatches(){
        this.database.use{
            fav_swipe_layout.isRefreshing = false
            val result = select(Favorite.TABLE_FAVORITE)
            val favorite = result.parseList(classParser<Favorite>())
            favoriteMatch.addAll(favorite)
            adapter.notifyDataSetChanged()
        }
    }
}