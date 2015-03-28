package ro.stefan.controller;

import com.mongodb.DB;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.*;

@Controller
public class AdminController {

    @Autowired
    DB dataBase;

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
        ObjectMapper objectMapper = new ObjectMapper();

        List<String> collectionsNames = new ArrayList<String>(dataBase.getCollectionNames());
        collectionsNames.remove("system.indexes");

        model.addAttribute("collectionNames",objectMapper.writeValueAsString(collectionsNames));

        return "admin/main";
    }

}
