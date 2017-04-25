package satisfactionSurvey.dao;

import java.util.List;

import satisfactionSurvey.domain.Roles;

public interface IRolesDao {
	public void save(Roles r);
	public void delete(Integer rid);
	public void update(Roles r);
	public Roles find(Integer rid);
	public List<Roles> find();

}
