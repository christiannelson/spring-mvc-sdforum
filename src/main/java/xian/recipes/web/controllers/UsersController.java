package xian.recipes.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xian.recipes.model.User;
import xian.recipes.model.UserValidator;

import javax.validation.Valid;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.lang.String.format;

@Controller
@RequestMapping("/users")
public class UsersController
{
    private Map<Long, User> users = new ConcurrentHashMap<Long, User>();

    @InitBinder
    public void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new UserValidator());
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String show(@PathVariable Long id, Model model)
    {
        model.addAttribute("user", users.get(id));
        return "users/show";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String newInstance(Model model)
    {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid User user, BindingResult result)
    {
        if (result.hasErrors()) return "users/new";

        user.assignId();
        users.put(user.getId(), user);
        return format("redirect:/users/%s", user.getId());
    }
}