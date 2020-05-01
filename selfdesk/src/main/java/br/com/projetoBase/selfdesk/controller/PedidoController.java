package br.com.projetoBase.selfdesk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoBase.selfdesk.dao.PedidoDAO;
import br.com.projetoBase.selfdesk.dao.SoftwareDAO;
import br.com.projetoBase.selfdesk.model.Item;
import br.com.projetoBase.selfdesk.model.Pedido;
import br.com.projetoBase.selfdesk.model.Software;

@CrossOrigin("*")
@RestController
public class PedidoController {
	
	@Autowired
	private PedidoDAO dao;
	
	@Autowired
	private SoftwareDAO softwareDao;
	
	@PostMapping("/pedido/novo")
	public ResponseEntity<Pedido> adicionarPedido(@RequestBody Pedido novo){
		try {
			// preciso referenciar que cada item tem que corresponder ao pedido
			// a ser criado, pois senao, a referencia FK se perde
			for (Item i: novo.getItens()) {
				i.setPedido(novo);
			}
			dao.save(novo);
			
			// vou subtrair do estoque
			
		    for( Item i: novo.getItens()) {
		    	Software s = i.getItemSoftware();
		    	s = softwareDao.findById(s.getId()).get();
		    	s.setQtdEstoque(s.getQtdEstoque()-1);
		    	softwareDao.save(s);
		    }
			return ResponseEntity.ok(novo);
		}
		catch(Exception e) {
			// bad request
			return ResponseEntity.status(400).build();
		}		
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<ArrayList<Pedido>> recuperarTodos(){
		ArrayList<Pedido> lista = (ArrayList<Pedido>)dao.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/pedido/{numPedido}")
	public ResponseEntity<Pedido> recuperarPorNumero(@PathVariable int numPedido){
		Pedido pedido = dao.findById(numPedido).orElse(null);
		if (pedido == null) {
			return ResponseEntity.notFound().build();
		}
		else {
			return ResponseEntity.ok(pedido);
		}
	}
}