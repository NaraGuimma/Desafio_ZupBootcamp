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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zup.app.model.Pessoa;
import com.zup.app.repository.PessoaRepository;

@Controller
@Service
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/cadastropessoa")
	public String inicio() {
		return "cadastro/cadastropessoa";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvarpessoa")
	public ModelAndView salvar(@Valid Pessoa pessoa, BindingResult result) {
			
			if(result.hasErrors()) {
				ModelAndView modelAndView = new ModelAndView("cadastro/cadastropessoa");
				Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
				modelAndView.addObject("pessoas", pessoasIt);

				
				List<String> msg = new ArrayList<String>();
				
				for (ObjectError objectError : result.getAllErrors()) {
					msg.add(objectError.getDefaultMessage());
				}
				
				modelAndView.addObject("msg", msg);
				return modelAndView;

			}
			

			pessoaRepository.save(pessoa);
			ModelAndView andView = new ModelAndView("cadastro/cadastroendereco");


			return andView;

		
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value="/listapessoas")
	public ModelAndView pessoas() {
		ModelAndView andView = new ModelAndView("cadastro/cadastroendereco");
		Iterable<Pessoa> pessoasIt = pessoaRepository.findAll();
		andView.addObject("pessoas", pessoasIt);
		return andView;
	}

}
