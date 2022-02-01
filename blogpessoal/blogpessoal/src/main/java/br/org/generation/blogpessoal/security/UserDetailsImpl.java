package br.org.generation.blogpessoal.security;

import java.util.Collection;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.org.generation.blogpessoal.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

/**
 * Método construtor com parâmetros 
 * 
 * Observe que este método Construtor recebe um objeto Usuario e
 * Recuperar os dados através dos respectivos métodos
 */
private String userName;
private String password;
private List<GrantedAuthority> authorities; //direitos garantidos do usuarios. Direitos de acesso

public UserDetailsImpl(Usuario usuario) {
	this.userName = usuario.getUsuario();
	this.password = usuario.getSenha();
	
}
 public UserDetailsImpl() { }
 
 @Override
 public Collection<? extends GrantedAuthority> getAuthorities() {
	 return authorities;
 }
 
 @Override
 public String getPassword() {
	return password;
	
 }
 
 @Override
 public String getUsername() {
	 return userName;
	 
 }

 @Override
 public boolean isAccountNonExpired() {
	 return true;
 }
 @Override
 public boolean isAccountNonLocked() {
	 return true;
}
 
 @Override
 public boolean  isCredentialsNonExpired () {
	 return true;
 }
 
 @Override
 public boolean isEnabled() {
	 return true;
	 
 	}
}
