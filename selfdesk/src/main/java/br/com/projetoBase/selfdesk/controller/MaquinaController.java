package br.com.projetoBase.selfdesk.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetoBase.selfdesk.dao.MaquinaDAO;
import br.com.projetoBase.selfdesk.model.Maquina;

@CrossOrigin("*")
@RestController
public class MaquinaController {

	@Autowired
	private MaquinaDAO dao;
	
	@GetMapping("/maquina")
	public ResponseEntity<ArrayList<Maquina>>getAllUsers(){
		
		ArrayList<Maquina> lista = (ArrayList<Maquina>)dao.findAll();
		
		return ResponseEntity.ok(lista);
	}
	
}
