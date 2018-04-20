package ru.saleman;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.saleman.data.CredentialsRepository;
import ru.saleman.data.RoleRepository;
import ru.saleman.data.dta.CredentialsDto;
import ru.saleman.data.dta.RoleDto;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalemanApplicationTests {

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Test
	@Transactional
	public void contextLoads() {
		CredentialsDto cs = new CredentialsDto();
		cs.setPassword("ivan");
		cs.setUsername("ivan");
		RoleDto role = new RoleDto();
		role.setName("admin");
		cs.setRole(role);
		roleRepository.save(role);
		credentialsRepository.save(cs);
	}

}
