package satisfactionSurvey.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import satisfactionSurvey.dao.IUserDao;
import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.User;
@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}

	public void delte(Integer uid) {
		User u=(User) getSession().get(User.class, uid);
		getSession().delete(u);
	}

	public User find(Integer uid) {
		User u=(User) getSession().get(User.class, uid);
		return u;
	}

	public List<User> find() {
		return getSession().createQuery("FROM User").list();
	}

	public void save(User u) {
		getSession().save(u);
		
	}

	public void update(User u) {
		getSession().update(u);
	}

	public List<User> find(int startLine, int size) {
		Query q=getSession().createQuery("FROM User");
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		
		return q.list();
	}

	public int getRowCount() {
		
		long l=(Long)getSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult();
		return (int) l;
	}


}
