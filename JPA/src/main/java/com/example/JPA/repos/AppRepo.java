package com.example.JPA.repos;

import com.example.JPA.domain.Application;
import com.example.JPA.domain.Developers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppRepo extends CrudRepository<Application, Long> {

    List<Application> findByDevelopersContains(Developers dev);




}
