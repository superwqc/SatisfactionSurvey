package satisfactionSurvey.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import satisfactionSurvey.domain.Roles;
import satisfactionSurvey.service.IRolesService;

@Controller
@RequestMapping("/roles")
public class RolesAction {
	@Autowired
	IRolesService service;
	
	@RequestMapping("/save")
	public void save(Roles r,HttpServletResponse response) throws Exception{
		service.save(r);
		//页面加载，引起回调函数执行
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/delete")
	public void delete(int rid ,HttpServletResponse response) throws Exception {
		service.delete(rid);
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/update")
	public void update(Roles r,HttpServletResponse response) throws Exception {
		service.update(r);
		
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/find")
	public void find(HttpServletResponse response) throws Exception{
		List<Roles> list=service.find();
		JsonConfig jc=new JsonConfig();
		//防止表间关系重复调用
		jc.setExcludes(new String[]{"roles","users","scores","papers"});
		String json=JSONArray.fromObject(list,jc).toString();
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}

}
