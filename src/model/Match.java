package model;

import java.sql.Date;

/**
 * Match model with it's properties
 */
public class Match {
    int idMatch;
    Date date;
    String place;
    Team team1;
    Team team2;
    Team winner;

    /**
     * 
     * @param idMatch match id
     * @param date    match date
     * @param place   match place
     * @param team1   match team1
     * @param team2   match team2
     * @param winner  match winner
     */
    public Match(int idMatch, Date date, String place, Team team1, Team team2, Team winner) {
        this.idMatch = idMatch;
        this.date = date;
        this.place = place;
        this.team1 = team1;
        this.team2 = team2;
        this.winner = winner;
    }

    /**
     * gets match id
     * 
     * @return id
     */
    public int getIdMatch() {
        return idMatch;
    }

    /**
     * sets id match
     * 
     * @param idMatch id match
     */
    public void setIdMatch(int idMatch) {
        this.idMatch = idMatch;
    }

    /**
     * gets match date
     * 
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * sets match date
     * 
     * @param date match date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * gets match place
     * 
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * sets match place
     * 
     * @param place match place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * gets match team1
     * 
     * @return team1
     */
    public Team getTeam1() {
        return team1;
    }

    /**
     * sets match team1
     * 
     * @param team1 match team1
     */
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    /**
     * gets match team2
     * 
     * @return team2
     */
    public Team getTeam2() {
        return team2;
    }

    /**
     * sets match team2
     * 
     * @param team2 match team2
     */
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    /**
     * gets match winner
     * 
     * @return winner
     */
    public Team getWinner() {
        return winner;
    }

    /**
     * sets match winner
     * 
     * @param winner match winner
     */
    public void setWinner(Team winner) {
        this.winner = winner;
    }
}
