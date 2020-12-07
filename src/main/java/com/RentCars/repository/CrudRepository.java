package com.RentCars.repository;


import java.util.List;

public interface CrudRepository <K,V> {

    List<K> findAll();

    V findById(K key);

    V update(V object);

    K delete(V object);

}
