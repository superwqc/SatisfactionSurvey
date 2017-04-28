package satisfactionSurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import satisfactionSurvey.dao.IPaperDao;
import satisfactionSurvey.domain.Paper;
import satisfactionSurvey.service.IPaperService;

@Service
@Transactional
public class PaperServiceImpl  implements IPaperService{
	@Autowired
	private IPaperDao dao;

	public void delete(Integer pid) {
		dao.delete(pid);
		
	}

	public Paper find(Integer pid) {
		return dao.find(pid);
	}

	public List<Paper> find() {
		return dao.find();
	}

	public void save(Paper p) {
		dao.save(p);
	}

	public void update(Paper p) {
		dao.update(p);
		
	}

}
