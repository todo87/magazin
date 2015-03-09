package ro.stefan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin/login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.POST)
    public String mail(@RequestParam("user") String user,
                       @RequestParam("pwd") String pwd,
                       Model model) {

        model.addAttribute("user","asd");
        model.addAttribute("pwd","asdaa");
        return "admin/main";
    }
}
