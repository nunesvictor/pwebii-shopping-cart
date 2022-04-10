package br.edu.ifto.pwebii.aula11.model.repository;

import br.edu.ifto.pwebii.aula11.model.entity.Venda;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class VendaRepository {

    @PersistenceContext
    private EntityManager manager;

    public void save(Venda venda) {
        manager.persist(venda);
    }

    public Venda venda(Long id) {
        return manager.find(Venda.class, id);
    }

    public List<Venda> vendas() {
        Query query = manager.createQuery("from Venda");
        return query.getResultList();
    }

    public void remove(Long id) {
        Venda venda = manager.find(Venda.class, id);
        manager.remove(venda);
    }

    public void update(Venda venda) {
        manager.merge(venda);
    }
}
