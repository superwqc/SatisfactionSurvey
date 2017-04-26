package satisfactionSurvey.service;

import java.util.List;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.Question;

public interface IQuestionService {
	public void save(Question q);
	public void delete(Integer qid);
	public void update(Question q);
	public Question find(Integer qid);
	public List<Question> find();
	public Page getDatePage(int p,int size);
	
	
	

}
