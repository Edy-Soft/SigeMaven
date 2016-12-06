package ao.co.always.sige.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import ao.co.always.sige.util.HiberbateUtil;

public class ConexaoHibernateFilter implements Filter{
	
	private SessionFactory sessionFactory;
	
	public void init(FilterConfig config) throws ServletException{
		this.sessionFactory = HiberbateUtil.getSessionFactory();
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
				FilterChain chain) throws ServletException{
		try{
			this.sessionFactory.getCurrentSession().beginTransaction();
			chain.doFilter(request, response);
			this.sessionFactory.getCurrentSession().beginTransaction().commit();
			this.sessionFactory.getCurrentSession().close();
		}catch(Throwable ex){
			try{
				if(this.sessionFactory.getCurrentSession().getTransaction().getStatus() != TransactionStatus.ACTIVE) {
					this.sessionFactory.getCurrentSession().getTransaction().rollback();
				}
			}catch(Throwable t){
				t.printStackTrace();
			}
			throw new ServletException(ex);
		}
	}
	public void destroy(){
	}

}
