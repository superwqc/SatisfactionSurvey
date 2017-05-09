package satisfactionSurvey.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Paper;
import satisfactionSurvey.domain.Question;
import satisfactionSurvey.service.IPaperService;
import satisfactionSurvey.service.IQuestionService;

@Controller
@RequestMapping("/paper")
public class PaperAction {
	@Autowired
	private IPaperService service;
	@Autowired
	private IQuestionService qservice;
	
	@RequestMapping("/find")
	public void find(HttpServletResponse response) throws Exception{
		List<Paper> list=service.find();
		JsonConfig jc=new JsonConfig();
		jc.setExcludes(new String[]{"questions","scores","papers","roles"});
		jc.registerJsonValueProcessor(Date.class,new JsonValueProcessor() {
			
			public Object processObjectValue(String arg0, Object arg1, JsonConfig arg2) {
				Date dd=(Date) arg1;
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				return sdf.format(dd);
			}
			public Object processArrayValue(Object arg0, JsonConfig arg1) {
				return null;
			}
		});
		String json=JSONArray.fromObject(list,jc).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	
	@RequestMapping("/save")
	public void save(Paper p,HttpServletResponse response) throws Exception{
		p.setPubdate(new Date());
		p.setStatus(0);
		service.save(p);
		
		response.getWriter().write("{}");
		
	}
	
	@RequestMapping("/delete")
	public void delete(int pid,HttpServletResponse response) throws Exception{
		service.delete(pid);
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/update")
	public void update(Paper p,HttpServletResponse response) throws Exception{
		Paper p2=service.find(p.getPid());//表里的数据赋值给p2
		p2.setTitle(p.getTitle());//新的标题覆盖旧的标题
		p2.setUser(p.getUser());//新的调查对象覆盖旧的调查对象
		service.update(p2);
		response.getWriter().write("{}");
		
	}
	
	@RequestMapping("/active")
	public void active(int pid,HttpServletResponse response) throws Exception{
		Paper p=service.find(pid);
		p.setStatus(1);
		service.update(p);
		response.getWriter().write("{}");
	}
	@RequestMapping("/frozen")
	public void frozen(int pid,HttpServletResponse response) throws Exception{
		Paper p=service.find(pid);
		p.setStatus(0);
		service.update(p);
		response.getWriter().write("{}");
	}
	@RequestMapping("/findOne")
	public void findOne(int pid,HttpServletResponse response) throws Exception{
		Paper p=service.find(pid);
		//set转变成list
		List<Question> list =new ArrayList(p.getUser().getRoles().getQuestions());
		
		JsonConfig jc=new JsonConfig();
		jc.setExcludes(new String[]{"scores","roles","papers"});
		String json=JSONArray.fromObject(list, jc).toString();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	
	@RequestMapping("/addQuestionToPaper")
	public void addQuestionToPaper(int pid, int[] qid, HttpServletResponse response) throws Exception {
		
		Paper p = service.find(pid);
		for(int x : qid) {
			Question q = qservice.find(x);
			p.getQuestions().add(q);
		}
		service.update(p);
		
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/showOnePaperUI")
	public String showOnePaperUI(int pid, int[] qid, HttpServletRequest request) throws Exception {
		Paper p=service.find(pid);
		request.setAttribute("p", p);
		
		return "showOnePaper";
	
	
	}
	
	
	
	@RequestMapping("/addQuestionToPaperUI")
	public void addQuestionToPaperUI(int  pid,HttpServletResponse response) throws Exception{
		//根据pid得到整个问卷对象
		Paper p=service.find(pid);
		//问卷标题
		String title=p.getTitle();
		//调查对象的名字
		String realname=p.getUser().getRealname();
		//问卷已有问题
		List  list=new ArrayList(p.getQuestions());
		//问卷备选问题
		List list2=new ArrayList(p.getUser().getRoles().getQuestions());
		list2.removeAll(list);
		
		JsonConfig jc=new JsonConfig();
		jc.setExcludes(new String []{"roles","papers","scores"});
		
		String part2=JSONArray.fromObject(list,jc).toString();
		String part3=JSONArray.fromObject(list2,jc).toString();
		
		String json="{\"part1\":\""+title+"\",  \"part2\":\""+part2+"\",  \"part3\":\""+part3+"\" }";
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	
	
	
	}


}
