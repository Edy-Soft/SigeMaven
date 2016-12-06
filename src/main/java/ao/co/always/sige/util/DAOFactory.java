package ao.co.always.sige.util;

import ao.co.always.sige.usuario.UsuarioDAO;
import ao.co.always.sige.usuario.UsuarioDAOHibernate;

public class DAOFactory {
	
	public static UsuarioDAO criarUsuarioDAO(){
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HiberbateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

}
