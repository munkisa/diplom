package com.example.diplom.controllers;

import com.example.diplom.entities.Currency;
import com.example.diplom.entities.DealEntity;
import com.example.diplom.services.DealService;
import com.example.diplom.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {
    UserService userService;
    DealService dealService;

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("deals", dealService.getDeals());
        return "main";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/deal")
    public String deal(Model model) {
        model.addAttribute("deal", new DealEntity());
        return "deal";
    }

    @PostMapping("/deal")
    public String postAdd(@ModelAttribute("deal") DealEntity deal, Model model) {
        deal.setOwner(userService.getCurrentUser());
        dealService.saveDeal(deal);
        return "redirect:/main";
    }

}
