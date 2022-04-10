package br.edu.ifto.pwebii.aula06.model.repository;

import br.edu.ifto.pwebii.aula06.model.PessoaFisica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaFisicaRepository {
    @PersistenceContext
    private EntityManager manager;

    public void save(PessoaFisica pessoaFisica) {
        manager.persist(pessoaFisica);
    }

    public PessoaFisica pessoaFisica(Long id) {
        return manager.find(PessoaFisica.class, id);
    }

    public List<PessoaFisica> pessoasFisicas() {
        Query query = manager.createQuery("from PessoaFisica");
        return query.getResultList();
    }

    public void remove(Long id) {
        PessoaFisica pessoaFisica = manager.find(PessoaFisica.class, id);
        manager.remove(pessoaFisica);
    }

    public void update(PessoaFisica pessoaFisica) {
        manager.merge(pessoaFisica);
    }
}
