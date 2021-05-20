package com.example.JPA.repos;

import com.example.JPA.domain.Application;
import com.example.JPA.domain.Developers;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface DeveloperRepo extends CrudRepository<Developers, Long> {

    List<Developers> findBySalaryLessThan(long limitSalary);

    List<Developers> findBySalaryLessThanOrderBySalaryDesc(long limitSalary);

    Developers findFirstBySalary(long limitSalary);

    @Transactional
    List<Developers> deleteAllBySalaryGreaterThan(long limitSalary);

    List<Developers> findByApplicationContainsAndSalaryIsLessThan(Application app, long limitSalary);



}
