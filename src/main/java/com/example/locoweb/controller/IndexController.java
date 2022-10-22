package com.example.locoweb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.locoweb.entity.Richiesta;
import com.example.locoweb.repository.RichiestaRepository;
import com.example.locoweb.utils.AppConstants;

@Controller
public class IndexController {

    @Autowired
    private RichiestaRepository rRepo;

    @Autowired
    UserDetailsService uService;

    @GetMapping({"/"})
    public ModelAndView getIndex(/* @RequestParam Optional<Boolean> success */) {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/loginProcessing")
    public String loginProcessing(
        @RequestParam String username,
        @RequestParam String password
    ) {
        UserDetails user = uService.loadUserByUsername("admin");
        if(user.getPassword().equals(AppConstants.ADMIN_PW)) {
            return "redirect:/admin/list";
        } else {
            return "redirect:/login?error=";
        }
    }

    @GetMapping("/addRichiestaForm")
    public ModelAndView addRichiestaForm(@RequestParam Optional<Boolean> success) {
        ModelAndView mav = new ModelAndView("add-richiesta-form");

        mav.addObject("richiesta", new Richiesta());
        if(success.isPresent()) {
            if(success.get()) {
                mav.addObject("success", true);
            } else {
                mav.addObject("success", false);
            }
        }

        return mav;
    }

    @PostMapping("/saveRichiesta")
    public String saveRichiesta(@ModelAttribute Richiesta richiesta) {
        try {
            rRepo.save(richiesta);
            if(Richiesta.getDeletedIds().size() > 0) {
                Richiesta.getDeletedIds().remove(0);
            }

            return "redirect:/addRichiestaForm?success=true";
        } catch(IllegalArgumentException e) {
            return "redirect:/addRichiestaForm?success=false";
        }
    }
}

