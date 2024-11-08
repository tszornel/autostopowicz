package pl.com.autostopowicz.authentication;

import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.User;

public class AutoUserDetails implements UserDetails {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final long serialVersionUID = 1L;

	private User user;

	private GrantedAuthority[] roles;

	public AutoUserDetails(User user) {
		this.user = user;

		roles = new GrantedAuthority[1];

		switch (user.getRole()) {
		case DatabaseManager.ROLE_USER:
			roles[0] = new GrantedAuthorityImpl("ROLE_USER");
			break;
		
		case DatabaseManager.ROLE_ADMIN:
			roles[0] = new GrantedAuthorityImpl("ROLE_ADMIN");
			break;

		default:
			break;
		}

	}

	public GrantedAuthority[] getAuthorities() {

		return roles;

	}

	public String getPassword() {
		return user.getPassword();
	}


	public String getLogin() {
		return user.getLogin();
	}

	public String getName() {
		return user.getName();
	}

	public void setPassword(String pwd) {
		user.setPassword(pwd);
	}

	public void setName(String name) {
		user.setName(name);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public int getUserId() {
		return user.getIdUser().intValue();
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	

	
	public String getUsername() {
		
		return user.getName();
	}
}
