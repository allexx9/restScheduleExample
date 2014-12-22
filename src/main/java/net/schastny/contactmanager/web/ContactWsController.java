package net.schastny.contactmanager.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.schastny.contactmanager.domain.Contact;
import net.schastny.contactmanager.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by aleksandrsutkov on 04.12.14.
 */
@Controller
@RequestMapping(value = "/ws", produces = MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8")
public class ContactWsController {
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/index")
    @ResponseBody
    public Map<String, Object> listContacts() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contactList", contactService.listContact());
        return map;
    }

    @RequestMapping(value = "/get/*")
    @ResponseBody
    public Map<String, Object> contact(@RequestParam("contactId") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contact", contactService.getContact(Integer.parseInt(id)));
        return map;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public Map<String, Object> addContactWs(@RequestBody String json) {

        Contact contact = null;
        try {
            contact = new ObjectMapper().readValue(json, Contact.class);
            contactService.addContact(contact);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", "всё хорошо"); // если с кодировкой будет что-то не так - сразу будет видно
            map.put("contact", contact);
            map.put("contactList", contactService.listContact());
            return map;
        } catch (IOException e) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("status", "ошибка");
            map.put("message", e.getMessage());
            return map;
        }
    }
}
