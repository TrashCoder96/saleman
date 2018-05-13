package ru.saleman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.saleman.data.CredentialsRepository;
import ru.saleman.data.RoleRepository;
import ru.saleman.data.dta.CredentialsDto;
import ru.saleman.data.dta.RoleDto;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@SpringBootApplication
public class SalemanApplication {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	@Transactional
	public void post() {
		CredentialsDto cs = new CredentialsDto();
		cs.setPassword("ivan");
		cs.setUsername("ivan");
		cs.setRole(roleRepository.findById("USER_ROLE").get());
		credentialsRepository.save(cs);
	}

	public static void main(String[] args) {
		SpringApplication.run(SalemanApplication.class, args);
	}
}
