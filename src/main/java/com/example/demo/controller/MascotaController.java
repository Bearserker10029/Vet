package com.example.demo.controller;

import com.example.demo.model.Mascota;
import com.example.demo.repository.MascotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    final MascotaRepository mascotaRepository;
    public MascotaController(MascotaRepository mascotaRepository){
        this.mascotaRepository = mascotaRepository;
    }

    @GetMapping(value = {"", "/lista"})
    public String listaMascotas(
            @RequestParam(name = "searchField", required = false) String searchField,
            @RequestParam(name = "tipoFiltro", required = false) String tipoFiltro,
            Model model) {

        List<Mascota> listaMascotas;

        if (searchField != null && !searchField.isEmpty()) {
            switch (tipoFiltro) {
                case "especie" -> listaMascotas = mascotaRepository.buscarEspecieMascota(searchField);
                case "estado" -> listaMascotas = mascotaRepository.buscarEstadoMascota(searchField);
                default -> listaMascotas = mascotaRepository.buscarNombreMascota(searchField);
            }
            model.addAttribute("textoBuscado", searchField);
            model.addAttribute("tipoFiltro", tipoFiltro);
        } else {
            listaMascotas = mascotaRepository.findAll();
        }
        model.addAttribute("listaMascotas", listaMascotas);
        return "ListaMascota";
    }

    @GetMapping("/new")
    public String nuevoMascotaFrm(Model model) {
        model.addAttribute("mascota", new Mascota());
        return "RegistroMascota";
    }

    @PostMapping("/save")
    public String guardarProducto(Mascota mascota, RedirectAttributes attr) {
        mascotaRepository.save(mascota);
        return "redirect:/mascota/lista";
    }

    @GetMapping("/new")
    public String nuevoMascotaFrm(Model model) {
        return "product/newFrm";
    }

    @PostMapping("/save")
    public String guardarProducto(Mascota mascota, RedirectAttributes attr) {
        mascotaRepository.save(mascota);
        return "redirect:/product";
    }

}
