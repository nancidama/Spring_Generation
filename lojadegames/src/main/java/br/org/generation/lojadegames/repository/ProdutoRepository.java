package br.org.generation.lojadegames.repository;


	import java.math.BigDecimal ;
	import  java.util.List ;

	import  org.springframework.data.jpa.repository.JpaRepository ;
	import  org.springframework.stereotype.Repository ;

	import  br.org.generation.lojadegames.model.Produto ;

	@Repository
	public interface ProdutoRepository extends  JpaRepository< Produto , Long > {
		
		public  List <Produto> findAllByNomeContainingIgnoreCase ( String  nome );
		
		public  List <Produto> findByPrecoGreaterThanOrderByPreco ( BigDecimal  preco );
		
		/*
		 * Método - Buscar todos os produtos cujo o preco seja menor
		 * do que um valor digitado ordenado pelo preço em ordem decrescente
		 *
		 * MsSQL: selecione * de tb_produtos onde preco < preco pedido por preco desc;
		 *
		 */

		public  List < Produto > findByPrecoLessThanOrderByPrecoDesc ( BigDecimal  preco );
	}

