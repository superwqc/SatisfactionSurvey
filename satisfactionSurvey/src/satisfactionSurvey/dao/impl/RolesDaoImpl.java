package satisfactionSurvey.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import satisfactionSurvey.dao.IRolesDao;
import satisfactionSurvey.domain.Roles;

@Repository
public class RolesDaoImpl implements IRolesDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}

	public void delete(Integer rid) {
		Roles r=(Roles) getSession().get(Roles.class, rid);
		getSession().delete(r);
	}

	public Roles find(Integer rid) {
		Roles r=(Roles) getSession().get(Roles.class, rid);
		return r;
	}

	public List<Roles> find() {
		return getSession().createQuery("FROM Roles").list();
	}

	public void save(Roles r) {
		getSession().save(r);
		
	}

	public void update(Roles r) {
		getSession().update(r);
		
	}
	//查分页数据
	public List<Roles> find(int startLine, int size) {
		Query q=getSession().createQuery("FROM Roles");
		q.setFirstResult(startLine);
		q.setMaxResults(size);//第几行开始往下选几行
		return q.list();
	}

	public int getRowCount() {
		//一行一列调用
		long l=(Long)getSession().createQuery("SELECT COUNT(*) FROM Roles").uniqueResult();
		return (int)l;
	}


}
