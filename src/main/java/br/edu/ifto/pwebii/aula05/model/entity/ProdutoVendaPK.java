package br.edu.ifto.pwebii.aula05.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoVendaPK implements Serializable {
    @Column(name = "produto_id")
    private Long produtoId;

    @Column(name = "venda_id")
    private Long vendaId;

    public ProdutoVendaPK() {
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getVendaId() {
        return vendaId;
    }

    public void setVendaId(Long vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProdutoVendaPK that = (ProdutoVendaPK) o;
        return Objects.equals(produtoId, that.produtoId) && Objects.equals(vendaId, that.vendaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, vendaId);
    }
}
