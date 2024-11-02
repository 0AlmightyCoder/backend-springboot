package com.spring.data_jpa;

//import com.spring.data_jpa.service.Impl.SaveUserToDatabase;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiDevelopmentApplication implements CommandLineRunner {

	@Autowired
//	private SaveUserToDatabase saveUser;
	public static void main(String[] args) {
		SpringApplication.run(ApiDevelopmentApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
//		saveUser.storeUserInfo();
	}
}
