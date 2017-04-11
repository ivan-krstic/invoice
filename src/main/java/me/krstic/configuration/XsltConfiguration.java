package me.krstic.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "xslt", ignoreUnknownFields = false)
public class XsltConfiguration {

	private String invoice;
	
	public XsltConfiguration() {
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "\"XsltConfiguration\": {\n\t\"invoice\": \"" + invoice + "\"\n}";
	}
}
