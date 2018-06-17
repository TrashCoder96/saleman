package ru.saleman.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.saleman.data.dto.MicrosystemDto;

/**
 * Created by itimofeev on 12.06.2018.
 */
@Repository
public interface MicrosystemRepository extends JpaRepository<MicrosystemDto, Long> {

    @Query("SELECT md FROM MicrosystemDto md WHERE md.admin.id = :credentialsId")
    MicrosystemDto getMicrosystemByAdminCredentialsId(@Param("credentialsId") Long credentialsId);

}
