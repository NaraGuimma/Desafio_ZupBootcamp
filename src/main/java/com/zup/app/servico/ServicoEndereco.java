package com.zup.app.servico;

import java.io.Serializable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zup.app.model.Endereco;

public class ServicoEndereco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Endereco buscarEnderecoPor(String urlJson) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		final Gson gson = gsonBuilder.create();
		Gson g = new Gson();
		Endereco retornoEndereco = gson.fromJson(urlJson,  Endereco.class);
		return retornoEndereco;
		
	}

}
