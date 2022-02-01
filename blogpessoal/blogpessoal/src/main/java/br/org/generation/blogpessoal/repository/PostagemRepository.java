package br.org.generation.blogpessoal.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.org.generation.blogpessoal.model.Postagem;

//Repository é resonsável pela comunicação com o banco de dados.
//Faz métodos de busca, de salvar, etc (CRUD).
@Repository
public interface PostagemRepository extends JpaRepository <Postagem,Long>{
	
	List<Postagem>findAllByTituloContainingIgnoreCase(String titulo);
	
	/* O atributo acima equivale: select*from tb_postagens where titulo like %titulo%";*/

}
