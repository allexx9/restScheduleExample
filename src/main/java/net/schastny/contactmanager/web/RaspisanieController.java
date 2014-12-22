package net.schastny.contactmanager.web;
import java.text.SimpleDateFormat;
import net.schastny.contactmanager.service.RaspisanieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by adm on 17.12.2014.
 */
@Controller
@RequestMapping(value = "/rasp", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
public class RaspisanieController {
    @Autowired
    private RaspisanieService raspisanieService;

    @RequestMapping(value = "/tomorrow/{grp}")
    @ResponseBody
    public Map<String, Object> tomorrow (@PathVariable String grp)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tomorrow", raspisanieService.getRaspTomorrow(grp));
        return map;
    }

    @RequestMapping(value = "/week/{grp}")
    @ResponseBody
    public Map<String, Object> week (@PathVariable String grp)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("week", raspisanieService.getRaspCurrentWeek(grp));
        return map;
    }

    @RequestMapping(value = "/month/{grp}")
    @ResponseBody
    public Map<String, Object> month (@PathVariable String grp)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month", raspisanieService.getRaspCurrentMonth(grp));
        return map;
    }

    @RequestMapping(value = "/custom/", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> custom (@RequestParam("start") String start, @RequestParam("end") String end, @RequestParam("grp") String grp)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month", raspisanieService.getRaspCustom(start,end,grp));
        return map;
    }

    @RequestMapping(value = "/today/{grp}")
    @ResponseBody
    public Map<String, Object> todayRasp(@PathVariable String grp) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("today", raspisanieService.getRaspToday(grp));
//        Calendar cal = new GregorianCalendar();
//        Date dateRepresentation = cal.getTime();
//
//        Integer dayDifference = cal.get(Calendar.DAY_OF_WEEK) == 1 ? -6 : (Calendar.MONDAY - cal.get(Calendar.DAY_OF_WEEK));
//        cal.add(Calendar.DAY_OF_MONTH, dayDifference);
//        String startWeek = date_format.format(cal.getTime());
//        cal.add(Calendar.DAY_OF_MONTH, -dayDifference);
//
//        int diff = (Calendar.SUNDAY - cal.get(Calendar.DAY_OF_WEEK))-1;
//        cal.add(Calendar.DAY_OF_MONTH, -diff);
//        String endWeek = date_format.format(cal.getTime());
//        cal.add(Calendar.DAY_OF_MONTH, diff);
//
//        String currentDay = date_format.format(cal.getTime());
//
//        map.put("startWeek", startWeek);
//        map.put("endWeek", endWeek);
//        map.put("currentDay", currentDay);
//        if (raspisanieService == null) {
//            map.put("today", null);
//        }
//        map.put("today", raspisanieService.getRaspToday(date_format.format(dateRepresentation), grp));

//
//        String dateFirstDayOfWeek = date_format.format(cal.getTime()); //Дата на начало текущей недели
//        cal.add(Calendar.DAY_OF_MONTH, -dayDifference);
//
//        String dateEndDayOfWeek = date_format.format(cal.getTime());
//        map.put("today", raspisanieService.getRaspToday(date_format.format(dateRepresentation), grp));
//        map.put("cal", dateFirstDayOfWeek);
//        map.put("today", date_format.format(dateRepresentation));
//        int DAY_OF_WEEK=cal.get(Calendar.DAY_OF_WEEK);
//        int dayOfEndWeek = Calendar.SUNDAY;
//        int diff = dayOfEndWeek - DAY_OF_WEEK;
//        map.put("diff", diff);
//        cal.add(Calendar.DAY_OF_MONTH, -diff+1);
//        map.put("dayofweek", date_format.format(cal.getTime()));
        return map;
    }
}
