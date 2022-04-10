package br.edu.ifto.pwebii.aula06.controller;

import br.edu.ifto.pwebii.aula06.model.PessoaFisica;
import br.edu.ifto.pwebii.aula06.model.repository.PessoaFisicaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;

@Transactional
@Controller
@RequestMapping("pessoas-fisicas")
public class PessoaFisicaController {
    final PessoaFisicaRepository repository;

    public PessoaFisicaController(PessoaFisicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/form")
    public String form(PessoaFisica pessoaFisica) {
        return "/pessoas-fisicas/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("pessoasFisicas", repository.pessoasFisicas());
        return new ModelAndView("/pessoas-fisicas/list", model);
    }

    @PostMapping("/create")
    public ModelAndView create(PessoaFisica pessoaFisica) {
        repository.save(pessoaFisica);
        return new ModelAndView("redirect:/pessoas-fisicas/list");
    }

    @GetMapping("/recover/{id}")
    public ModelAndView recover(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaFisica", repository.pessoaFisica(id));
        return new ModelAndView("/pessoas-fisicas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaFisica pessoaFisica) {
        repository.update(pessoaFisica);
        return new ModelAndView("redirect:/pessoas-fisicas/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pessoas-fisicas/list");
    }
}
