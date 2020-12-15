package com.example.tutorial.controller;

import java.util.Optional;

import com.example.tutorial.model.dao.UserRepository;
import com.example.tutorial.model.entity.User;
import com.example.tutorial.model.session.LoginSession;
import com.example.tutorial.service.DestinationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tutorial/destination")
public class DestinationContrller {

  @Autowired
  LoginSession loginSession;

  @Autowired
  DestinationService destinationService;

  @Autowired
  UserRepository userRepos;

  @GetMapping("/")
  public String goDestinationRegisterPage(Model model) {
    Optional<User> user = userRepos.findById(loginSession.getUserId());
    model.addAttribute("user", user);
    model.addAttribute("loginSession", loginSession);
    return "destination";
  }
}