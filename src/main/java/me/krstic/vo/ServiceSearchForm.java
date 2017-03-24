package me.krstic.vo;

public class ServiceSearchForm {

	private String name;
	
	public ServiceSearchForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\"ServiceSearchForm\": {\n\t\"name\": \"" + name + "\"\n}";
	}
}
