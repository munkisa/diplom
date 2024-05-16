package com.example.diplom.controllers;

import com.example.diplom.entities.Currency;
import com.example.diplom.entities.DealEntity;
import com.example.diplom.services.DealService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class MainController {
    DealService dealService;

    @GetMapping("/")
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
        return "deal";
    }

/*    @PostMapping("/deal")
    public String postAdd(@RequestParam Currency sellCurrency,
                          @RequestParam Currency buyCurrency,
                          @RequestParam Double price,
                          @RequestParam Integer count,
                          Model model) {
        DealEntity deal = new DealEntity(sellCurrency, buyCurrency, price, count);
        dealService.saveDeal(deal);
        return "redirect:/main";
    }*/

}
