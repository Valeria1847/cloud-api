package com.es.cloudapi.repository;

import com.es.cloudapi.entity.access.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {

    Person findOneByLoginAndActive(String login, boolean active);
}
