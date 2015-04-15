package ro.stefan.controller;

import com.mongodb.DB;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.stefan.DAO.GenericCollectionDAO;

import java.io.IOException;
import java.util.*;

@Controller
public class AdminController {

    @Autowired
    DB dataBase;

    @Autowired
    GenericCollectionDAO genericCollectionDAO;

    //Spring Security see this :
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("msg", "Invalid username and password!");
            model.addObject("error",true);
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
            model.addObject("error",false);
        }
        model.setViewName("admin/login");

        return model;

    }
//TODO gasit cum sa sortez alfabetic lista de colectii
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) throws IOException {

        List<String> collectionsNames = new ArrayList<String>(dataBase.getCollectionNames());
        collectionsNames.remove("system.indexes");

        model.addAttribute("collectionNames", JSON.serialize(collectionsNames));

        return "admin/main";
    }

    @RequestMapping(value = "/main/{collectionName}", method = RequestMethod.GET)
    public @ResponseBody String mainAjaxDataTable(@PathVariable String collectionName) throws IOException {
        String response ;
        response = "[" + genericCollectionDAO.getAllJson(collectionName) + "," + genericCollectionDAO.getAllKeysJson(collectionName) + "]";
        return response;
    }

}
