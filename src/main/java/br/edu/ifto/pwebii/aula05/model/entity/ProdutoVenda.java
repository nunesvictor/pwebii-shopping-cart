package br.edu.ifto.pwebii.aula05.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "produtos_vendas")
public class ProdutoVenda {
    @EmbeddedId
    private ProdutoVendaPK id;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToOne
    @MapsId("vendaId")
    @JoinColumn(name = "venda_id")
    private Venda venda;

    private Double quantidade;

    public ProdutoVenda() {
    }

    public ProdutoVendaPK getId() {
        return id;
    }

    public void setId(ProdutoVendaPK id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double total() {
        return quantidade * produto.getValor();
    }
}
