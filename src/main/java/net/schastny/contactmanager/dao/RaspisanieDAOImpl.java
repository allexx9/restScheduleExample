package net.schastny.contactmanager.dao;

import net.schastny.contactmanager.domain.Raspisanie;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.util.resources.cldr.agq.CalendarData_agq_CM;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by adm on 16.12.2014.
 */
@Repository
public class RaspisanieDAOImpl implements RaspisanieDAO {
    private SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Raspisanie> getRaspToday(String grp) {
        return sessionFactory.getCurrentSession().createQuery("from Raspisanie where day = '" + getStringDateInterval("today")[0] + "' AND grp = '"+grp+"' ").list();
    }

    @Override
    public List<Raspisanie> getRaspCurrentWeek(String grp) {
        String dates[] = getStringDateInterval("week");
        return sessionFactory.getCurrentSession().createQuery("from Raspisanie where day between '"+dates[0]+"' and '"+dates[1]+"' and grp = '"+grp+"'").list();
    }

    @Override
    public List<Raspisanie> getRaspCurrentMonth(String grp) {
        String dates[] = getStringDateInterval("month");
        return sessionFactory.getCurrentSession().createQuery("from Raspisanie where day between '" + dates[0] + "' and '" + dates[1] + "' and grp = '" + grp + "'").list();
    }


    @Override
    public List<Raspisanie> getRaspTomorrow(String grp) {
        return sessionFactory.getCurrentSession().createQuery("from Raspisanie where day ='"+getStringDateInterval("tomorrow")[0]+"' ").list();
    }

    @Override
    public List<Raspisanie> getRaspCustom(String start, String end, String grp) {
        return sessionFactory.getCurrentSession().createQuery("from Raspisanie where day between '"+start+"' and '"+end+"' and grp = '"+grp+"'").list();
    }

    private String[] getStringDateInterval(String parametr){
        Calendar cal = new GregorianCalendar();
        String[] dates = new String[2];
        if (parametr.equalsIgnoreCase("today")){
            dates[0] = date_format.format(cal.getTime());
        }
        else if (parametr.equalsIgnoreCase("tomorrow")){
            cal.add(Calendar.DAY_OF_MONTH, 1);
            dates[0] = date_format.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        else if (parametr.equalsIgnoreCase("week")){
            Integer dayDifference = cal.get(Calendar.DAY_OF_WEEK) == 1 ? -6 : (Calendar.MONDAY - cal.get(Calendar.DAY_OF_WEEK));
            cal.add(Calendar.DAY_OF_MONTH, dayDifference);
            dates[0] = date_format.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, -dayDifference);

            int diff = (Calendar.SUNDAY - cal.get(Calendar.DAY_OF_WEEK))-1;
            cal.add(Calendar.DAY_OF_MONTH, -diff);
            dates[1] = date_format.format(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, diff);
        }
        else if (parametr.equalsIgnoreCase("month")){
            Calendar clonedCal = (Calendar)cal.clone();
            int firstDayMonth = Calendar.getInstance().getActualMinimum(Calendar.DAY_OF_MONTH);
            int lastDayMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
            clonedCal.set(Calendar.DAY_OF_MONTH, firstDayMonth);
            dates[0] = date_format.format(clonedCal.getTime());
            clonedCal.set(Calendar.DAY_OF_MONTH, lastDayMonth);
            dates[1] = date_format.format(clonedCal.getTime());
        }
        return dates;
    }
}
