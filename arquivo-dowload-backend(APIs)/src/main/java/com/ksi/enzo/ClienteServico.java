package com.ksi.enzo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//Classe responsável por conter todos os métodos que o sistema vai utilizar.
@Service
public class ClienteServico {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	private RespostaModelo respostaModelo;

	// Método responsável por listar clientes
	public Iterable<ClienteModelo> listar() {
		return clienteRepositorio.findAll();
	}

	/*
	 * Este método é responsável por cadastrar ou Alterar um usuário. Ele pede no
	 * parâmetro um objeto do tipo "ClienteModelo", e uma String. Se o usuário
	 * passar no parâmetro a String "cadastrar"; ele faz o cadastro. Se passar outro
	 * tipo de String ele faz a alteração.
	 */
	public ResponseEntity<?> cadastrarAlterar(ClienteModelo cm, String acao) {

		if (cm.getCpf().equals("")) {
			respostaModelo.setMensagem("O Cpf do Cliente é obrigatório");
			return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
		} else if (cm.getNome().equals("")) {
			respostaModelo.setMensagem("O nome do Cliente é obrigatório");
			return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
		} else if (cm.getSobrenome().equals("")) {
			respostaModelo.setMensagem("O Sobrenome do Cliente é obrigatório");
			return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
		} else if (cm.getEmail().equals("")) {
			respostaModelo.setMensagem("O email do Cliente é obrigatório");
			return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
		} else if (cm.getTelefone().equals("")) {
			respostaModelo.setMensagem("O telefone do Cliente é obrigatório");
			return new ResponseEntity<RespostaModelo>(respostaModelo, HttpStatus.BAD_REQUEST);
		} else {
			if (acao.equals("cadastrar")) {
				return new ResponseEntity<ClienteModelo>(clienteRepositorio.save(cm), HttpStatus.CREATED);
			} else {
				return new ResponseEntity<ClienteModelo>(clienteRepositorio.save(cm), HttpStatus.OK);
			}
		}

	}

}
