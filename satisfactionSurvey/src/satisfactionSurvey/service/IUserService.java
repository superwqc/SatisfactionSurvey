package satisfactionSurvey.service;

import java.util.List;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.User;

public interface IUserService {
	public void save(User u);
	public void delte(Integer uid);
	public void update(User u);
	public User find(Integer uid);
	public List<User> find();
	
	public Page findDataPage(int p,int size);

}
