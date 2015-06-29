package com.vitdevelop.learn.core.repository;

import com.vitdevelop.learn.core.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@Repository
public interface MysqlClientRepository extends ClientRepository {
    @Transactional
    @Override
    Long deleteByLastName(String lastname);
    @Transactional
    @Override
    List<Client> removeByLastName(String lastname);

    @Override
    Page<Client> findByLastName(String lastname, Pageable pageable);

}
