package br.com.projetoBase.selfdesk.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.projetoBase.selfdesk.model.Pedido;

public interface PedidoDAO extends CrudRepository<Pedido,Integer>{

}
