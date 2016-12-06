package ao.co.always.sige.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import ao.co.always.sige.usuario.Usuario;
import ao.co.always.sige.usuario.UsuarioRN;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	
	public String novo(){
		this.usuario = new Usuario();
		this.usuario.setActivo(true);
		return "usuario";
	}
	
	public String salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		String senha = this.usuario.getSenha();
		if(!senha.equals(confirmarSenha)){
			FacesMessage facesMessage = new FacesMessage("Confirme a sua senha");
			context.addMessage(null, facesMessage);
			return null;
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(usuario);
		
		return "usuarioSucesso";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmaSenha() {
		return confirmarSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmarSenha = confirmaSenha;
	}
}
