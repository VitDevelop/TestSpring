package com.vitdevelop.learn.web.controller;

import com.vitdevelop.learn.core.domain.Pets;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by CIC on 12.06.2015.
 */
@RestController
public class Controller {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        Date data = new Date();
        System.out.println(data);

        return "Welcome to index!";
    }


    @RequestMapping(value = "/pets", method = RequestMethod.POST)
    public List<Pets> test1(@RequestBody List<Pets> pets){
        for (Pets pet: pets) {
            System.out.println(pet.getName());
            System.out.println(pet.getType());
        }

        return pets;
    }

    @RequestMapping(value = "/something", method = RequestMethod.POST)
    public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity) throws UnsupportedEncodingException{
        String requestHeader = requestEntity.getHeaders().getFirst("my");
        byte[] requestBody = requestEntity.getBody();

        System.out.println(requestHeader);
        System.out.println(Arrays.toString(requestBody));

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("my", "three");
        return new ResponseEntity<String>(Arrays.toString(requestBody), responseHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "lastModified", method = RequestMethod.GET)
    public Long lastModified(){
        File file = new File("c:\\Reserve.img");
        System.out.println(file.lastModified());
        return file.lastModified();
    }
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file){
        String filename = file.getOriginalFilename();
        String directory = "/media/Vitaly/Lucru/@Spring/upload_files";
        String filepath = Paths.get(directory,filename).toString();
        try {
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            stream.write(file.getBytes());
            stream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<String>("Error",HttpStatus.BAD_REQUEST);
        }
        ArrayList<String> list = new ArrayList<String>();
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i< listOfFiles.length;i++){
            if (listOfFiles[i].isFile()){
                list.add(listOfFiles[i].getName());
            }
        }
        return new ResponseEntity<ArrayList<String>>(list,HttpStatus.OK);


    }
}
