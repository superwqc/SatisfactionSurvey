package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Score;

public interface IScoreDao {
	public void save(Score s);
	public void delete(Integer sid);
	public void update(Score s);
	public Score find(Integer sid);
	public List<Score>find();

}
