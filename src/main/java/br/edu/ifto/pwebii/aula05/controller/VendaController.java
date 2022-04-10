package br.edu.ifto.pwebii.aula05.controller;

import br.edu.ifto.pwebii.aula05.model.entity.Venda;
import br.edu.ifto.pwebii.aula05.model.repository.VendaRepository;
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
@RequestMapping("vendas")
public class VendaController {
    final VendaRepository repository;

    public VendaController(VendaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/form")
    public String form(Venda venda) {
        return "/vendas/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("vendas", repository.vendas());
        return new ModelAndView("/vendas/list", model);
    }

    @PostMapping("/create")
    public ModelAndView create(Venda venda) {
        repository.save(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/recover/{id}")
    public ModelAndView recover(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", repository.venda(id));
        return new ModelAndView("/vendas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        repository.update(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        repository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }
}
