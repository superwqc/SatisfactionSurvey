package satisfactionSurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import satisfactionSurvey.dao.IUserDao;
import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.User;
import satisfactionSurvey.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao dao;

	public void delte(Integer uid) {
		dao.delte(uid);
	}

	public User find(Integer uid) {
		return dao.find(uid);
	}

	public List<User> find() {
		return dao.find();
	}

	public void save(User u) {
		dao.save(u);
	}

	public void update(User u) {
		dao.update(u);
	}

	public Page findDataPage(int p, int size) {
		int rowCount=dao.getRowCount();
		Page pp=new Page(p,rowCount,size);
		
		List<User> list=dao.find(pp.getStartLine(),pp.getSize());
		pp.setList(list);
		
		
		return pp;
	}


}
