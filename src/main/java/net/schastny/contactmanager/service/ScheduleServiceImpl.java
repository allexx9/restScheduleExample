package net.schastny.contactmanager.service;

import net.schastny.contactmanager.dao.ScheduleDAO;

import net.schastny.contactmanager.domain.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by aleksandrsutkov on 05.12.14.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleDAO scheduleDAO;

    @Transactional
    @Override
    public void addSchedule(Schedule schedule) {
        scheduleDAO.addSchedule(schedule);
    }

    @Transactional
    @Override
    public List<Schedule> listSchedule() {
        return scheduleDAO.listSchedule();
    }

    @Transactional
    @Override
    public void removeSchedule(Integer id) {
        scheduleDAO.removeSchedule(id);
    }

    @Transactional
    @Override
    public Schedule getSchedule(Integer id) {
        return scheduleDAO.getSchedule(id);
    }
}
