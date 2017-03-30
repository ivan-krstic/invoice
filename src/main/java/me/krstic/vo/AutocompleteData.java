package me.krstic.vo;

public class AutocompleteData {

	private String value;
	private String data;
	
	public AutocompleteData(String value, String data) {
		this.value = value;
		this.data = data;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "\"AutocompleteData\": {\n\t\"value\": \"" + value + "\",\n\t\"data\": \"" + data + "\"\n}";
	}
}
