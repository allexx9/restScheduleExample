package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Schedule;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class ScheduleDAOImpl implements ScheduleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSchedule(Schedule schedule) {
        sessionFactory.getCurrentSession().save(schedule);
    }

    @Override
    public List<Schedule> listSchedule() {
        return sessionFactory.getCurrentSession().createQuery("from Schedule ")
                .list();
    }

    @Override
    public void removeSchedule(Integer id) {
        Schedule schedule = (Schedule) sessionFactory.getCurrentSession().load(
                Schedule.class, id);
        if (null != schedule) {
            sessionFactory.getCurrentSession().delete(schedule);
        }
    }

    @Override
    public Schedule getSchedule(Integer id) {
        return (Schedule)sessionFactory.getCurrentSession().load(Schedule.class, id);
    }
}
