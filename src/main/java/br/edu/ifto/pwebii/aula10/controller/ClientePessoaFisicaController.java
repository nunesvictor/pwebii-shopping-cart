package br.edu.ifto.pwebii.aula10.controller;

import br.edu.ifto.pwebii.aula10.model.entity.ClientePessoaFisica;
import br.edu.ifto.pwebii.aula10.model.repository.ClientePessoaFisicaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/clientespf")
public class ClientePessoaFisicaController {
    private final ClientePessoaFisicaRepository repository;

    public ClientePessoaFisicaController(ClientePessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/form")
    public String form(ClientePessoaFisica clientePessoaFisica) {
        return "/clientespf/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("clientes", repository.findAll());
        return new ModelAndView("/clientespf/list", model);
    }

    @PostMapping("/create")
    public ModelAndView create(ClientePessoaFisica clientePessoaFisica) {
        repository.save(clientePessoaFisica);
        return new ModelAndView("redirect:/clientespf/list");
    }

    @GetMapping("/recover/{id}")
    public ModelAndView recover(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("clientePessoaFisica", repository.getById(id));
        return new ModelAndView("/clientespf/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(ClientePessoaFisica clientePessoaFisica) {
        repository.save(clientePessoaFisica);
        return new ModelAndView("redirect:/clientespf/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/clientespf/list");
    }
}
