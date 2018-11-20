package com.fiqih.matchschedulekotlin.api

object TheSportsDBAPI {

    fun getLastMatch():String{
        return "https://www.thesportsdb.com/api/v1/json/1/eventspastleague.php?id=4328"
    }

    fun getNextMatch():String{
        return "https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4328"
    }

    fun getMatch(matchId : String?):String{
        return "https://www.thesportsdb.com/api/v1/json/1/lookupevent.php?id=$matchId"
    }

    fun getTeam(teamId : String?):String{
        return "https://www.thesportsdb.com/api/v1/json/1/lookupteam.php?id=$teamId"
    }
}