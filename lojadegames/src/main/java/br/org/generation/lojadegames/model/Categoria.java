package br.org.generation.lojadegames.model;


import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import javax.persistence.ManyToOne;
import  javax.persistence.Table ;
import  javax.validation.constraints.NotBlank ;
import javax.validation.constraints.Size;

import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

	@Entity
	@Table (name = " tb_categorias ")
	public class Categoria {
		
		@Id
		@GeneratedValue ( strategy  =  GenerationType . IDENTITY )
		private Long id;
		
		@NotBlank ( message  =  " O campo TIPO é obrigatório e não aceite apenas espaços em branco! " )
		@Size (min= 5, max= 100, message ="O atributo texto deve conter no mínimo 05 e no máximo 100 caracteres.")
		private String texto;
		
		@ManyToOne
		@JsonIgnoreProperties ("categoria ")
		private  Produto produto;
		
		public  Produto  getProduto () {
			return produto;
		}

		public  void  setProduto (Produto produto) {
			this.produto = produto;
		}

		public  Long  getId () {
			return id;
		}

		public  void  setId (Long  id) {
			this . id = id;
		}

		

	}

