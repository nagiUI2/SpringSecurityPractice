package com.example.ui2_demo.controller;

import com.example.ui2_demo.entity.Board;
import com.example.ui2_demo.entity.User;
import com.example.ui2_demo.form.LoginForm;
import com.example.ui2_demo.form.UserForm;
import com.example.ui2_demo.security.CustomUserDetails;
import com.example.ui2_demo.service.BoardService;
import com.example.ui2_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String indexPage(Model model){
        return "index";
    }

    @GetMapping("login")
    public String login(Model model){ return "loginUser"; }


    @GetMapping("joinUs")
    public String regist(Model model){ return "registUser"; }

    @GetMapping("board")
    public String board(Model model){
        List<Board> boardList = boardService.findAll();

        model.addAttribute("boardList", boardList);
        return "boardlist";
    }

    @PostMapping("doLogin")
    public String login(@Validated @ModelAttribute LoginForm loginForm ,
                        BindingResult bindingResult,
                        Model model){
        if(bindingResult.hasErrors()){
            return "loginUser";
        }else {
            model.addAttribute("form", loginForm);
            return "index";
        }
    }

    @PostMapping("regist")
    public String regist(@Validated @ModelAttribute UserForm userForm ,
                         BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "registUser";
        }else {
            if(userForm.getUserPassword().equals(userForm.getUserPasswordCheck())){
                userService.save(userForm);
                return "loginUser";
            }else {
                return "registUser";
            }
        }
    }

}
