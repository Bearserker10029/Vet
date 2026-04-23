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
    public String listaMascotas(Model model) {
        model.addAttribute("listaMascotas", mascotaRepository.findAll());
        return "ListaMascota";
    }

    @PostMapping("/BuscarMascotasNombre")
    public String buscarmascota(@RequestParam("searchField") String searchField,
                                Model model) {

        List<Mascota> listaMascotas = mascotaRepository.buscarNombreMascota(searchField);
        model.addAttribute("mascotaList", listaMascotas);
        model.addAttribute("textoBuscado", searchField);

        return "ListaMascota";
    }

    @PostMapping("/BuscarMascotasEspecie")
    public String buscarmascotaEspecie(@RequestParam("searchField") String searchField,
                                       Model model) {

        List<Mascota> listaMascotas = mascotaRepository.buscarEspecieMascota(searchField);
        model.addAttribute("mascotaList", listaMascotas);
        model.addAttribute("textoBuscado", searchField);

        return "ListaMascota";
    }
    @PostMapping("/BuscarMascotasEstado")
    public String buscarmascotaEstado(@RequestParam("searchField") String searchField,
                                      Model model) {

        List<Mascota> listaMascotas = mascotaRepository.buscarEstadoMascota(searchField);
        model.addAttribute("mascotaList", listaMascotas);
        model.addAttribute("textoBuscado", searchField);

        return "ListaMascota";
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
