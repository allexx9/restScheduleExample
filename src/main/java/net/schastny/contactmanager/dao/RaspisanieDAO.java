package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Raspisanie;

import java.util.Date;
import java.util.List;

/**
 * Created by adm on 16.12.2014.
 */
public interface RaspisanieDAO {
    public List<Raspisanie> getRaspToday(String grp);
    public List<Raspisanie> getRaspCurrentWeek(String grp);
    public List<Raspisanie> getRaspCurrentMonth(String grp);
    public List<Raspisanie> getRaspTomorrow(String grp);
    public List<Raspisanie> getRaspCustom(String start, String end, String grp);
}
