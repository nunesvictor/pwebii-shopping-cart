package br.edu.ifto.pwebii.aula10.controller;

import br.edu.ifto.pwebii.aula10.model.entity.Cliente;
import br.edu.ifto.pwebii.aula10.model.entity.ItemVenda;
import br.edu.ifto.pwebii.aula10.model.entity.Produto;
import br.edu.ifto.pwebii.aula10.model.entity.Venda;
import br.edu.ifto.pwebii.aula10.model.repository.ClientePessoaFisicaRepository;
import br.edu.ifto.pwebii.aula10.model.repository.ProdutoRepository;
import br.edu.ifto.pwebii.aula10.model.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Date;

@Scope("request")
@Transactional
@Controller
@RequestMapping("vendas")
public class VendaController {
    private final ClientePessoaFisicaRepository clientePessoaFisicaRepository;
    private final ProdutoRepository produtoRepository;
    private final VendaRepository vendaRepository;

    public VendaController(
            ClientePessoaFisicaRepository clientePessoaFisicaRepository,
            ProdutoRepository produtoRepository,
            VendaRepository vendaRepository) {

        this.clientePessoaFisicaRepository = clientePessoaFisicaRepository;
        this.produtoRepository = produtoRepository;
        this.vendaRepository = vendaRepository;
    }

    @Autowired
    Venda venda;

    @GetMapping("/form")
    public String form(ItemVenda item, ModelMap model) {
        model.addAttribute("produtos", produtoRepository.produtos());
        model.addAttribute("clientes", clientePessoaFisicaRepository.findAll());

        return "/vendas/form";
    }

    @GetMapping("/list")
    public ModelAndView list(ModelMap model) {
        model.addAttribute("vendas", vendaRepository.vendas());
        return new ModelAndView("/vendas/list", model);
    }

    @PostMapping("/add")
    public ModelAndView addItem(ItemVenda item) {
        Produto p = produtoRepository.produto(item.getProduto().getId());
        item.setProduto(p);
        item.setVenda(venda);
        venda.getItens().add(item);
        return new ModelAndView("redirect:/vendas/form");
    }

    @PostMapping("/create")
    public ModelAndView create(Venda venda) {
        System.out.println("=========>>>>>" + venda.getCliente().getId());
        Cliente c = clientePessoaFisicaRepository.getById(venda.getCliente().getId());

        this.venda.setId(null);
        this.venda.setCliente(c);
        this.venda.setData(new Date());

        vendaRepository.save(this.venda);
        this.venda.getItens().clear();

        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/recover/{id}")
    public ModelAndView recover(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("venda", vendaRepository.venda(id));
        return new ModelAndView("/vendas/form", model);
    }

    @PostMapping("/update")
    public ModelAndView update(Venda venda) {
        vendaRepository.update(venda);
        return new ModelAndView("redirect:/vendas/list");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        vendaRepository.remove(id);
        return new ModelAndView("redirect:/vendas/list");
    }
}
