package pl.com.autostopowicz.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usercar implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5134782757968070396L;
	/**
	 * 
	 */

	private UsercarId id;
	private User user;
	private Car car;
	private boolean owner;

	public Usercar() {
	}

	public Usercar(UsercarId id, User user, Car car, boolean owner) {
		this.id = id;
		this.user = user;
		this.car = car;
		this.owner = owner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public UsercarId getId() {
		return this.id;
	}

	public void setId(UsercarId id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isOwner() {
		return this.owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

}
