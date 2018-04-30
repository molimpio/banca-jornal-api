package br.com.olimpio.bancajornal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.olimpio.bancajornal.domain.Banca;

@Repository
public interface BancaRepository extends JpaRepository<Banca, Integer> {

}