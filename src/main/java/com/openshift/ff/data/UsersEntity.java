package com.openshift.ff.data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by spousty on 10/26/14.
 */
@Entity
@Table(name = "users", schema = "public", catalog = "flatfluffy")
public class UsersEntity {
    private int usersid;
    private String nick;
    private Integer points;
    private String notes;
    private Timestamp entrytimestamp;

    @Id
    @Column(name = "usersid")
    public int getUsersid() {
        return usersid;
    }

    public void setUsersid(int usersid) {
        this.usersid = usersid;
    }

    @Basic
    @Column(name = "nick")
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Basic
    @Column(name = "points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "entrytimestamp")
    public Timestamp getEntrytimestamp() {
        return entrytimestamp;
    }

    public void setEntrytimestamp(Timestamp entrytimestamp) {
        this.entrytimestamp = entrytimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (usersid != that.usersid) return false;
        if (entrytimestamp != null ? !entrytimestamp.equals(that.entrytimestamp) : that.entrytimestamp != null)
            return false;
        if (nick != null ? !nick.equals(that.nick) : that.nick != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (points != null ? !points.equals(that.points) : that.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = usersid;
        result = 31 * result + (nick != null ? nick.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (entrytimestamp != null ? entrytimestamp.hashCode() : 0);
        return result;
    }
}
