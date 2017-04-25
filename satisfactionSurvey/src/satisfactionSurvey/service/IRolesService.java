package satisfactionSurvey.service;

import java.util.List;

import satisfactionSurvey.domain.Roles;

public interface IRolesService {
	public void save(Roles r);
	public void delete(Integer rid);
	public void update(Roles r);
	public Roles find(Integer rid);
	public List<Roles> find();

}
