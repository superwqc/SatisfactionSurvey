package satisfactionSurvey.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import satisfactionSurvey.dao.IQuestionDao;
import satisfactionSurvey.domain.Question;

@Repository
public class QuestionDaoImpl implements IQuestionDao {
	@Autowired
	private SessionFactory sf;
	
	private Session getSession(){
		return  sf.getCurrentSession();
	}

	public void delete(Integer qid) {
		Question q=(Question) getSession().get(Question.class,qid);
		getSession().delete(q);

	}

	public Question find(Integer qid) {
		Question q=(Question) getSession().get(Question.class,qid);
		return q;
	}

	public List<Question> find() {
		return getSession().createQuery("FROM Question").list();
	}

	public void save(Question q) {
		getSession().save(q);

	}

	public void update(Question q) {
		getSession().update(q);

	}

	public List<Question> find(int startLine, int size) {
		Query q=getSession().createQuery("FROM Question");
		q.setFirstResult(startLine);
		q.setMaxResults(size);
		return q.list();
	}

	public int getRowCount() {
		long l=(Long)getSession().createQuery("SELECT COUNT(*) FROM Question").uniqueResult();
		return (int) l;
	}

}
