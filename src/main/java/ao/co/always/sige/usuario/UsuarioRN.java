package ao.co.always.sige.usuario;

import java.util.List;

import ao.co.always.sige.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		Integer idUsuario = usuario.getIdUsuario();
		if (idUsuario == null || idUsuario == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.actualizar(usuario);
		}
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public Usuario carregar(Integer idUsuario) {
		return this.usuarioDAO.carregar(idUsuario);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}
}
