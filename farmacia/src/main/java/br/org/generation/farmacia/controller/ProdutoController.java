package br.org.generation.farmacia.controller;

	import  java.util.List ;

import  org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity ;
import  org.springframework.web.bind.annotation.CrossOrigin ;
import org.springframework.web.bind.annotation.DeleteMapping;
import  org.springframework.web.bind.annotation.GetMapping ;
import  org.springframework.web.bind.annotation.PathVariable ;
import  org.springframework.web.bind.annotation.PostMapping ;
import  org.springframework.web.bind.annotation.PutMapping ;
import  org.springframework.web.bind.annotation.RequestBody ;
import  org.springframework.web.bind.annotation.RequestMapping ;
import  org.springframework.web.bind.annotation.RestController ;

import br.org.generation.farmacia.model.Categoria;
import  br.org.generation.farmacia.model.Produto ;
import  br.org.generation.farmacia.repository.CategoriaRepository ;
import  br.org.generation.farmacia.repository.ProdutoRepository ;

	@RestController
	@RequestMapping ( "/produtos" )
	@CrossOrigin ( origins  = "*" , allowedHeaders = "*")
	public class ProdutoController {
		
		@Autowired
		private  ProdutoRepository produtoRepository;
		
		@Autowired
		private  CategoriaRepository categoriaRepository;
		
		@GetMapping
		public  ResponseEntity<List<Categoria>> getAll(){
			return ResponseEntity.ok(categoriaRepository.findAll());
		}
		
		@GetMapping ("/{id}")
		public  ResponseEntity<Produto>  getById (@PathVariable  long id){
			return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound()
					.build());
					
		}
		
		@GetMapping ("/nome/{nome}")
		public  ResponseEntity<List<Produto>>  getByNome (@PathVariable  String  nome){
			return  ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
		}
		
		@PostMapping
		public  ResponseEntity<Produto>  post(@RequestBody  Produto  produto ){
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		}
		@PutMapping
		public  ResponseEntity<Produto> put(@RequestBody  Produto  produto){
			return ResponseEntity.ok(produtoRepository.save(produto));
			
		}
		
		@DeleteMapping ( "/{id} " )
		public  void delete(@PathVariable  Categoria  id){
			categoriaRepository.delete(id);
		}

}
