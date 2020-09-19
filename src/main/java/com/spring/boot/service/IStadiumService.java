package com.spring.boot.service;



import com.spring.boot.model.Stadium;
import com.spring.boot.repository.IStadiumRepository;
import org.springframework.stereotype.Service;

@Service
public interface IStadiumService extends IStadiumRepository {

    Stadium findByStadiumId(Long stadiumId);

}
