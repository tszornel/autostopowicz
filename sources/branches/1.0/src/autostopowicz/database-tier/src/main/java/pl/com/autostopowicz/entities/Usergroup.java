package pl.com.autostopowicz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usergroup implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2024162540194765324L;
	private UsergroupId id;
	private User user;
	private Group group;
	private boolean owner;

	public Usergroup() {
	}

	public Usergroup(UsergroupId id, User user, Group group, boolean owner) {
		this.id = id;
		this.user = user;
		this.group = group;
		this.owner = owner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UsergroupId getId() {
		return this.id;
	}

	public void setId(UsergroupId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public boolean isOwner() {
		return this.owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

}
