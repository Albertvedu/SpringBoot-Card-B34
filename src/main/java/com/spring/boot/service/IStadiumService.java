package com.spring.boot.service;


import com.spring.boot.model.Match;
import com.spring.boot.model.Stadium;
import com.spring.boot.model.json.StadiumJson;
import com.spring.boot.repository.IStadiumRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public interface IStadiumService {

    HashMap<String,Object> verifyStrings(StadiumJson stadium, IStadiumRepository iStadiumDAO, HashMap<String, Object> map);
    HashMap<String,Object> verifyNumericPost(StadiumJson s, HashMap<String, Object> map);
    HashMap<String,Object> verifyNumericPut(StadiumJson s, HashMap<String, Object> map);
    HashMap<String,Object> messageError(String data);
    HashMap<String,Object> verifyIds(String ids, HashMap<String, Object> map);
    Stadium insertStadium(StadiumJson s);
    Stadium putStadium(StadiumJson stadium);
    Stadium addMatch(Stadium stadium, Optional<Match> match);
}
