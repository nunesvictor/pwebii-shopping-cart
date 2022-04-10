package br.edu.ifto.pwebii.aula06.model.repository;

import br.edu.ifto.pwebii.aula06.model.PessoaJuridica;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PessoaJuridicaRepository {
    @PersistenceContext
    private EntityManager manager;

    public void save(PessoaJuridica pessoaJuridica) {
        manager.persist(pessoaJuridica);
    }

    public PessoaJuridica pessoaJuridica(Long id) {
        return manager.find(PessoaJuridica.class, id);
    }

    public List<PessoaJuridica> pessoasJuridicas() {
        Query query = manager.createQuery("from PessoaJuridica");
        return query.getResultList();
    }

    public void remove(Long id) {
        PessoaJuridica pessoaJuridica = manager.find(PessoaJuridica.class, id);
        manager.remove(pessoaJuridica);
    }

    public void update(PessoaJuridica pessoaJuridica) {
        manager.merge(pessoaJuridica);
    }
}
