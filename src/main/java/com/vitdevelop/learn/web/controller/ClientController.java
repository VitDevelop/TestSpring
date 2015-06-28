package com.vitdevelop.learn.web.controller;

import com.vitdevelop.learn.core.domain.Client;
import com.vitdevelop.learn.core.service.MysqlClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@RestController
@RequestMapping(value = "/api/v0.0.1/client")
public class ClientController {
    @Autowired
    private MysqlClientService clientService;

    @RequestMapping
    public List<Client> getAll(){
        return clientService.findAll();
    }
    @RequestMapping("/count/{lastName}")
    public Long countByLastName(@PathVariable("lastName") String lastName){
       return clientService.countByLastName(lastName);
    }
    @RequestMapping(value = "/delete/{lastName}",method = RequestMethod.DELETE)
    public Long deleteByLastName(@PathVariable("lastName")String lastName){
        return clientService.deleteByLastName(lastName);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id")Long id){
        clientService.delete(id);
    }
    @RequestMapping(value = "/remove/{lastName}",method = RequestMethod.DELETE)
    public List<Client> removeByLastName(@PathVariable("lastName")String lastName){
        return clientService.removeByLastName(lastName);
    }
    @RequestMapping(value = "/find/{lastName}",method = RequestMethod.GET)
    public List<Client> findByLastName(@PathVariable("lastName")String lastName){
        return clientService.findByLastName(lastName);
    }

}
