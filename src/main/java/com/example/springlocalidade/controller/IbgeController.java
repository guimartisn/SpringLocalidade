package com.example.springlocalidade.controller;

import com.example.springlocalidade.model.Cidade;
import com.example.springlocalidade.model.Estado;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springlocalidade.service.IbgeService;

import java.util.List;
@Controller
public class IbgeController {

    private final IbgeService ibgeService;

    public IbgeController(IbgeService ibgeService) {
        this.ibgeService = ibgeService;
    }

    @GetMapping("/index")
    public String mostrarIndex() {
        return "index";
    }

    @GetMapping("/formulario")
    public String mostrarFormulario(Model model) {
        List<Estado> estados = ibgeService.listarEstados();
        model.addAttribute("estados", estados);
        return "formulario";
    }

    @PostMapping("/cidades")
    public String listarCidadesPorEstado(@RequestParam String estadoId, Model model) {
        List<Cidade> cidades = ibgeService.listarCidadesPorEstado(estadoId);
        model.addAttribute("cidades", cidades);
        return "resultado";
    }
}

