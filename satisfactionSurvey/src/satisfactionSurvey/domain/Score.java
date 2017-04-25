package satisfactionSurvey.domain;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */

public class Score implements java.io.Serializable {

	// Fields

	private Integer sid;
	private Paper paper;
	private User user;
	private Question question;
	private Integer score;

	// Constructors

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(Paper paper, User user, Question question, Integer score) {
		this.paper = paper;
		this.user = user;
		this.question = question;
		this.score = score;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}