package com.fiap.checkpoint.controller;

import com.fiap.checkpoint.model.Album;
import com.fiap.checkpoint.model.Artist;
import com.fiap.checkpoint.model.Cover;
import com.fiap.checkpoint.model.GenMusic;
import com.fiap.checkpoint.repository.AlbumRepository;
import com.fiap.checkpoint.repository.ArtistRepository;
import com.fiap.checkpoint.repository.CoverRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Controller
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private AlbumRepository repository;

    @Autowired
    private ArtistRepository artistRepository;


    @Autowired
    private CoverRepository coverRepository;

    @GetMapping("cadastrar")
    public String cadastrar(Album album, Model model){
        model.addAttribute("genMusic", GenMusic.values());
        model.addAttribute("artist", artistRepository.findAll());
        return "album/cadastro";
    }


    @GetMapping("listar")
    public String listaAlbum(Model model, @RequestParam(value = "page", defaultValue = "0") int page){
        Pageable pageable = PageRequest.of(page, 8);
        Page<Album> albunsPage = repository.findAll(pageable);
        model.addAttribute("albunsPage", albunsPage);
        return "album/listar";
    }

   /* @GetMapping("pesquisar")
    public String pesquisarAlbuns(@RequestParam(value = "artist", required = false) String artist, Model model) {
        if (artist != null && !artist.isEmpty()) {
            List<Album> albuns = repository.findByArtist(artist);
            if (albuns.isEmpty()) {
                model.addAttribute("mensagem", "Não existe álbum desse artista.");
            } else {
                model.addAttribute("albuns", albuns);
            }
        }
        return "album/pesquisar";
    }*/

    @GetMapping("editar/{id}")
    public String editar(@PathVariable("id") Long id, Model model) {
        Album album = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Álbum inválido: " + id));
        model.addAttribute("album", album);
        model.addAttribute("genMusic", GenMusic.values());
        model.addAttribute("artists", artistRepository.findAll());
        return "album/editar";
    }


    @PostMapping("cadastrar")
    @Transactional
    public String cadastrar(@Valid Album album, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("genMusic", GenMusic.values());
            return "album/cadastro";
        }
        repository.save(album);
        redirectAttributes.addAttribute("mensagem", "Album cadastrado!");
        return "redirect:/album/listar";
    }


    @PostMapping("editar")
    @Transactional
    public String editar(@Valid Album album, BindingResult result, RedirectAttributes redirectAttributes, Model model){
        if (result.hasErrors()) {
            model.addAttribute("genMusic", GenMusic.values());
            model.addAttribute("artists", artistRepository.findAll());
            return "album/editar";
        }
        repository.save(album);  // Atualiza o álbum no banco
        redirectAttributes.addFlashAttribute("mensagem", "Álbum atualizado");
        return "redirect:/album/listar";
    }



    @PostMapping("remover")
    @Transactional
    public String remover(Long id, RedirectAttributes redirectAttributes) {
        repository.deleteById(id);
        redirectAttributes.addFlashAttribute("mensagem", "Album removido");
        return "redirect:/album/listar";
    }






}
