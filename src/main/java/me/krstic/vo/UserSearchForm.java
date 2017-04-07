package me.krstic.vo;

public class UserSearchForm {
	
	private String name;
	private String username;

	public UserSearchForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "\"UserSearchForm\": {\n\t\"name\": \"" + name + "\",\n\t\"username\": \"" + username + "\"\n}";
	}
}
