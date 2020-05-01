package br.com.projetoBase.selfdesk.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoBase.selfdesk.model.Maquina;

public interface MaquinaDAO extends CrudRepository<Maquina,Integer> {

}
