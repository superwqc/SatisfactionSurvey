package satisfactionSurvey.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Paper entity. @author MyEclipse Persistence Tools
 */

public class Paper implements java.io.Serializable {

	// Fields

	private Integer pid;
	private User user;
	private String title;
	private Date pubdate;
	private Integer status;
	private Set scores = new HashSet(0);
	private Set questions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Paper() {
	}

	/** full constructor */
	public Paper(User user, String title, Date pubdate, Integer status,
			Set scores, Set questions) {
		this.user = user;
		this.title = title;
		this.pubdate = pubdate;
		this.status = status;
		this.scores = scores;
		this.questions = questions;
	}

	// Property accessors

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}