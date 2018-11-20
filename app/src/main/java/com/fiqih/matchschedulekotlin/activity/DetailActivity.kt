package com.fiqih.matchschedulekotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.fiqih.matchschedulekotlin.R
import com.fiqih.matchschedulekotlin.api.APIRepository
import com.fiqih.matchschedulekotlin.model.DetailMatch
import com.fiqih.matchschedulekotlin.model.DetailTeam
import com.fiqih.matchschedulekotlin.presenter.DetailPresenter
import com.fiqih.matchschedulekotlin.presenter.TeamPresenter
import com.fiqih.matchschedulekotlin.util.InterfaceMatch
import com.fiqih.matchschedulekotlin.util.InterfaceTeam
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(), InterfaceMatch, InterfaceTeam {

    private lateinit var idTeamA: String
    private lateinit var idTeamB: String
    private lateinit var idMatch: String
    private lateinit var match: DetailMatch

    private lateinit var teamA: DetailTeam
    private lateinit var teamB: DetailTeam

    private lateinit var teamPresenter: TeamPresenter
    private lateinit var matchDetailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        idMatch = intent.getStringExtra("matchId")
        idTeamA = intent.getStringExtra("teamA")
        idTeamB = intent.getStringExtra("teamB")

        val request = APIRepository()
        val gson = Gson()

        teamPresenter = TeamPresenter(this, request, gson)
        matchDetailPresenter = DetailPresenter(this, request, gson)

        teamPresenter.geDetailTeamList(idTeamA, idTeamB)
        matchDetailPresenter.getDetailMatch(idMatch)
    }

    override fun isLoading() {

        progress_detail.visibility = View.VISIBLE

    }

    override fun stopLoading() {

        progress_detail.visibility = View.GONE

    }

    override fun showMatch(data: List<DetailMatch>?) {

        match = DetailMatch(
            data?.get(0)?.idEvent,
            data?.get(0)?.strHomeTeam,
            data?.get(0)?.strAwayTeam,
            data?.get(0)?.intHomeScore,
            data?.get(0)?.intAwayScore,
            data?.get(0)?.dateEvent,
            data?.get(0)?.strHomeLineupGoalkeeper,
            data?.get(0)?.strAwayLineupGoalkeeper,
            data?.get(0)?.strHomeGoalDetails,
            data?.get(0)?.strAwayGoalDetails,
            data?.get(0)?.intHomeShots,
            data?.get(0)?.intAwayShots,
            data?.get(0)?.strHomeLineupDefense,
            data?.get(0)?.awayDefense,
            data?.get(0)?.strAwayLineupDefense,
            data?.get(0)?.strAwayLineupMidfield,
            data?.get(0)?.strHomeLineupForward,
            data?.get(0)?.strAwayLineupForward,
            data?.get(0)?.strHomeLineupSubstitutes,
            data?.get(0)?.strAwayLineupSubstitutes,
            data?.get(0)?.strHomeFormation,
            data?.get(0)?.strAwayFormation,
            data?.get(0)?.strTeamBadge,
            data?.get(0)?.idHomeTeam,
            data?.get(0)?.idAwayTeam
        )

        home_name.text = match.strHomeTeam
        home_score_match.text = match.intHomeScore
        home_goals.text = match.strHomeGoalDetails
        home_goalkeeper.text = match.strHomeLineupGoalkeeper
        home_shots.text = match.intHomeShots
        home_defense.text = match.strHomeLineupDefense
        home_forward.text = match.strHomeLineupForward
        home_substitutes.text = match.strHomeLineupSubstitutes
        home_midfield.text = match.strAwayLineupDefense

        away_name.text = match.strAwayTeam
        away_score_match.text = match.intAwayScore
        away_goals.text = match.strAwayGoalDetails
        away_goalkeeper.text = match.strAwayLineupGoalkeeper
        away_shot.text = match.intAwayShots
        away_defense.text = match.awayDefense
        away_forward.text = match.strAwayLineupForward
        away_substitutes.text = match.strAwayLineupSubstitutes
        away_midfield.text = match.strAwayLineupMidfield
        match_date.text = match.dateEvent

    }

    override fun showTeam(data: List<DetailTeam>?, dataB: List<DetailTeam>?) {
        teamA = DetailTeam(data?.get(0)?.strTeamBadge)
        teamB = DetailTeam(dataB?.get(0)?.strTeamBadge)
        Glide.with(this).load(data?.get(0)?.strTeamBadge).into(img_home)
        Glide.with(this).load(dataB?.get(0)?.strTeamBadge).into(img_away)
    }

}
