package br.org.generation.lojadegames.model;
import java.util.List;

import javax.persistence.CascadeType;
import  javax.persistence.Entity ;
import  javax.persistence.GeneratedValue ;
import  javax.persistence.GenerationType ;
import  javax.persistence.Id ;
import javax.persistence.OneToMany;
import  javax.persistence.Table ;
import  javax.validation.constraints.NotBlank ;

import  com.fasterxml.jackson.annotation.JsonIgnoreProperties ;

	@Entity
	@Table (name  =  " tb_produtos ")
	public class Produto {
		
		@Id
		@GeneratedValue ( strategy  =  GenerationType . IDENTITY )
		private long id;
		
		@NotBlank ( message  = " O campo NOME é obrigatório e não pode ser preenchido apenas com espaços em branco! " )
		String privada ;
		
		@OneToMany(mappedBy="produto", cascade=CascadeType.ALL)
		@JsonIgnoreProperties ("produto")
	
		private  List <Categoria> categoria;
		
		public  String foto;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPrivada() {
			return privada;
		}

		public void setPrivada(String privada) {
			this.privada = privada;
		}

		public List<Categoria> getCategoria() {
			return categoria;
		}

		public void setCategoria(List<Categoria> categoria) {
			this.categoria = categoria;
		}

		public String getFoto() {
			return foto;
		}

		public void setFoto(String foto) {
			this.foto = foto;
		}
		
		
	}
	
		
