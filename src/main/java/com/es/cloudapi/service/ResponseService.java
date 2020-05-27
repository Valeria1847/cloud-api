package com.es.cloudapi.service;

import com.es.cloudapi.entity.Response;
import com.es.cloudapi.repository.PersonRepo;
import com.es.cloudapi.repository.ResponseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResponseService {

    @Autowired
    private ResponseRepo responseRepo;
    @Autowired
    private PersonRepo personRepo;

    public Collection<Response> findAllByPerson(Integer idPerson) {
        return responseRepo.findAllByPerson(idPerson);
    }

    public Response findOneByIdAndPerson(Integer id, Integer idPerson) {
        return responseRepo.findOneByIdAndPerson(id, idPerson);
    }

    public void update(Integer id, Integer idPerson, boolean active, String type, String url, int code, String body) {
        Response r = new Response();
        if (id != null) {
            r = responseRepo.findOneByIdAndPerson(id, idPerson);
            if(r == null) {
                throw  new RuntimeException("Запрос с id="+id+" не найден");
            }
        } else {
            r.setPerson(personRepo.findOne(idPerson));
        }
        r.setActive(active);
        r.setType(type);
        r.setUrl(url);
        r.setCode(code);
        r.setBody(body);
        responseRepo.saveAndFlush(r);
    }

    public void delete(Integer id, Integer idPerson) {
        responseRepo.deleteByIdAndPersonId(id, idPerson);
    }
}
