package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.User;

public interface IUserDao {
	public void save(User u);
	public void delte(Integer uid);
	public void update(User u);
	public User find(Integer uid);
	public List<User> find();
	
	public int getRowCount();
	public List<User> find(int startLine,int size);
	
	

}
