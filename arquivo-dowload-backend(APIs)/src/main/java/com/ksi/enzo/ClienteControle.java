package com.ksi.enzo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Classe responsável para informar as rotas que serão utilizadas.
@RestController
@CrossOrigin(origins = "*")
public class ClienteControle {

	@Autowired
	private ClienteServico clienteSevico;

	// rota para listar clientes
	@GetMapping("/listar")
	public Iterable<ClienteModelo> listar() {
		return clienteSevico.listar();
	}

	// rota para cadastrar clientes
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody ClienteModelo cm) {
		return clienteSevico.cadastrarAlterar(cm, "cadastrar");
	}

	// rota para alterar clientes
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody ClienteModelo cm) {
		return clienteSevico.cadastrarAlterar(cm, "alterar");
	}

}
