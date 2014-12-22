package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Schedule;
import java.util.List;

public interface ScheduleDAO {

    public void addSchedule(Schedule schedule);

    public List<Schedule> listSchedule();

    public void removeSchedule(Integer id);

    public Schedule getSchedule(Integer id);
}
