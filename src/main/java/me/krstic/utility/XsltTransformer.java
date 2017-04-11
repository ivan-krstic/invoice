package me.krstic.utility;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import me.krstic.exception.XsltTransformationException;
import me.krstic.model.Invoice;

public class XsltTransformer {
	
	final static Logger log = Logger.getLogger(XsltTransformer.class);
	
	Source xmlSource;
	Source xsltSource;
	Result result;
	TransformerFactory transformerFactory;

	/**
	 * Method used for transforming the XML data received by marshaling Java POJO through XSLT into
	 * expected target XML format to be sent to Core banking system.
	 * 
	 * @param xml Marshaled Client POJO
	 * @param xslt Transformation script for producing target XML
	 * @return Result of processing (target XML)
	 */
	protected String processTemplate(String xml, String xslt) {
		StringWriter targetContent = new StringWriter();
		
		log.debug("START - XML transformation");
		log.debug(xml);
		log.debug(xslt);
		
		xmlSource = new StreamSource(new StringReader(xml));
		log.info("xmlSource: " + xmlSource);
		
		xsltSource = new StreamSource(new StringReader(xslt));
		log.info("xsltSource: " + xsltSource);
		
		result = new StreamResult(targetContent);
		log.info("result: " + result);
		
		transformerFactory = new net.sf.saxon.TransformerFactoryImpl();
		
		Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer(xsltSource);
			transformer.transform(xmlSource, result);
		} catch (TransformerConfigurationException e) {
			log.error(e.getMessage(), new XsltTransformationException());
		} catch (TransformerException e) {
			log.error(e.getMessage(), new XsltTransformationException());
		}		
		
		log.debug(result);		
		log.debug("END - XML transformation");
		
		return targetContent.toString();
	}
	
	public String marshalObjectToXml(Object object) {
		Marshaller marshaller;
		StringWriter stringWriter = new StringWriter();
		
		try {
			marshaller = JAXBContext.newInstance(object instanceof Invoice ? Invoice.class : null).createMarshaller();
			marshaller.marshal(object, stringWriter);
		} catch (JAXBException e) {
			e.printStackTrace();
			return null;
		}
		
    	return stringWriter.toString();
	}
}
