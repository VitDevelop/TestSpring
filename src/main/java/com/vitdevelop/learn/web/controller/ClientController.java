package com.vitdevelop.learn.web.controller;

import com.vitdevelop.learn.core.domain.Client;
import com.vitdevelop.learn.core.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vitaly on 6/28/15.
 */
@RestController
@RequestMapping(value = "/api/v0.0.1/client")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

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
    @Transactional
    @RequestMapping(value = "/remove/{lastName}",method = RequestMethod.DELETE)
    public List<Client> removeByLastName(@PathVariable("lastName")String lastName){
        return clientService.removeByLastName(lastName);
    }
    @RequestMapping(value = "/find/{lastName}",method = RequestMethod.GET)
    public Page<Client> findByLastName(@PathVariable("lastName")String lastName,
                                       @RequestParam("page") int page,
                                       @RequestParam("size") int size,
                                       @RequestParam("sort") Sort.Direction direction,
                                       @RequestParam("sortField") String sortfield){
        return clientService.findByLastName(lastName, new PageRequest(page, size, direction, sortfield));
    }

    @RequestMapping(value = "/findFirst")
    public Client findFirst(){
        return clientService.findFirst();
    }

}
