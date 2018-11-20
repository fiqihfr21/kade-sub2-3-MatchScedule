package com.fiqih.matchschedulekotlin.model

data class Favorite(
    val id: Long? = null,
    val idEvent: String? = null,
    val strHomeTeam: String? = null,
    val strAwayTeam: String? = null,
    val intHomeScore: String? = null,
    val intAwayScore: String? = null,
    val dateEvent: String? = null,
    val strHomeLineupGoalkeeper: String? = null,
    val strAwayLineupGoalkeeper: String? = null,
    val strHomeGoalDetails: String? = null,
    val strAwayGoalDetails: String? = null,
    val intHomeShots: String? = null,
    val intAwayShots: String? = null,
    val strHomeLineupDefense: String? = null,
    val awayDefense: String? = null,
    val strAwayLineupDefense: String? = null,
    val strAwayLineupMidfield: String? = null,
    val strHomeLineupForward: String? = null,
    val strAwayLineupForward: String? = null,
    val strHomeLineupSubstitutes: String? = null,
    val strAwayLineupSubstitutes: String? = null,
    val strHomeFormation: String? = null,
    val strAwayFormation: String? = null,
    val strTeamBadge: String? = null,
    val idHomeTeam: String? = null,
    val idAwayTeam: String? = null
) {

    companion object {
        const val TABLE_FAVORITE: String = "TABLE_FAVORITE"
        const val ID: String = "ID_"
        const val ID_EVENT: String = "ID_EVENT"
        const val STR_HOME_TEAM: String = "STR_HOME_TEAM"
        const val STR_AWAY_TEAM: String = "STR_AWAY_TEAM"
        const val INT_HOME_SCORE: String = "INT_HOME_SCORE"
        const val INT_AWAY_SCORE: String = "INT_AWAY_SCORE"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val STR_HOME_LINEUP_GOALKEEPER: String = "STR_HOME_LINEUP_GOALKEEPER"
        const val STR_AWAY_LINEUP_GOALKEEPER: String = "STR_AWAY_LINEUP_GOALKEEPER"
        const val STR_HOME_GOAL_DETAILS: String = "STR_HOME_GOAL_DETAILS"
        const val STR_AWAY_GOAL_DETAILS: String = "STR_AWAY_GOAL_DETAILS"
        const val INT_HOME_SHOTS: String = "INT_HOME_SHOTS"
        const val INT_AWAY_SHOTS: String = "INT_AWAY_SHOTS"
        const val STR_HOME_LINEUP_DEFENSE: String = "STR_HOME_LINEUP_DEFENSE"
        const val AWAY_DEFENSE: String = "AWAY_DEFENSE"
        const val STR_AWAY_LINEUP_DEFENSE: String = "STR_AWAY_LINEUP_DEFENSE"
        const val STR_AWAY_LINEUP_MIDFIELD: String = "STR_AWAY_LINEUP_MIDFIELD"
        const val STR_HOME_LINEUP_FORWARD: String = "STR_HOME_LINEUP_FORWARD"
        const val STR_AWAY_LINEUP_FORWARD: String = "STR_AWAY_LINEUP_FORWARD"
        const val STR_HOME_LINEUP_SUBSTITUTES: String = "STR_HOME_LINEUP_SUBSTITUTES"
        const val STR_AWAY_LINEUP_SUBSTITUTES: String = "STR_AWAY_LINEUP_SUBSTITUTES"
        const val STR_HOME_FORMATION: String = "STR_HOME_FORMATION"
        const val STR_AWAY_FORMATION: String = "STR_AWAY_FORMATION"
        const val STR_TEAM_BADGE: String = "STR_TEAM_BADGE"
        const val ID_HOME_TEAM: String = "ID_HOME_TEAM"
        const val ID_AWAY_TEAM: String = "ID_AWAY_TEAM"
    }
}