package com.vitdevelop.learn.core.repository;

import com.vitdevelop.learn.core.domain.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface ClientRepositoryImpl extends ClientRepository {
    @Query("select c from Client c where c.lastName = ?1")
    List<Client> findByLastName(String lastname);

    @Query("select c from Client c where c.firstName = :firstname or c.lastName = :lastname")
    List<Client> findByFirstNameOrLastName(@Param("firstname")String firstname,
                                         @Param("lastname")String lastname);

    Long countByLastName(String lastname);

    @Modifying
    @Query("delete from Client c where c.lastName = :lastname")
    int deleteByLastName(@Param("lastname")String lastname);
//
//    @Modifying
//    @Query("delete from Client c where c.lastName = :lastname")
//    int deleteByLastName(@Param("lastname")String lastname);


    List<Client> removeByLastName(String lastname);

    Page<Client> findByLastName(String lastname, Pageable pageable);

    Client findFirstByOrderByLastNameAsc();

}
