package com.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.model.User;
import com.service.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public static List<User> userList = new ArrayList<>();
	private static Long COUNTER = 1l;
	static {
		User user = new User(COUNTER++, "Georgina", "Ortega", 24, "Brazil");
		userList.add(user);
		user = new User(COUNTER++, "Ross", "Spark", 34, "Mexio");
		userList.add(user);
		user = new User(COUNTER++, "Oria", "Mocoy", 19, "USA");
		userList.add(user);
		user = new User(COUNTER++, "Jerry", "Hanna", 42, "Canada");
		userList.add(user);
	}
	@Override
	public List<User> findAll() {
		// System.out.print(userList);
		return userList.stream()
			.sorted(Comparator.comparing(User::getId))
			.collect(Collectors.toList());
	}
	
	@Override
	public Optional<User> findById(Long id) {
		return userList.stream().filter(user -> user.getId() == id).findFirst();
	}

	@Override
	public void add(User user) {
		user.setId(COUNTER++);
		userList.add(user);
	}

	@Override
	public Optional<User> update(User user) {
		Optional<User> userOpt = userList.stream().filter(u -> u.getId() == user.getId()).findFirst();
		if (userOpt.isPresent()) {
			User existingUser = userOpt.get();
			if (user.getFirstName() != null) {
				existingUser.setFirstName(user.getFirstName());
			}

			if (user.getLastName() != null) {
				existingUser.setLastName(user.getLastName());
			}

			if (user.getAge() != null) {
				existingUser.setAge(user.getAge());
			}

			if (user.getCountry() != null) {
				existingUser.setCountry(user.getCountry());
			}

			userList = userList.stream().filter(u -> u.getId() != existingUser.getId())
				.collect(Collectors.toList());
			userList.add(existingUser);

			return Optional.of(existingUser);
		}
		return Optional.empty();
	}

	@Override
	public Optional<User> delete(Long id) {
		Optional<User> userOpt = userList.stream().filter(user -> user.getId() == id).findFirst();
		if (userOpt.isPresent()) {
			userList = userList.stream().filter(user -> userOpt.get().getId() != user.getId())
				.collect(Collectors.toList());
			return userOpt;
		}
		return Optional.empty();
	}
}
