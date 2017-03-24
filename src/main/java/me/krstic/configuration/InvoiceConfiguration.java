package me.krstic.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "invoice", ignoreUnknownFields = false)
public class InvoiceConfiguration {

	private int maxSize;
	
	public InvoiceConfiguration() {
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public String toString() {
		return "\"InvoiceConfiguration\": {\n\t\"maxSize\": \"" + maxSize + "\"\n}";
	}
}
