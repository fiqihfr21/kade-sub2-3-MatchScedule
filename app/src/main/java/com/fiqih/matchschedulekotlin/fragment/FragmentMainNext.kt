package com.fiqih.matchschedulekotlin.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fiqih.matchschedulekotlin.R
import com.fiqih.matchschedulekotlin.activity.DetailActivity
import com.fiqih.matchschedulekotlin.adapter.RecyclerPageAdapter
import com.fiqih.matchschedulekotlin.api.APIRepository
import com.fiqih.matchschedulekotlin.model.DetailMatch
import com.fiqih.matchschedulekotlin.presenter.MatchPresenter
import com.fiqih.matchschedulekotlin.util.InterfaceMatch
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main.*
import org.jetbrains.anko.support.v4.intentFor
import org.jetbrains.anko.support.v4.toast

class FragmentMainNext : Fragment(), InterfaceMatch, SwipeRefreshLayout.OnRefreshListener {


    private lateinit var matchPresenter: MatchPresenter
    private lateinit var adapter: RecyclerPageAdapter
    private var matches: MutableList<DetailMatch> = mutableListOf()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        swipe_layout.setOnRefreshListener(this)

        adapter = RecyclerPageAdapter(this.context!!, matches) {

            startActivity(
                intentFor<DetailActivity>(
                    "matchId" to it.idEvent, "teamA" to it.idHomeTeam, "teamB" to it.idAwayTeam
                )
            )
        }

        match_rcy.layoutManager = LinearLayoutManager(activity)
        match_rcy.adapter = adapter

        val request = APIRepository()
        val gson = Gson()

        matchPresenter = MatchPresenter(this, request, gson)
        matchPresenter.getMatchList(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onRefresh() {
        matchPresenter.getMatchList(true)
    }

    override fun isLoading() {
        progress_circular.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        progress_circular.visibility = View.GONE
    }

    override fun showMatch(data: List<DetailMatch>?) {
        swipe_layout.isRefreshing = false
        matches.clear()
        data?.let {
            matches.addAll(data)
            adapter.notifyDataSetChanged()
        } ?: toast("Kosong")
    }
}