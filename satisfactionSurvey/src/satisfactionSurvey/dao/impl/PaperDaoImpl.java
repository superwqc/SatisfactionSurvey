package satisfactionSurvey.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import satisfactionSurvey.dao.IPaperDao;
import satisfactionSurvey.domain.Paper;

@Repository
public class PaperDaoImpl implements IPaperDao {
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
		
	}

	public void delete(Integer pid) {
		Paper p=(Paper) getSession().get(Paper.class, pid);
		getSession().delete(p);
	}

	public Paper find(Integer pid) {
		Paper p=(Paper) getSession().get(Paper.class, pid);
		return p;
	}

	public List<Paper> find() {
		return getSession().createQuery("FROM Paper").list();
	}

	public void save(Paper p) {
		getSession().save(p);
		
	}

	public void update(Paper p) {
		getSession().update(p);
	}

}
