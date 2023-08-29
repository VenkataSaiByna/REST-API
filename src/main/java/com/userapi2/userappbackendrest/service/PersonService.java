package com.userapi2.userappbackendrest.service;

import com.userapi2.userappbackendrest.exception.*;
import com.userapi2.userappbackendrest.model.DataClass;
import com.userapi2.userappbackendrest.model.DataSuccessResponse;
import com.userapi2.userappbackendrest.model.Person;
import com.userapi2.userappbackendrest.model.SuccessResponse;
import com.userapi2.userappbackendrest.repository.DataRepository;
import com.userapi2.userappbackendrest.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DataRepository dataRepository;
    public SuccessResponse doRegister(Person person){
        if(personRepository.findByusername(person.getUsername())!=null){
            throw new UsernameExistsException("User name is already Exists!!");
        }else if(personRepository.findByEmail(person.getEmail())!=null){
            throw new EmailExistsException("This Email is already registered!!");
        }else if(person.getAge()<=0){
            throw new InvalidAgeException("Age cannot be negitive or Zero");
        }else if(person.getPassword().length()<6 || !person.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")){
            throw new InvalidPasswordException("Provide a valid password!!");
        }else{
            Person person1=personRepository.save(person);
            SuccessResponse successResponse=new SuccessResponse("Success","Registration Success!!",person1);
            return successResponse;
        }

    }
    public DataSuccessResponse storeData(DataClass dataClass){
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        String userName=auth.getName();
        Person person=personRepository.findByusername(userName);
        List<DataClass> lst= person.getList();
        if(lst.size()!=0){
            String key=dataClass.getKeyVal();
            if(lst.stream().anyMatch(dta->dta.getKeyVal().equals(key))){
                throw new KeyExistsException("Key alraedy Exists!!");
            }
        }
        dataClass.setPerson(person);
        DataClass data=dataRepository.save(dataClass);
        DataSuccessResponse response=new DataSuccessResponse();
        response.setData(data);
        response.setMessage("Data Saved Successfully!!");
        response.setStatus("Success!!");
        return response;
    }
    public DataSuccessResponse getData(String key){
        boolean flag=false;
        Authentication auth=SecurityContextHolder.getContext().getAuthentication();
        DataSuccessResponse response=null;
        String userName=auth.getName();
        Person person=personRepository.findByusername(userName);
        List<DataClass> lst= person.getList();
        if(lst.size()!=0){
                for(DataClass cls:lst)
                {
                    if(cls.getKeyVal().equals(key))
                    {
                        response=new DataSuccessResponse();
                        response.setData(cls);
                        response.setMessage("Data Fetched Successfully!!");
                        response.setStatus("Success!!");
                        flag=true;
                        break;
                    }
                }
                if(!flag)
                    throw new KeyNotFoundException("Key is not found");
            }
        return response;
    }
    public DataSuccessResponse updateData(String key,String newValue){
        DataSuccessResponse result=getData(key);
        DataClass dta=result.getData();
        dta.setVal(newValue);
        dataRepository.save(dta);
        result.setData(dta);
        result.setMessage("Data Updated Successfully!!");
        return result;
    }
    public DataSuccessResponse deleteData(String key){
        DataSuccessResponse result=getData(key);
        DataClass dta=result.getData();
        dataRepository.delete(dta);
        result.setMessage("Data Deleted Successfully!!");
        result.setData(null);
        return  result;
    }
}
