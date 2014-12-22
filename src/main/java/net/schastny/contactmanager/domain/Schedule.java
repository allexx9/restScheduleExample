package net.schastny.contactmanager.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrsutkov on 05.12.14.
 */
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Column(name = "date")
    Date date;
    @Column(name = "audience")
    String audience;
    @Column(name = "lessonNumber")
    int lessonNumber;
    @Column(name = "teacher")
    String teacher;
    @Column(name = "discipline")
    String discipline;
    @Column(name = "groupnumber")
    String groupNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", date=" + date +
                ", audience='" + audience + '\'' +
                ", lessonNumber=" + lessonNumber +
                ", teacher='" + teacher + '\'' +
                ", discipline='" + discipline + '\'' +
                ", groupNumber='" + groupNumber + '\'' +
                '}';
    }
}
