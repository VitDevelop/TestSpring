package com.vitdevelop.learn.core.repository;

import com.vitdevelop.learn.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vitaly on 6/28/15.
 */
public interface ClientRepository extends JpaRepository<Client,Long>{
}
