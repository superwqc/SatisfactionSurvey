package satisfactionSurvey.service;

import java.util.List;

import satisfactionSurvey.domain.Score;

public interface IScoreService {
	public void save(Score s);
	public void delete(Integer sid);
	public void update(Score s);
	public Score find(Integer sid);
	public List<Score>find();

}
