package owu2018.lec_6_servicesupdate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import owu2018.lec_6_servicesupdate.models.Phone;

public interface PhoneDAO extends JpaRepository<Phone,Integer> {
}
