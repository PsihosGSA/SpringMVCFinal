package ua.org.oa.gavrishs.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.gavrishs.DTO.UserForList;
import ua.org.oa.gavrishs.exceptions.AppException;
import ua.org.oa.gavrishs.model.Role;
import ua.org.oa.gavrishs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import ua.org.oa.gavrishs.security.UserAuthentication;
import ua.org.oa.gavrishs.services.UserService;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

/**
 * Created by Oleg on 15.02.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /*@RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUserList(ModelMap model){

        model.put("usersList", userService.getAll());

        return "userList";
    }*/

    /*@RequestMapping(path = "/add*", method = RequestMethod.GET)
    public String getUserAddForm(ModelMap model){
        return "redirect:/users";
    }

    @RequestMapping(path = "/add*", method = RequestMethod.POST)
    public String submitUserAddForm(ModelMap model){
        return "redirect:/users";
    }



    @RequestMapping(path = "/edit/{userId}", method = RequestMethod.POST)
    public String getUserEditSubmit(ModelMap model, @PathVariable long userId){

        System.out.println(userId);
        return "redirect:/users";
    }

    @RequestMapping(path = "/delete/{userId}", method = RequestMethod.GET)
    public String getUserDelete(ModelMap model, @PathVariable long userId){
        System.out.println(userId);
        return "redirect:/users";
    }*/

/*
    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public ResponseEntity<?> getAllUsersJSON(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(auth.getName());
        try {
            return new ResponseEntity<>(userService.getAll(), OK);
        } catch (AppException e){

            // TODO: добавить логгирование
            e.printStackTrace();

            return new ResponseEntity<>(e.getLocalizedMessage(), INTERNAL_SERVER_ERROR);
        }
    }
*/
    @RequestMapping(path = "/users/{friendId}", method = RequestMethod.GET)
    public String getUserEditForm(ModelMap model, @PathVariable String friendId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(auth.getName());
        userService.addFriends(user.getId(), Integer.parseInt(friendId));
        return "redirect:/users";
}

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPageController(ModelMap model) throws JsonProcessingException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(auth.getName());
        ObjectMapper mapper = new ObjectMapper();

        List<UserForList> friends = userService.getFriends(user);
        String initialFriendsList = mapper.writeValueAsString(friends);

        model.addAttribute("userFistName", user.getFirstName());
        model.addAttribute("userLastName", user.getLastName());
        model.put("initialFriendsList", initialFriendsList);
        return "userPage";
    }

    @ResponseBody
    @RequestMapping(value = "/userPage", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<UserForList> getPageFriendsJSON() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<UserForList> friends = userService.getFriends(userService.getByLogin(auth.getName()));
        System.out.println(friends);


        return friends;
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String gotoRegisterUser(ModelMap model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam("login") String login, @RequestParam("password") String password,
                               @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                               @RequestParam("email") String email, @RequestParam("birthday") String birthday,
                               @RequestParam("passwordRepeat") String password2, ModelMap model){
        User user = new User();

        if (userService.getByLogin(login)== null) {
            user.setLogin(login);
        } else {
            model.addAttribute("errorLogin", true);
            return "register";
        }

        if (password.equals(password2)){
            user.setPassword(password);
        } else {
            model.addAttribute("errorPassword", true);
            return "register";
        }

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setDate(birthday);
        user.setRole(Role.ROLE_USER);
        userService.create(user);

        model.addAttribute("registerComplited", true);
        return "login";
    }



    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getPageUsers(ModelMap model) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(auth.getName());
        String users = mapper.writeValueAsString(userService.getAll(user));
        model.put("initialUsersList", users);
        return "users";
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<UserForList> getPageUsersJSON() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getByLogin(auth.getName());
        return userService.getAll(user);
    }

}