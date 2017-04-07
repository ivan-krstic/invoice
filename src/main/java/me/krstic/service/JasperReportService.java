package me.krstic.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class JasperReportService {
	
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(JasperReportService.class);
	
	@Autowired
	private DataSource datasource;
	
	@Value(value = "classpath:jasper/reports/invoice.jrxml")
	private Resource invoiceJrxml;
	@Value(value = "classpath:jasper/reports/invoice.jasper")
	private Resource invoiceJasper;
	@Value(value = "classpath:jasper/images/logo-template.jpg")
	private Resource jasperLogo;
	
	public JasperReport getFile() throws IOException, JRException {
		File invoiceJrxmlFile = invoiceJrxml.getFile();
		File invoiceJasperFile = invoiceJasper.getFile();

		JasperCompileManager.compileReportToFile(
				invoiceJrxmlFile.getPath(),
				invoiceJasperFile.getPath());
		
		return (JasperReport) JRLoader.loadObjectFromFile(invoiceJasperFile.getPath());
	}
	
	public void generateInvoicePDF(HttpServletResponse response, Map<String, Object> parameters, JasperReport jasperReport)throws JRException, NamingException, SQLException, IOException {		
		byte[] bytes = null;
		parameters.put("logo", jasperLogo.getInputStream());
		bytes = JasperRunManager.runReportToPdf(jasperReport, parameters, datasource.getConnection());
		response.reset();
		response.resetBuffer();
		response.setContentType("application/pdf");
		response.setContentLength(bytes.length);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(bytes, 0, bytes.length);
		ouputStream.flush();
		ouputStream.close();
	} 
	
	
}
