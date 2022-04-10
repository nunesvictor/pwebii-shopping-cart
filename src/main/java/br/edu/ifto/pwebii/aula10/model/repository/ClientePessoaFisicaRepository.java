package br.edu.ifto.pwebii.aula10.model.repository;

import br.edu.ifto.pwebii.aula10.model.entity.ClientePessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientePessoaFisicaRepository extends JpaRepository<ClientePessoaFisica, Long> {
}
