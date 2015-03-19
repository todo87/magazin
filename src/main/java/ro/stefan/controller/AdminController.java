package ro.stefan.controller;

import com.mongodb.DB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {
        dataBase.getCollectionNames().toArray();
        return "admin/main";
    }

}
