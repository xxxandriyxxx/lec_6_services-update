package owu2018.lec_6_servicesupdate.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import owu2018.lec_6_servicesupdate.models.Contact;
import owu2018.lec_6_servicesupdate.models.Phone;
import owu2018.lec_6_servicesupdate.services.ContactService;
import owu2018.lec_6_servicesupdate.services.PhoneService;

@Controller
@AllArgsConstructor
public class HomeController {
    private ContactService contactService;
    private PhoneService phoneService;

   @GetMapping("/")
   public String home(Model model){
       model.addAttribute("contacts",contactService.findAll());
       return "home";
   }

   @PostMapping("/saveContact")
   public String saveContact(Contact contact, @RequestParam("phoneList") String num){
       contactService.save(contact);

       Phone phone = new Phone(num);
       phone.setContact(contact);
       phoneService.save(phone);

       return "redirect:/";
   }

   @GetMapping("/details-{xxx}")
   public String contactDetails(@PathVariable("xxx") int id, Model model){
       Contact one = contactService.getOne(id);
       model.addAttribute("contact",one);
       return "contactDetails";
   }

    @PostMapping("/update")
    public String updateContact(Contact contact){
       contactService.save(contact);
        return "redirect:/";
    }

}
