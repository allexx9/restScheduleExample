package net.schastny.contactmanager.service;

import net.schastny.contactmanager.domain.Schedule;

import java.util.List;

public interface ScheduleService {
    public void addSchedule(Schedule schedule);

    public List<Schedule> listSchedule();

    public void removeSchedule(Integer id);

    public Schedule getSchedule(Integer id);
}
