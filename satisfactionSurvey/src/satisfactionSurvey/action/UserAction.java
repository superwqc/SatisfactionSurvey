package satisfactionSurvey.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.Paper;
import satisfactionSurvey.domain.Roles;
import satisfactionSurvey.domain.User;
import satisfactionSurvey.service.IPaperService;
import satisfactionSurvey.service.IUserService;
@Controller
@RequestMapping("/user")
public class UserAction {
	@Autowired
	private IUserService service;
	@Autowired
	private IPaperService pservice;
	
	
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
		service.delete(uid);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
		
	}
	@RequestMapping("/update")
	public void update(User u,HttpServletResponse response) throws Exception{
		User u2=new User();
		u2.setAccount(u.getAccount());
		u2.setPassword(u.getPassword());
		u2.setRealname(u.getRealname());
		u2.setRoles(u.getRoles());
		service.update(u2);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
		
	}
	@RequestMapping("/findAll")
	public void findAll(HttpServletResponse response) throws Exception{
		List<User> list=service.find();
		JsonConfig jc=new JsonConfig();
		//防止表间关系重复调用
		jc.setExcludes(new String[]{"questions","users","scores","papers"});
		
		String json=JSONArray.fromObject(list,jc).toString();
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	
	@RequestMapping("/login")
	public String login(String account,String password,HttpSession session,HttpServletRequest request){
		
		User u=service.findByAccountAndPassword(account, password);
		String path="";
		if(u==null){
			path="redirect:/front/index.jsp";
		}else{
			
			//登录成功后，存入Session
			session.setAttribute("user",u);
			
			//登录的是学生
			if(u.getRoles().getRname().equals("professor")){
				List<Paper> list=pservice.find();
				List list2=new ArrayList();
				for (int i = 0; i < list.size(); i++) {
					Paper p=list.get(i);
					if(p.getStatus()==1){
						list2.add(p);
					}
				}
				request.setAttribute("list", list2);
				
				path="front/showActivePaper";
				
			}
			//登录的是被评价的人，查看评价个人问卷
			else{
				//用户的相关问卷
				List list=new ArrayList(u.getPapers());
				request.setAttribute("list",list);
				path="front/showUserPaper";
				
				
			}
			
			
			
			
		}
		return path;
	}


}
