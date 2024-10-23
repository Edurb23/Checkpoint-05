package com.fiap.checkpoint.controller;


import com.fiap.checkpoint.model.Album;
import com.fiap.checkpoint.model.Artist;
import com.fiap.checkpoint.model.GenMusic;
import com.fiap.checkpoint.repository.ArtistRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("artist")
public class ArtistController {

     @Autowired
     private ArtistRepository repository;


    @GetMapping("cadastrar")
    public String cadastrar(Artist artist, Model model){
        return "artist/cadastro";
    }

    @GetMapping("confirmado")
    public String confirmado(Artist artist){
        return "artist/confirmado";
    }




    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Artist artist, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "artist/cadastro";
        }
        repository.save(artist);
        redirectAttributes.addAttribute("mensagem", "Album cadastrado!");
        return "redirect:/artist/confirmado";
    }




}
