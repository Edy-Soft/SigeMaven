package ao.co.always.sige.usuario;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

@SuppressWarnings("deprecation")
public class UsuarioDAOHibernate implements UsuarioDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);

	}

	@Override
	public void actualizar(Usuario usuario) {
		this.session.update(usuario);

	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);

	}

	@Override
	public Usuario carregar(Integer idUsuario) {
		return (Usuario) this.session.get(Usuario.class, idUsuario);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from usuario u where u.login = :login";
		@SuppressWarnings("rawtypes")
		Query consulta = this.session.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	} 

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

}
