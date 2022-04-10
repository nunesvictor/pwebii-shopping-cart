package br.edu.ifto.pwebii.aula09.model.repository;

import br.edu.ifto.pwebii.aula09.model.entity.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProdutoRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Produto produto) {
        manager.persist(produto);
    }

    public Produto produto(Long id) {
        return manager.find(Produto.class, id);
    }

    public List<Produto> produtos() {
        Query query = manager.createQuery("from Produto");
        return query.getResultList();
    }

    public void remove(Long id) {
        Produto produto = manager.find(Produto.class, id);
        manager.remove(produto);
    }

    public void update(Produto produto) {
        manager.merge(produto);
    }
}
