package satisfactionSurvey.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import satisfactionSurvey.dao.IScoreDao;
import satisfactionSurvey.domain.Score;

@Repository
public class ScoreDaoImpl implements IScoreDao{
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return sf.getCurrentSession();
	}
	
	public void delete(Integer sid) {
		Score s=(Score) getSession().get(Score.class, sid);
		getSession().delete(s);
		
		
	}

	public Score find(Integer sid) {
		Score s=(Score) getSession().get(Score.class, sid);
		return s;
	}

	public List<Score> find() {
		return getSession().createQuery("FROM Score").list();
	}

	public void save(Score s) {
		getSession().save(s);
	}

	public void update(Score s) {
		getSession().update(s);
	}

}
