package com.component;

import com.repository.UserRepository;
import com.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;


@Component
@Transactional
public class LoadUsersinDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	public PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {

		if (userRepository.count() > 0) {
			return;
		}
		User user1 = new User("geoO", UUID.randomUUID().toString(), "Georgina", "Ortega", 24, "Brazil");
		User user2 = new User("rosS", UUID.randomUUID().toString(), "Ross", "Spark", 34, "Mexio");
		User user3 = new User("oriM", UUID.randomUUID().toString(), "Oria", "Mocoy", 19, "USA");
		User user4 = new User("jerH", UUID.randomUUID().toString(), "Jerry", "Hanna", 42, "Canada");
		User user5 = new User("allB", UUID.randomUUID().toString(), "Alli", "Bean", 23, "USA");
		User user6 = new User("jayL", UUID.randomUUID().toString(), "Jay", "Lee", 18, "USA");
		User user7 = new User("jimW", UUID.randomUUID().toString(), "Jim", "Willman", 50, "USA");
		User user8 = new User("katP", UUID.randomUUID().toString(), "Katy", "Pery", 36, "Canada");
		User user9 = new User("nibO", UUID.randomUUID().toString(), "Nibongu", "Otsama", 24, "Japan");
		User user10 = new User("junK", UUID.randomUUID().toString(), "Jun", "Kim", 34, "Korea");

		List<User> userList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		
		userList = userList.stream().map(user -> {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return user;
		}).collect(Collectors.toList());

		userRepository.saveAll(userList);
	}
}
