package ru.saleman.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.saleman.data.dto.MicrosystemDto;

/**
 * Created by itimofeev on 12.06.2018.
 */
@Repository
public interface MicrosystemRepository extends JpaRepository<MicrosystemDto, Long> {

    @Query("SELECT md FROM MicrosystemDto cd WHERE cd.admin.id = :credentialsId")
    MicrosystemDto getMicrosystemByAdminCredentialsId(String credentialsId);

}
