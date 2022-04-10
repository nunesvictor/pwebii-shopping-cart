package br.edu.ifto.pwebii.aula06.controller;

import br.edu.ifto.pwebii.aula06.model.PessoaJuridica;
import br.edu.ifto.pwebii.aula06.model.repository.PessoaJuridicaRepository;
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
@RequestMapping("pessoas-juridicas")
public class PessoaJuridicaController {
    final PessoaJuridicaRepository repository;

    public PessoaJuridicaController(PessoaJuridicaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/form")
    public String form(PessoaJuridica pessoaJuridica) {
        return "/pessoas-juridicas/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("pessoasJuridicas", repository.pessoasJuridicas());
        return new ModelAndView("/pessoas-juridicas/list", model);
    }

    @PostMapping("/create")
    public ModelAndView create(PessoaJuridica pessoaJuridica) {
        repository.save(pessoaJuridica);
        return new ModelAndView("redirect:/pessoas-juridicas/list");
    }

    @GetMapping("/recover/{id}")
    public ModelAndView recover(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("pessoaJuridica", repository.pessoaJuridica(id));
        return new ModelAndView("/pessoas-juridicas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(PessoaJuridica pessoaJuridica) {
        repository.update(pessoaJuridica);
        return new ModelAndView("redirect:/pessoas-juridicas/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/pessoas-juridicas/list");
    }
}
