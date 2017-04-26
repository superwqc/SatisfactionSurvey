package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Question;
import satisfactionSurvey.domain.Roles;

public interface IQuestionDao {
	public void save(Question q);
	public void delete(Integer qid);
	public void update(Question q);
	public Question find(Integer qid);
	public List<Question> find();
	
	public int getRowCount();
	//返回分页数据
	public List<Question> find(int startLine,int size);
	
}
