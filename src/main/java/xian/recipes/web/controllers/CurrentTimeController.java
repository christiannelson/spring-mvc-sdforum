package xian.recipes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class CurrentTimeController
{
    @RequestMapping(value = "/current-time")
    public String currentTime(Model model)
    {
        model.addAttribute("currentTime", new Date());
        return "current-time";
    }
}
