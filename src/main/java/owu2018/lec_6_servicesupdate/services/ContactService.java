package owu2018.lec_6_servicesupdate.services;


import org.springframework.stereotype.Service;
import owu2018.lec_6_servicesupdate.dao.ContactDAO;
import owu2018.lec_6_servicesupdate.models.Contact;

import java.util.List;

@Service
public class ContactService {

    private ContactDAO contactDAO;

    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public void save(Contact contact){
        if (contact != null){
            contactDAO.save(contact);
        }
    }

    public List<Contact> findAll() {
        return contactDAO.findAll();
    }

    public List<Contact> findAllByName(String name){
        if (!name.isEmpty()){
            return contactDAO.findAllByName(name);
        }
        return null;
    }

    public Contact getOne(int id){
        return contactDAO.getOne(id);
    }
}
