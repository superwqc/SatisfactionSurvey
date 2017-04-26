package satisfactionSurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import satisfactionSurvey.dao.IQuestionDao;
import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.Question;
import satisfactionSurvey.service.IQuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements IQuestionService {
	@Autowired
	private IQuestionDao dao;

	public void delete(Integer qid) {
		dao.delete(qid);
	}

	public Question find(Integer qid) {
		return dao.find(qid);
	}

	public List<Question> find() {
		return dao.find();
	}

	public void save(Question q) {
		dao.save(q);
	}

	public void update(Question q) {
		dao.update(q);
	
	}

	public Page getDatePage(int p, int size) {
		int rowcount=dao.getRowCount();
		Page pp=new Page(p,rowcount,size);
		List<Question> list=dao.find(pp.getStartLine(), pp.getSize());
		pp.setList(list);
		return pp;
	}

}
