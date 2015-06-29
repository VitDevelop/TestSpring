package com.vitdevelop.learn.core.service;

import com.vitdevelop.learn.core.domain.Client;
import com.vitdevelop.learn.core.repository.MysqlClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@Service
public class MysqlClientService implements ClientService {
    @Autowired
    private MysqlClientRepository clientRepository;

    @Override
    public Long countByLastName(String lastname){
        return clientRepository.countByLastName(lastname);
    }

    @Override
    public Long deleteByLastName(String lastname){
        return clientRepository.deleteByLastName(lastname);
    }
    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public void delete(Long id){
        clientRepository.delete(id);
    }
    @Override
    public List<Client> removeByLastName(String lastname){
        return clientRepository.removeByLastName(lastname);
    }
    @Override
    public Page<Client> findByLastName(String lastname, Pageable pageable){
        return clientRepository.findByLastName(lastname, pageable);
    }

}
