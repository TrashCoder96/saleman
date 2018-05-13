package ru.saleman.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.saleman.data.dta.RoleDto;

/**
 * Created by Ivan Timofeev on 21.04.2018.
 */
@Repository
public interface RoleRepository extends JpaRepository<RoleDto, String> {
}
