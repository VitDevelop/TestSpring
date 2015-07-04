package com.vitdevelop.learn.core.service;

import com.vitdevelop.learn.core.domain.Client;
import com.vitdevelop.learn.core.repository.ClientRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepositoryImpl clientRepository;
    @Transactional
    public Long countByLastName(String lastname){
        return clientRepository.countByLastName(lastname);
    }
    @Transactional
    public Long deleteByLastName(String lastname){
        return clientRepository.deleteByLastName(lastname);
    }
    @Transactional
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public void delete(Long id){
        clientRepository.delete(id);
    }
    public List<Client> removeByLastName(String lastname){
        return clientRepository.removeByLastName(lastname);
    }
    public Page<Client> findByLastName(String lastname, Pageable pageable){
        return clientRepository.findByLastName(lastname, pageable);
    }
    public Client findFirst(){
        return clientRepository.findFirstByOrderByLastNameAsc();
    }

}
