package satisfactionSurvey.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Paper;
import satisfactionSurvey.service.IPaperService;

@Controller
@RequestMapping("/paper")
public class PaperAction {
	@Autowired
	private IPaperService service;
	
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

}
