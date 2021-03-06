package owu2018.lec_6_servicesupdate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import owu2018.lec_6_servicesupdate.models.Contact;

import java.util.List;

public interface ContactDAO extends JpaRepository<Contact,Integer> {

    List<Contact> findAllByName(String name);



    @Query("select c from Contact c where c.email=:xxx")
    Contact customasdqweByEmail(@Param("xxx") String email);
}
