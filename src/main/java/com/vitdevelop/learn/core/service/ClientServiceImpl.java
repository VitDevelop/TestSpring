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
@Transactional(readOnly = true)
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepositoryImpl clientRepository;

    @Transactional
    public Long countByLastName(String lastname){
        return clientRepository.countByLastName(lastname);
    }

    @Transactional(readOnly = false)
    public int deleteByLastName(String lastname){
        return clientRepository.deleteByLastName(lastname);
    }

    @Transactional
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void delete(Long id){
        clientRepository.delete(id);
    }

    @Transactional(readOnly = false)
    public List<Client> removeByLastName(String lastname){
        return clientRepository.removeByLastName(lastname);
    }

    @Transactional
    public Page<Client> findByLastName(String lastname, Pageable pageable){
        return clientRepository.findByLastName(lastname, pageable);
    }

    @Transactional
    public Client findFirst(){
        return clientRepository.findFirstByOrderByLastNameAsc();
    }

    @Transactional
    public List<Client> findByLastName(String lastname){
        return clientRepository.findByLastName(lastname);
    }

    @Transactional
    public List<Client> findByFirstNameOrLastName(String firstname, String lastname){
        return clientRepository.findByFirstNameOrLastName(firstname,lastname);
    }
}
