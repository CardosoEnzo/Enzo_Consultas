package com.ksi.enzo;

import org.springframework.stereotype.Component;
//Classe feita somente para imprimir uma mensagem caso o usuário não atenda os requisitos de cadastro do sistema.
@Component
public class RespostaModelo {

	private String mensagem;

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
