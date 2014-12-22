package net.schastny.contactmanager.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by adm on 16.12.2014.
 */
@Entity
@Table(name="raspisanie")
public class Raspisanie {
    @Id
    @GeneratedValue
    int id;
    String grp;
    String day;
    int pair;
    String discip;
    String occup;
    String prim;
    String auditor;
    String teacher_fam;
    String teacher_name;
    String teacher_otvo;

    @Override
    public String toString() {
        return "Raspisanie{" +
                "id=" + id +
                ", grp='" + grp + '\'' +
                ", day='" + day + '\'' +
                ", pair=" + pair +
                ", discip='" + discip + '\'' +
                ", occup='" + occup + '\'' +
                ", prim='" + prim + '\'' +
                ", auditor='" + auditor + '\'' +
                ", teacher_fam='" + teacher_fam + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_otvo='" + teacher_otvo + '\'' +
                '}';
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getPair() {
        return pair;
    }

    public void setPair(int pair) {
        this.pair = pair;
    }

    public String getDiscip() {
        return discip;
    }

    public void setDiscip(String discip) {
        this.discip = discip;
    }

    public String getOccup() {
        return occup;
    }

    public void setOccup(String occup) {
        this.occup = occup;
    }

    public String getPrim() {
        return prim;
    }

    public void setPrim(String prim) {
        this.prim = prim;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getTeacher_fam() {
        return teacher_fam;
    }

    public void setTeacher_fam(String teacher_fam) {
        this.teacher_fam = teacher_fam;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_otvo() {
        return teacher_otvo;
    }

    public void setTeacher_otvo(String teacher_otvo) {
        this.teacher_otvo = teacher_otvo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
