package com.generation.helloworld.controller.Spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")

public class HelloController {
	
	@GetMapping
	public String hello()
	{
		return "Hello Word";
	}

	@GetMapping("/hbilidades e mentalidades")
	public String mentalidades()
	{
		return "As habilidades e mentalidades usadas foram: Persistencia e atenção aos detalhes.";
	}
	
	@GetMapping("/Aprendizado")
	public String Aprendizado()
	{
		return "Uma semana de muita persitencia e confiabilidade própria.";
	}
}
