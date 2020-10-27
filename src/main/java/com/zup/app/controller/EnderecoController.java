package com.zup.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.zup.app.model.Endereco;

import com.zup.app.repository.EnderecoRepository;

@Controller
@Service
public class EnderecoController {
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastroendereco")
	public String inicio() {
		return "cadastro/cadastroendereco";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvarendereco")
	public ModelAndView salvar(@Valid Endereco endereco, BindingResult result) {
			
			if(result.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView("cadastro/cadastroendereco");
				Iterable<Endereco> enderecosIt = enderecoRepository.findAll();
				modelAndView.addObject("enderecos", enderecosIt);

				
				List<String> msg = new ArrayList<String>();
				
				for (ObjectError objectError : result.getAllErrors()) {
					msg.add(objectError.getDefaultMessage());
				}
				
				modelAndView.addObject("msg", msg);
				return modelAndView;

			}
			

			enderecoRepository.save(endereco);
			ModelAndView andView = new ModelAndView("cadastro/cadastroendereco");

			Iterable<Endereco> enderecosIt = enderecoRepository.findAll();
			andView.addObject("enderecos", enderecosIt);

			return andView;

		
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/listaenderecos")
	public ModelAndView enderecos() {
		ModelAndView andView = new ModelAndView("cadastro/cadastroendereco");
		Iterable<Endereco> enderecosIt = enderecoRepository.findAll();
		andView.addObject("enderecos", enderecosIt);
		return andView;
	}

}
