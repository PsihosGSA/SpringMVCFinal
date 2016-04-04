package ua.org.oa.gavrishs.DTO;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public class MyUserDetails {

	private String login;
	private String password;
	private List<GrantedAuthority> list;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<GrantedAuthority> getList() {
		return list;
	}

	public void setList(List<GrantedAuthority> list) {
		this.list = list;
	}

	public MyUserDetails(String login, String password, List<GrantedAuthority> list) {
		super();
		this.login = login;
		this.password = password;
		this.list = list;
	}

}
