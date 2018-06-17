package ru.saleman.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.saleman.data.dto.CredentialsDto;

/**
 * Created by Ivan Timofeev on 20.04.2018.
 */
@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsDto, Long> {

    @Query("SELECT cd FROM CredentialsDto cd WHERE cd.username = :username")
    CredentialsDto findCredentialsDtoByUsername(@Param("username") String username);

}
