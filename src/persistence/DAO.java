package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Match;
import model.Player;
import model.Team;

/**
 * DAO class with database methods
 */
public class DAO {

    /**
     * database connection object
     */
    private Connection conexion;

    /**
     * creates connection with database
     */
    public void conectar() {
        String url = "jdbc:mysql://127.0.0.1:8889/quidditch?useSSL=false";
        String user = "root";
        String password = "root";
        try {
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * inserts team in databas
     * 
     * @param c team object
     * @return boolean
     */
    public boolean insertTeam(Team c) {
        String insert = "insert into team values (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(insert)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getSchool());
            ps.setDate(3, (Date) c.getFundingDate());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    /**
     * loads team object by team name
     * 
     * @param name team name
     * @return team object
     */
    public Team getTeamByName(String name) {
        Team c = null;
        String select = "select * from team where name=?";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Team(rs.getString("name"), rs.getString("school"), rs.getDate("fundingDate"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    /**
     * counts victories of selected team by team name
     * 
     * @param winner winner team name
     * @return number of victories
     */
    public int getCountWinner(String winner) {
        int wins = 0;
        String select = "SELECT COUNT(winner) FROM `match` WHERE winner=?";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, winner);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    wins = rs.getInt("COUNT(winner)");
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return wins;
    }

    /**
     * loads player object by name from database
     * 
     * @param name player name
     * @return player object
     */
    public Player getPlayerByName(String name) {
        Player c = null;
        String select = "select * from player where fullName=?";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Player(rs.getString("fullName"), rs.getInt("age"), rs.getString("position"),
                            rs.getString("broomStick"), getTeamByName(rs.getString("team")));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    /**
     * loads players arraylist by name from database
     * 
     * @param team team name
     * @return players arraylist
     */
    public ArrayList<Player> getPlayersByTeam(String team) {
        ArrayList<Player> players = new ArrayList<>();
        Player c = null;
        String select = "select * from player where team=?";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setString(1, team);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    c = new Player(rs.getString("fullName"), rs.getInt("age"), rs.getString("position"),
                            rs.getString("broomStick"), getTeamByName(rs.getString("team")));
                    players.add(c);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return players;
    }

    /**
     * updates player in database
     * 
     * @param c player object
     * @return boolean
     */
    public Boolean updatePlayer(Player c) {
        String sql = "update player set `fullName`=?,`age`=?,`position`=?,`broomStick`=?,`team`=? where fullName=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, c.getFullName());
            stmt.setInt(2, c.getAge());
            stmt.setString(3, c.getPosition());
            stmt.setString(4, c.getBroomStick());
            stmt.setString(5, c.getTeam().getName());
            stmt.setString(6, c.getFullName());
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    /**
     * removes player selected from database
     * 
     * @param c player object
     * @return boolean
     */
    public Boolean removePlayer(Player c) {
        String sql = "delete from player where fullName=?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, c.getFullName());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    /**
     * loads players arraylist from database
     * 
     * @return players arraylist
     */
    public ArrayList<Player> getPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        Player c = null;
        String select = "select * from player";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    c = new Player(rs.getString("fullName"), rs.getInt("age"), rs.getString("position"),
                            rs.getString("broomStick"), getTeamByName(rs.getString("team")));
                    players.add(c);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        System.out.println(players);
        return players;
    }

    /**
     * loads match object from database by match id
     * 
     * @param id match id
     * @return match object
     */
    public Match getMatchById(int id) {
        Match c = null;
        String select = "select * from `match` where idmatch=?";
        try (PreparedStatement ps = conexion.prepareStatement(select)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    c = new Match(rs.getInt("idmatch"), rs.getDate("date"), rs.getString("place"),
                            getTeamByName(rs.getString("team1")), getTeamByName(rs.getString("team2")),
                            getTeamByName(rs.getString("winner")));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return c;
    }

    /**
     * inserts match object into database
     * 
     * @param c match object
     * @return boolean
     */
    public boolean insertMatch(Match c) {
        String insert = "insert into `match` values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(insert)) {
            ps.setInt(1, c.getIdMatch());
            ps.setDate(2, c.getDate());
            ps.setString(3, c.getPlace());
            ps.setString(4, c.getTeam1().getName());
            ps.setString(5, c.getTeam2().getName());
            ps.setString(6, c.getWinner().getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    /**
     * inserts player object into database
     * 
     * @param c player object
     * @return boolean
     */
    public boolean insertPlayer(Player c) {
        String insert = "insert into player values (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(insert)) {
            ps.setString(1, c.getFullName());
            ps.setInt(2, c.getAge());
            ps.setString(3, c.getPosition());
            ps.setString(4, c.getBroomStick());
            ps.setString(5, c.getTeam().getName());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }

    /**
     * loads team arraylist from database
     * 
     * @return team arraylist
     */
    public ArrayList<Team> getTeams() {
        ArrayList<Team> teams = new ArrayList<>();
        Team c = null;
        String select = "select * from team";
        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery(select)) {
                while (rs.next()) {
                    c = new Team(rs.getString("name"), rs.getString("school"), rs.getDate("fundingDate"));
                    teams.add(c);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return teams;
    }

    /**
     * loads match arraylist from database
     * 
     * @return match arraylist
     */
    public ArrayList<Match> getMatches() {
        ArrayList<Match> matches = new ArrayList<>();
        Match c = null;
        String select = "select * from `match`";
        try (Statement st = conexion.createStatement()) {
            try (ResultSet rs = st.executeQuery(select)) {
                while (rs.next()) {
                    c = new Match(rs.getInt("idmatch"), rs.getDate("date"), rs.getString("place"),
                            getTeamByName(rs.getString("team1")), getTeamByName(rs.getString("team2")),
                            getTeamByName(rs.getString("winner")));
                    matches.add(c);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return matches;
    }

    /**
     * closes connection with database
     */
    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

}
