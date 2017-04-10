package me.krstic.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.krstic.model.Counter;
import me.krstic.repository.CounterRepository;

@Service
public class CounterService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(CounterService.class);
	
	@Autowired
	private CounterRepository counterRepository;
	
	public CounterService() {
	}
	
	@Transactional
	public int generateSequenceNumber(String name) {
		Counter counter = counterRepository.findOneByName(name);
		int value = 0;
		
		if (counter == null) {
			counter = new Counter(name);
			value = 0;
		}
		value = counter.getValue();
		counter.setValue(++value);
		
		return counterRepository.save(counter).getValue();
	}
	
	public int getSequenceNumber(String name) {
		if (counterRepository.findOneByName(name) == null) {
			return 1;
		} else {
			return counterRepository.findOneByName(name).getValue() + 1;
		}
	}
	
}
