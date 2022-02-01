package br.org.generation.blogpessoal.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.generation.blogpessoal.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByUsuario(String Usuario);
}
//Foi assinado com o Optional por que ele vai retornar apenas 1. Se não existir ele será nullo.
//Se o usuario já existir não vai deixar cadastrar.Por isso usamos esse método