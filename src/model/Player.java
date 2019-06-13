package model;

/**
 * Player model with it's properties
 */
public final class Player {
    String fullName;
    int age;
    String position;
    String broomStick;
    Team team;

    /**
     * Player constructor
     * 
     * @param fullName   player full name
     * @param age        player age
     * @param position   player position
     * @param broomStick player broom stick
     * @param team       player team
     */
    public Player(String fullName, int age, String position, String broomStick, Team team) {
        this.fullName = fullName;
        this.age = age;
        this.position = position;
        this.broomStick = broomStick;
        this.team = team;
    }

    /**
     * gets player fullName
     * 
     * @return full name
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * sets player full name
     * 
     * @param fullName player full name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * gets player age
     * 
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * sets player age
     * 
     * @param age player age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * gets player position
     * 
     * @return position
     */
    public String getPosition() {
        return position;
    }

    /**
     * sets player position
     * 
     * @param position player position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * gets player broom stick
     * 
     * @return broom stick
     */
    public String getBroomStick() {
        return broomStick;
    }

    /**
     * sets player broom stick
     * 
     * @param broomStick player broom stick
     */
    public void setBroomStick(String broomStick) {
        this.broomStick = broomStick;
    }

    /**
     * gets player team
     * 
     * @return team
     */
    public Team getTeam() {
        return team;
    }

    /**
     * sets player team
     * 
     * @param team player team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

}