package com.fiqih.matchschedulekotlin.api

import com.fiqih.matchschedulekotlin.model.DetailMatch
import com.fiqih.matchschedulekotlin.model.Matchs
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("eventsnextleague.php?id=4328")
    fun getLastMatch(): Observable<Matchs>

    @GET("eventspastleague.php?id=4328")
    fun getNextMatch(): Observable<Matchs>

    @GET("lookupevent.php?id={matchId}")
    fun getMatch(@Path("matchId") matchId: String?) : Observable<DetailMatch>

    @GET("lookupteam.php?id={teamId}")
    fun getTeam(@Path("teamId") teamId : String?) : Observable<DetailMatch>



    companion object Factory {
        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.thesportsdb.com/api/v1/json/1/")
                .build()
            return retrofit.create(APIService::class.java)
        }
    }
}