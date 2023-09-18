package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByName(String name);

}
