package satisfactionSurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import satisfactionSurvey.dao.IRolesDao;
import satisfactionSurvey.domain.Roles;
import satisfactionSurvey.service.IRolesService;

@Service
@Transactional
public class RolesServiceImpl implements IRolesService{
	@Autowired
	private IRolesDao dao;

	public void delete(Integer rid) {
		dao.delete(rid);
		
	}

	public Roles find(Integer rid) {
		return dao.find(rid);
	}

	public List<Roles> find() {
		return dao.find();
	}

	public void save(Roles r) {
		dao.save(r);
	}

	public void update(Roles r) {
		dao.update(r);
	}

}
