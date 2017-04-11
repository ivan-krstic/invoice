package me.krstic.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import me.krstic.model.Invoice;
import me.krstic.utility.XsltTransformer;

@Service
public class XmlService extends XsltTransformer {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(XmlService.class);
	
	@Value(value = "classpath:xslt/invoice.xslt")
	private Resource invoiceResource;
	
	public XmlService() {
	}
	
	public String createInvoiceXml(Invoice invoice) {
		try {
			String xml, xslt, transformationResult;
			
			xml = marshalObjectToXml(invoice);
			xslt =  new BufferedReader(new InputStreamReader(invoiceResource.getInputStream())).lines().collect(Collectors.joining("\n"));
			
			transformationResult = this.processTemplate(xml, xslt);
			
			return transformationResult;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
