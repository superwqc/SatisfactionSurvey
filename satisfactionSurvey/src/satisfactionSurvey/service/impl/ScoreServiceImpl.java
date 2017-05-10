package satisfactionSurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import satisfactionSurvey.dao.IScoreDao;
import satisfactionSurvey.domain.Score;
import satisfactionSurvey.service.IScoreService;

@Repository
@Transactional
public class ScoreServiceImpl  implements IScoreService{
	
	@Autowired
	private IScoreDao dao;
	
	public void delete(Integer sid) {
		dao.delete(sid);
		
	}

	public Score find(Integer sid) {
		return dao.find(sid);
	}

	public List<Score> find() {
		return dao.find();
	}

	public void save(Score s) {
		dao.save(s);
	}

	public void update(Score s) {
		dao.update(s);
	}

}
