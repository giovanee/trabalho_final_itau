package br.com.projetoBase.selfdesk.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoBase.selfdesk.model.Item;

public interface ItemDAO extends CrudRepository<Item, Integer>{

}
