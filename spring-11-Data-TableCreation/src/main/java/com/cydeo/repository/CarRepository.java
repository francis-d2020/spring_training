package com.cydeo.repository;

import com.cydeo.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //this determines the interface as services so that in execution time
//spring boot creates implementation of the interface
//niw this annotation not necessary
//by this extending we get the methods that are related to DB from jpaRepository
public interface CarRepository extends JpaRepository<Car,Long> {




}
