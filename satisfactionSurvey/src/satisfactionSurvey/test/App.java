package satisfactionSurvey.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import satisfactionSurvey.domain.Roles;
import satisfactionSurvey.service.IRolesService;

public class App {
	@Test
	public void testname() throws Exception {
		ApplicationContext acc=new ClassPathXmlApplicationContext("applicationContext.xml");
		IRolesService service=(IRolesService) acc.getBean("rolesServiceImpl");
		
		Roles r=new Roles();
		r.setRname("teacher");
		
		service.save(r);
	}

}
