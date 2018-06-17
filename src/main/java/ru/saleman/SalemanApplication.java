package ru.saleman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.saleman.data.CredentialsRepository;
import ru.saleman.data.MicrosystemRepository;
import ru.saleman.data.RoleRepository;
import ru.saleman.data.dto.CredentialsDto;
import ru.saleman.data.dto.MicrosystemDto;
import ru.saleman.util.SalemanConstants;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

@SpringBootApplication
public class SalemanApplication {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MicrosystemRepository microsystemRepository;

	@PostConstruct
	@Transactional
	public void post() {
		MicrosystemDto microsystemDto = new MicrosystemDto();
		microsystemDto.setName("ivan_company");
		microsystemRepository.save(microsystemDto);

		CredentialsDto cs = new CredentialsDto();
		cs.setPassword("ivan");
		cs.setUsername("ivan");
		cs.setRole(roleRepository.findById(SalemanConstants.Role.USER).get());
		cs.setMicrosystem(microsystemDto);
		cs.setAdmin(true);
		credentialsRepository.save(cs);
	}

	public static void main(String[] args) {
		SpringApplication.run(SalemanApplication.class, args);
	}
}
