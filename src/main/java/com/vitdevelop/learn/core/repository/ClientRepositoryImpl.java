package com.vitdevelop.learn.core.repository;

import com.vitdevelop.learn.core.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@Repository
public interface ClientRepositoryImpl extends ClientRepository {
    Long countByLastName(String lastname);
    Long deleteByLastName(String lastname);
    List<Client> removeByLastName(String lastname);
    Page<Client> findByLastName(String lastname, Pageable pageable);

    Client findFirstByOrderByLastNameAsc();

}
