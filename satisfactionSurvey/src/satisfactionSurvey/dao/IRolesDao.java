package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Roles;

public interface IRolesDao {
	public void save(Roles r);
	public void delete(Integer rid);
	public void update(Roles r);
	public Roles find(Integer rid);
	public List<Roles> find();
	//返回行数
	public int getRowCount();
	//返回分页数据
	public List<Roles> find(int startLine,int size);
}
