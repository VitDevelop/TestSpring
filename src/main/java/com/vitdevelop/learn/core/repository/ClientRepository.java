package com.vitdevelop.learn.core.repository;

import com.vitdevelop.learn.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
public interface ClientRepository extends JpaRepository<Client,Long>{
    Long countByLastName(String lastname);
    Long deleteByLastName(String lastname);
    List<Client> removeByLastName(String lastname);
    List<Client> findByLastName(String lastname);
}
