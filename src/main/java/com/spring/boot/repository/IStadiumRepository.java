package com.spring.boot.repository;



import com.spring.boot.model.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStadiumRepository extends JpaRepository<Stadium, Long> {

    Stadium findByStadiumId(Long stadiumId);


}
