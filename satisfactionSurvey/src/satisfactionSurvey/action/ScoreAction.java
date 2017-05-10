package satisfactionSurvey.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import satisfactionSurvey.domain.Paper;
import satisfactionSurvey.domain.Score;
import satisfactionSurvey.domain.User;
import satisfactionSurvey.exception.DoNotRepeatRateException;
import satisfactionSurvey.service.IPaperService;
import satisfactionSurvey.service.IQuestionService;
import satisfactionSurvey.service.IScoreService;

@Controller
@RequestMapping("/score")
public class ScoreAction {
	@Autowired
	private IScoreService service;
	@Autowired
	private IPaperService pservice;
	@Autowired
	private IQuestionService qservice;
	
	
	@RequestMapping("/save")
	public String save(int pid, int [] qid,int [] score,HttpSession session) throws DoNotRepeatRateException{
		try {
			Paper p=pservice.find(pid);
			for (int i = 0; i < qid.length; i++) {
				Score s=new Score();
				s.setPaper(p);
				s.setQuestion(qservice.find(qid[i]));
				s.setScore(score[i]);
				s.setUser((User) session.getAttribute("user"));
				service.save(s);
			}
			
		} catch (Exception e) {
			throw new DoNotRepeatRateException("已经评价过了！");
	}
		
		return "redirect:/front/index.jsp";
		
	} 
	
	@RequestMapping("/showScore")
	public String ShowScore(int pid,HttpServletRequest request){
		Paper p=pservice.find(pid);
		//根据问卷获取该问卷下所有问题
		List list1=new ArrayList(p.getQuestions());
		request.setAttribute("list1", list1);
		
		//根据问卷得到问卷所有分数
		Map map=new HashMap();
		List list2=new ArrayList(p.getScores());
		for (int i = 0; i < list2.size(); i++) {
			Score s=(Score) list2.get(i);
			
			String realname=s.getUser().getRealname();
			if(map.containsKey(realname)){
				List aa=(List) map.get(realname);
				aa.add(s.getScore());
				map.put(realname, aa);
			}
			else{
				List aa=new ArrayList();
				aa.add(s.getScore());
				map.put(realname, aa);
			map.put(p.getUser().getRealname(), s.getScore());
		}
	}
		
		request.setAttribute("map", map);
		return "front/seeScore";
	}
	
	

}
