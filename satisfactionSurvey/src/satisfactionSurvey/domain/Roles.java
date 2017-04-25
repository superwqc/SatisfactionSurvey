package satisfactionSurvey.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Roles entity. @author MyEclipse Persistence Tools
 */

public class Roles implements java.io.Serializable {

	// Fields

	private Integer rid;
	private String rname;
	private Set users = new HashSet(0);
	private Set questions = new HashSet(0);

	// Constructors

	/** default constructor */
	public Roles() {
	}

	/** full constructor */
	public Roles(String rname, Set users, Set questions) {
		this.rname = rname;
		this.users = users;
		this.questions = questions;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set questions) {
		this.questions = questions;
	}

}