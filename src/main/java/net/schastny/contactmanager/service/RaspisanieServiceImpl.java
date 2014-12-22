package net.schastny.contactmanager.service;

import net.schastny.contactmanager.dao.RaspisanieDAO;
import net.schastny.contactmanager.domain.Raspisanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by adm on 17.12.2014.
 */
@Service
public class RaspisanieServiceImpl implements RaspisanieService {
    @Autowired
    RaspisanieDAO raspisanieDAO;

    @Transactional
    @Override
    public List<Raspisanie> getRaspToday(String grp) {
        return raspisanieDAO.getRaspToday(grp);
    }
    @Transactional
    @Override
    public List<Raspisanie> getRaspCurrentWeek(String grp) {
        return raspisanieDAO.getRaspCurrentWeek(grp);
    }
    @Transactional
    @Override
    public List<Raspisanie> getRaspCurrentMonth(String grp) {
        return raspisanieDAO.getRaspCurrentMonth(grp);
    }

    @Transactional
    @Override
    public List<Raspisanie> getRaspTomorrow(String grp) {
        return raspisanieDAO.getRaspTomorrow(grp);
    }

    @Transactional
    @Override
    public List<Raspisanie> getRaspCustom(String start, String end, String grp) {
        return raspisanieDAO.getRaspCustom(start, end, grp);
    }
}
