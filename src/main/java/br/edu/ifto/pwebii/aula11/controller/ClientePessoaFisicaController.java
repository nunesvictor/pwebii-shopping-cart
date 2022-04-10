package br.edu.ifto.pwebii.aula11.controller;

import br.edu.ifto.pwebii.aula11.model.entity.ClientePessoaFisica;
import br.edu.ifto.pwebii.aula11.model.repository.ClientePessoaFisicaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/clientespf")
public class ClientePessoaFisicaController {
    private final ClientePessoaFisicaRepository repository;

    public ClientePessoaFisicaController(ClientePessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/form")
    public ModelAndView form(ClientePessoaFisica clientePessoaFisica) {
        return new ModelAndView("/clientespf/form");
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("clientes", repository.findAll());
        return new ModelAndView("/clientespf/list", model);
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid ClientePessoaFisica clientePessoaFisica, BindingResult result) {
        if (result.hasErrors()) {
            return form(clientePessoaFisica);
        }

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
