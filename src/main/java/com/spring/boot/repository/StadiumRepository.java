package com.spring.boot.repository;


import com.spring.boot.model.Stadium;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StadiumRepository implements IStadiumRepository{


    @Override
    public List<Stadium> findAll() {
        return findAll();
    }

    @Override
    public List<Stadium> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Stadium> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Stadium> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Stadium stadium) {

    }

    @Override
    public void deleteAll(Iterable<? extends Stadium> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Stadium> S save(S s) {
        return null;
    }

    @Override
    public <S extends Stadium> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Stadium> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Stadium> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Stadium> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Stadium getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Stadium> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Stadium> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Stadium> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Stadium> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Stadium> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Stadium> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Stadium findByStadiumId(Long stadiumId) {
        return findByStadiumId(stadiumId);
    }
}
