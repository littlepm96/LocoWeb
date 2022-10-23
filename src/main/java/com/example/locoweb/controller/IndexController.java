package com.example.locoweb.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public ModelAndView getIndex() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if(session.getAttribute("user") != null) {
            if((Boolean) session.getAttribute("user") == true)
                return "redirect:/admin/list";
            else
                return "login";
        } else {
            return "login";
        }
    }

    @PostMapping("/loginProcessing")
    public boolean loginProcessing(@RequestParam String username, @RequestParam String password) {
        if(username.equals(AppConstants.ADMIN_USER) && password.equals(AppConstants.ADMIN_PW)) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/logout")
    public boolean logout() {
        return true;
    }

    @GetMapping("/addRichiestaForm")
    public ModelAndView addRichiestaForm(@RequestParam Optional<Boolean> success, HttpSession session) {
        ModelAndView mav = new ModelAndView("add-richiesta-form");

        mav.addObject("richiesta", new Richiesta());
        if(success.isPresent()) {
            if(success.get()) {
                mav.addObject("success", true);
            } else {
                mav.addObject("success", false);
            }
        }

        if(session.getAttribute("user") != null)
            if((Boolean) session.getAttribute("user") == true)
                mav.addObject("user", true);
            else {
                mav.addObject("user", false);
        } else {
            mav.addObject("user", false);
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

