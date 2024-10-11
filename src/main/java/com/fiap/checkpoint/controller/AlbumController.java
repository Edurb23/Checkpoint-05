package com.fiap.checkpoint.controller;

import com.fiap.checkpoint.model.Album;
import com.fiap.checkpoint.model.GenMusic;
import com.fiap.checkpoint.repository.AlbumRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumRepository repository;

    @GetMapping("cadastrar")
    public String cadastrar(Album album, Model model){
        model.addAttribute("genMusic", GenMusic.values());
        return "album/cadastro";
    }

    @GetMapping("listar")
    public String listaAlbum(Model model){
        model.addAttribute("album", repository.findAll());
        return "album/listar";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@Valid Album album, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("genMusic", GenMusic.values());
            return "album/cadastro";
        }
        repository.save(album);
        redirectAttributes.addAttribute("mensagem", "Album cadastrado!");
        return "redirect:/album/cadastrar";
    }




}
