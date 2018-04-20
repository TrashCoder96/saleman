package ru.saleman.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.saleman.data.dta.CredentialsDto;

/**
 * Created by asus-pc on 20.04.2018.
 */
@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsDto, String> {
}
