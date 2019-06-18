package com.es.cloudapi.service.security.impl;

import com.es.cloudapi.entity.access.Person;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.service.security.SecurityPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepo.findOneByLoginAndActive(username, true);
        if (person == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        if (person.isBlockedPassword()) {
            throw new UsernameNotFoundException("Пользователь заблокирован");
        }
        if (person.isBlockedAdmin()) {
            throw new UsernameNotFoundException("Пользователь заблокирован администратором");
        }
        return new SecurityPerson(
            person.getId(),
            person.isActive(),
            person.getLogin(),
            person.getEmail(),
            person.getName(),
            person.getSurname(),
            person.getPatronymic(),
            person.getPasswordHash(),
            person.getIncorrectLoginCount(),
            person.isBlockedPassword(),
            person.isBlockedAdmin(),
            AuthorityUtils.createAuthorityList("USER")
        );
    }

}
