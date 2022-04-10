package br.edu.ifto.pwebii.aula05.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date data;

    @OneToMany(mappedBy = "venda")
    private List<ProdutoVenda> itens = new ArrayList<>();

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoVenda> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoVenda> itens) {
        this.itens = itens;
    }

    public Double total() {
        double total = 0.0;

        for (ProdutoVenda produtoVenda : itens) {
            total += produtoVenda.total();
        }

        return total;
    }
}
