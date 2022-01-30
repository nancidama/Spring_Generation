package br.org.generation.farmacia.model;

	import java.time.LocalDateTime;
import  java.util.List ;



	import  javax.persistence.CascadeType ;
	import  javax.persistence.Entity ;
	import  javax.persistence.GeneratedValue ;
	import  javax.persistence.GenerationType ;
	import  javax.persistence.Id ;
	import  javax.persistence.OneToMany ;
	import  javax.persistence.Table ;
	import  javax.validation.constraints.NotBlank ;
	import  javax.validation.constraints.Size ;

import org.hibernate.annotations.UpdateTimestamp;

import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

	@Entity
	@Table (name = "tb_categorias")
	public class Categoria {
		
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY )
		 private Long id;
		
		@NotBlank (message= " O campo CATEGORIA é obrigatório e não aceita apenas espaços em branco! " )
		@Size (min= 5, max=100, message= "O atributo deve ter no minimo 5 e no maximo 100 caracteres")
		private String titulo;
		
		@NotBlank (message =  "O campo DESCRIÇÃO é obrigatório e não aceita apenas espaços em branco! " )
		private  String descricao;
		
		@UpdateTimestamp
		private LocalDateTime data;
		
		
		private String imagem;
		
		@OneToMany
		@JsonIgnoreProperties ( " categoria " )
		private  Produto produto;

		public  Long  getId () {
			return id;
		}

		public  void  setId (Long  id) {
			this.id = id;
		}

		public  String  getCategoria () {
			return descricao;
		}

		public  void  setCategoria (String categoria){
			this.descricao = descricao;
		}

		public  String  getDescricao () {
			return descricao;
		}

		public  void  setDescricao ( String  descricao ) {
			this.descricao = descricao;
		}

		public  Produto getProduto () {
			return produto;
		}

		public  void  setProduto (Produto vproduto) {
			this.produto = produto;
		}

	}

