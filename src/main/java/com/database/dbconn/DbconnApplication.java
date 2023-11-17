package com.database.dbconn;

import com.database.dbconn.dao.UserRepository;
import com.database.dbconn.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DbconnApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(DbconnApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		System.out.println("started");

//		User user = new User();
//		user.setName("Abhishek");
//		user.setCity("Ram Garh");
//		user.setState("Jharkhand");
//		user.setCountry("India");
//		User user1 = userRepository.save(user);
//		System.out.println(user1);

//		System.out.println(userRepository.findByName("Prachi"));;

	}
}
