package me.krstic.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import me.krstic.model.Invoice;
import me.krstic.model.InvoiceCounter;
import me.krstic.model.InvoiceItem;
import me.krstic.repository.InvoiceRepository;
import me.krstic.specification.InvoiceSearchSpecification;
import me.krstic.vo.InvoiceCreateForm;
import me.krstic.vo.InvoiceSearchForm;

@Service
public class InvoiceService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private UserService userService;
	
	public InvoiceService() {
	}
	
	public List<Invoice> findAll() {
		return (List<Invoice>) invoiceRepository.findAll();
	}
	
	public Page<Invoice> findAll(int page, int size) {
		return invoiceRepository.findAll(new PageRequest(page, size, Direction.DESC, "invoiceDate"));
	}
	
	public Invoice findById(int id) {
		return invoiceRepository.findOne(id);
	}
	
	public List<Invoice> findBySearchForm(InvoiceSearchForm invoiceSearchForm) {
		return invoiceRepository.findAll(Specifications.where(InvoiceSearchSpecification.hasClientName(invoiceSearchForm.getClientName()))
				.and(InvoiceSearchSpecification.hasInvoiceDateFrom(invoiceSearchForm.getInvoiceDateFrom()))
				.and(InvoiceSearchSpecification.hasInvoiceDateTo(invoiceSearchForm.getInvoiceDateTo()))
				.and(InvoiceSearchSpecification.hasStatus(invoiceSearchForm.getStatus())));
	}
	
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public void createOrUpdate(InvoiceCreateForm invoiceCreateForm) {
		List<Integer> serviceIds = invoiceCreateForm.getInputServiceId();
		List<Double> quantites = invoiceCreateForm.getInputQuantity();
		
		String invoiceNumber = InvoiceCounter.getInstance().create()+"/"+Integer.parseInt(new SimpleDateFormat("yyyy").format(invoiceCreateForm.getInvoiceDate()));
		
		log.info("Invoice Number: " + invoiceNumber);
		
		if (serviceIds != null && serviceIds.size() > 0 && quantites != null && quantites.size() > 0) {
			Invoice invoice = new Invoice(
					invoiceNumber,
					clientService.findById(invoiceCreateForm.getClientId()),
					invoiceCreateForm.getInvoiceDate(),
					userService.findByUsername(invoiceCreateForm.getModifiedBy()));
			
			List<InvoiceItem> invoiceItems = new ArrayList<>();
			Double total = 0d;
			
			for (int i = 0; i < serviceIds.size(); i++) {
				me.krstic.model.Service service = serviceService.findById(serviceIds.get(i));
				
				InvoiceItem invoiceItem = new InvoiceItem();
				invoiceItem.setService(service);
				invoiceItem.setQuantity(quantites.get(i));
				invoiceItem.setInvoice(invoice);
				total += quantites.get(i) * service.getPrice();
				
				invoiceItems.add(invoiceItem);
			}
			invoice.setInvoiceItems(invoiceItems);
			invoice.setTotal(total);
			invoice = invoiceService.save(invoice);
		}
	}
}
