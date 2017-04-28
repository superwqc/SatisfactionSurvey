package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Paper;

public interface IPaperDao {
	public void save(Paper p);
	public void delete(Integer pid);
	public void update(Paper p);
	public Paper find(Integer pid);
	public List<Paper> find();
	
}
