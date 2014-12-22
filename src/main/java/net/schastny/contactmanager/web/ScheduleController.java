package net.schastny.contactmanager.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.domain.Schedule;
import net.schastny.contactmanager.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aleksandrsutkov on 05.12.14.
 */
@Controller
@RequestMapping(value = "/schedule", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String, Object> listSchedule() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listSchedule", scheduleService.listSchedule());
        return map;
    }

    @RequestMapping(value = "/get/{id}")
    @ResponseBody
    public Map<String, Object> contact(@PathVariable int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("schedule", scheduleService.getSchedule(id));
        return map;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public Map<String, Object> addContactWs(@RequestBody String json) {

        Schedule schedule = null;
        try {
            schedule = new ObjectMapper().readValue(json, Schedule.class);
            scheduleService.addSchedule(schedule);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", "всё хорошо"); // если с кодировкой будет что-то не так - сразу будет видно
            map.put("schedule", schedule);
            map.put("scheduleList", scheduleService.listSchedule());
            return map;
        } catch (IOException e) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", "ошибка");
            map.put("message", e.getMessage());
            return map;
        }
    }
}
