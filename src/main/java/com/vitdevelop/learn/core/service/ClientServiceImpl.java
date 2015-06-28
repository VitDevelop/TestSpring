package com.vitdevelop.learn.core.service;

import com.vitdevelop.learn.core.domain.Client;
import com.vitdevelop.learn.core.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

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
    public List<Client> findByLastName(String lastname){
        return clientRepository.findByLastName(lastname);
    }
}
