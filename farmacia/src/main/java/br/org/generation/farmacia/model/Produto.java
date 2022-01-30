package br.org.generation.farmacia.model;

	import  java.math.BigDecimal ;
import java.util.List;

import javax.persistence.CascadeType;
import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import javax.persistence.OneToMany;
import  javax.persistence.Table ;
import  javax.validation.constraints.NotNull ;

import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;


	@Entity
	@Table (name = "tb_produtos")
	public class Produto {
		
		@Id
		@GeneratedValue ( strategy =  GenerationType . IDENTITY )
		 private long id;
	
	
		@NotNull (message  = " O campo PREÇO é obrigatório e não pode ser preenchido apenas com espaços em branco! " )
	
		
		@OneToMany (mappedBy = "produto", cascade = CascadeType.ALL)
		@JsonIgnoreProperties ("produto")
		private List <Produto> produto;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public List<Produto> getProduto() {
			return produto;
		}


		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}

	}