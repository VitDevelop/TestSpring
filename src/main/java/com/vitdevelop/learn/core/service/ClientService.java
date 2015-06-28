package com.vitdevelop.learn.core.service;

import com.vitdevelop.learn.core.domain.Client;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */

public interface ClientService {
    Long countByLastName(String lastname);
    Long deleteByLastName(String lastname);
//    public List<Client> removeByLastName(String lastname);
    List<Client> findAll();
    void delete(Long id);
    List<Client> removeByLastName(String lastname);
}
