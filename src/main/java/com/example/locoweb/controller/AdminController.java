package com.example.locoweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.locoweb.entity.Richiesta;
import com.example.locoweb.repository.RichiestaRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RichiestaRepository rRepo;

    @GetMapping("/list")
    public ModelAndView getAllRichieste() {
        ModelAndView mav = new ModelAndView("list-richieste");
        mav.addObject("richiesta", rRepo.findAll());
        return mav;
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long richiestaId) {
        ModelAndView mav = new ModelAndView("add-richiesta-form");
        Richiesta richiesta = rRepo.findById(richiestaId).get();
        mav.addObject("richiesta", richiesta);
        return mav;
    }

    @GetMapping("/deleteRichiesta")
    public String deleteRichiesta(@RequestParam Long richiestaId) {
        rRepo.deleteById(richiestaId);
        Richiesta.getDeletedIds().add(richiestaId);

        return "redirect:/admin/list";
    }
}
