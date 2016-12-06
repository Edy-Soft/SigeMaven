package ao.co.always.sige.usuario;

import java.util.List;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	public void actualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario carregar(Integer idUsuario);
	public Usuario buscarPorLogin(String login);
	public List<Usuario> listar();

}
