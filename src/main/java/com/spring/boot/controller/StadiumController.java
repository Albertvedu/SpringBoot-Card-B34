package com.itacademy.soccer.controller;

import com.spring.boot.data.InsertData;
import com.spring.boot.data.VerifyDataStadium;
import com.spring.boot.model.Stadium;
import com.spring.boot.model.json.StadiumJson;
import com.spring.boot.service.IStadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/stadiums")
public class StadiumController {

    @Qualifier("IStadiumService")
    @Autowired
    IStadiumService iStadiumService;
    @Autowired
    //MatchServiceImpl matchServiceImpl;
    HashMap<String,Object> map = new HashMap<>();
    VerifyDataStadium verifyDataStadium = new VerifyDataStadium();

    @GetMapping
    HashMap<String,Object> getAllStadium(){
        map.clear();
        List<Stadium> stadiumList = iStadiumService.findAll();

        if (stadiumList.size() > 0 ) {
            map.put("success", true);
            map.put("Stadiums: ", stadiumList);
            map.put("message", "get all stadiums");
        }else {
            map.put("success", false);
            map.put("message", "there are no stadiums in bbdd");
        }
        return map;
    }
    @GetMapping("/{id}")
    HashMap<String,Object> getStadium(@PathVariable String id){
        map.clear();
        map = verifyDataStadium.verifyIds(id, map);

        if ( map.size() == 0) {

            Stadium stadium= iStadiumService.findByStadiumId( Long.parseLong( id ));

            if (stadium != null) {
                map.put("success", true);
                map.put("Stadium: ", stadium);
                map.put("message", "get stadium ");
            } else {
                map.put("success", false);
                map.put("message", "there are no stadium whith id: " + id);
            }
            return map;
        }
        return map;
    }
    @PostMapping
    HashMap<String,Object> postStadium(@RequestBody StadiumJson stadium){
        try {
            map.clear();
            map = verifyDataStadium.verifyStrings(stadium, iStadiumService, map);
            map = verifyDataStadium.verifyNumericPost(stadium, map);

            if ( map.size() == 0) {
                Stadium s = new InsertData().insertStadium(stadium);
                map.put("success", true);
                map.put("stadium ", s);
                map.put("message", " create stadium");
                iStadiumService.save(s);
            }
        }
        catch (Exception e) {
            map.put("success", false);
            map.put("message", "something went wrong: " + e.getMessage());
        }
        return map;
    }
    @PutMapping()
    public HashMap<String,Object> updateStadium(@RequestBody StadiumJson stadium){
        map.clear();

        try{
            map = verifyDataStadium.verifyNumericPut(stadium, map);

            if (map.size() == 0 ) map = verifyDataStadium.verifyStrings(stadium, iStadiumService, map);
            else return map;
            Stadium s = new InsertData().putStadium(stadium);

            if ( map.size() == 0) {
                iStadiumService.save(s);
                map.put("success", true);
                map.put("stadium update", s);
                map.put("message", HttpStatus.OK);
            }
        }catch (Exception e) {
            map.put("success", false);
            map.put("message", "something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
        return map;
    }
    //TODO No funciona ... Fallo al ir a la capa service a buscar Match por el Id, prefiero no tocar esa capa service que no he hecho yo.
    @PutMapping("/stadiumId/matchId")
    public HashMap<String, Object> addMatch(@RequestBody StadiumJson s) {
        map.clear();
        try{
            //   map = verifyDataStadium.verifyIds(s, map);

            if ( map.size() == 0) {
//                Stadium stadium = iStadiumService.findByStadiumId(Long.parseLong(s.getId()));
//                Optional<Match> match = matchServiceImpl.findById(Long.parseLong(s.getId2()));
//                stadium = new InsertData().addMatch(stadium, match);
//                iStadiumService.save(stadium);
//                map.put("success", true);
//                map.put("stadium", stadium);
                map.put("update", HttpStatus.OK);
            }
        }catch (Exception e) {
            map.put("success", false);
            map.put("message", "something went wrong: " + e.getMessage());
        }
        return map;
    }

    @DeleteMapping
    public HashMap<String,Object> deleteStadium(@RequestBody StadiumJson id){
        map.clear();
        map = verifyDataStadium.verifyIds(id.getId(), map);

        if ( map.size() == 0) {
            try {
                iStadiumService.deleteById(Long.parseLong( id.getId() ));
                map.put("success", true);
                map.put("message", HttpStatus.OK);
            } catch (Exception e) {
                map.put("success", false);
                map.put("message", "something went wrong: " + e.getMessage());
            }
        }
        return map;
    }

}
