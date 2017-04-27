package satisfactionSurvey.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.User;
import satisfactionSurvey.service.IUserService;
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService service;
	
	
	@RequestMapping("/find")
	public void find(int page,int rows,HttpServletResponse response) throws Exception{
		
		Page pp=service.findDataPage(page,rows);
		
		JsonConfig jc=new JsonConfig();
		jc.setExcludes(new String[]{"scores","papers","users","questions"});
		
		String json=JSONArray.fromObject(pp.getList(),jc).toString();
		json="{\"total\":\""+pp.getRowCount()+"\", \"rows\":"+json+"}";
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	@RequestMapping("/save")
	public void save(User u,HttpServletResponse response) throws Exception{
		service.save(u);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
		
	}
	@RequestMapping("/delete")
	public void delete(int uid,HttpServletResponse response) throws Exception{
		service.delte(uid);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
		
	}
	@RequestMapping("/update")
	public void update(User u,HttpServletResponse response) throws Exception{
		service.update(u);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
		
	}


}
