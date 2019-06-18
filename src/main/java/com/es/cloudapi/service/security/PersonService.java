package com.es.cloudapi.service.security;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public Person register(String username, String surname, String login, String email, String password) {
        Person p = new Person();
        p.setActive(true);
        p.setLogin(login);
        p.setName(username);
        p.setSurname(surname);
        p.setPasswordHash(passwordEncoder.encode(password));
        p.setEmail(email);
        return personRepo.saveAndFlush(p);
    }

    public void recovery(String username, String email) {
    }
}
