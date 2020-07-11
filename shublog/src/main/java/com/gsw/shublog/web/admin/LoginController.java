package com.gsw.shublog.web.admin;

import com.gsw.shublog.po.User;
import com.gsw.shublog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password
    , HttpSession session, RedirectAttributes attributes){

        User user = userService.checkUser(username, password);
        if (user != null) {
            //用户名和密码是正确的，传递用户信息到前端页面，通过session,把密码变成null,防止密码传到前端页面
            user.setPassword(null);
            session.setAttribute("user",user);
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "Username or password is wrong.");
            return "redirect:/admin";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }


}
