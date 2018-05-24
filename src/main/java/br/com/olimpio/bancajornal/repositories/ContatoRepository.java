package br.com.olimpio.bancajornal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.olimpio.bancajornal.domain.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}