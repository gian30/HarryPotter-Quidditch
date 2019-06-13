package model;

import java.sql.Date;

/**
 * Team model with it's properties
 */
public final class Team {
    String name;
    String school;
    Date fundingDate;

    /**
     * Team constructor
     * 
     * @param name        team name
     * @param school      team school
     * @param fundingDate team fundation date
     */
    public Team(String name, String school, Date fundingDate) {
        this.name = name;
        this.school = school;
        this.fundingDate = fundingDate;
    }

    /**
     * gets team name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets team name
     * 
     * @param name team name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets team school
     * 
     * @return school
     */
    public String getSchool() {
        return school;
    }

    /**
     * sets team school
     * 
     * @param school team school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * gets team funding date
     * 
     * @return fundingDate
     */
    public Date getFundingDate() {
        return fundingDate;
    }

    /**
     * sets team funding date
     * 
     * @param fundingDate team funding date
     */
    public void setFundingDate(Date fundingDate) {
        this.fundingDate = fundingDate;
    }

}