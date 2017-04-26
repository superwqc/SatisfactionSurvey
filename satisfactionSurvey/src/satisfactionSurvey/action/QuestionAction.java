package satisfactionSurvey.action;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Page;
import satisfactionSurvey.domain.Question;
import satisfactionSurvey.service.IQuestionService;

@Controller
@RequestMapping("/question")
public class QuestionAction {
	@Autowired
	private IQuestionService service;
	
	@RequestMapping("/find")
	public void find(int page,int rows,HttpServletResponse response) throws Exception{
		Page pp=service.getDatePage(page,rows);
		
		
		JsonConfig jc=new JsonConfig();
		jc.setExcludes(new String[]{"papers","scores","questions"});
		
		String json=JSONArray.fromObject(pp.getList(),jc).toString();
		json="{\"total\":"+pp.getRowCount()+",\"rows\":"+json+"}";
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(json);
	}
	@RequestMapping("/save")
	public void save(Question q,HttpServletResponse response) throws Exception{
		
		service.save(q);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
	}
	@RequestMapping("/update")
	public void update(Question q,HttpServletResponse response) throws Exception{
		
		service.update(q);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
	}
	
	@RequestMapping("/delete")
	public void delete(int qid,HttpServletResponse response) throws Exception{
		service.delete(qid);
		
		response.setCharacterEncoding("utf-8");
		response.getWriter().write("{}");
	}

}
