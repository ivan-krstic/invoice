package me.krstic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import me.krstic.model.User;
import me.krstic.repository.UserRepository;
import me.krstic.specification.UserSearchSpecification;
import me.krstic.vo.UserSearchForm;

@Service
public class UserService {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

	public UserService() {
	}
	
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	
	public List<User> findAllActive(int page, int size) {
		return userRepository.findAllByStatus(1);
	}
	
	public User findById(int id) {
		return userRepository.findOne(id);
	}
	
	public User findByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}
	
	public List<User> findBySearchForm(UserSearchForm userSearchForm) {
		return userRepository.findAll(Specifications.where(UserSearchSpecification.hasName(userSearchForm.getName()))
				.and(UserSearchSpecification.hasUsername(userSearchForm.getUsername())));
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void delete(int id) {
		User user = findById(id);
		user.setStatus(0);
		
		save(user);
	}
}
