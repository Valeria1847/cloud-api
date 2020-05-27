package com.es.cloudapi.repository;

import com.es.cloudapi.entity.Response;
import com.es.cloudapi.entity.access.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface ResponseRepo extends JpaRepository<Response, Integer> {

    @Query (
        "  select e " +
        "    from Response e " +
        "   where e.person.id = :idPerson"
    )
    Collection<Response> findAllByPerson(@Param("idPerson") Integer idPerson);

    @Query (
        "  select e " +
        "    from Response e " +
        "   where e.id = :id " +
        "     and e.person.id = :idPerson"
    )
    Response findOneByIdAndPerson(@Param("id") Integer id, @Param("idPerson") Integer idPerson);

    @Query(
        "  delete from Response e " +
        "   where e.id = :id " +
        "     and e.person.id = :idPerson"
    )
    @Modifying
    @Transactional
    void deleteByIdAndPersonId(@Param("id") Integer id, @Param("idPerson") Integer idPerson);
}
