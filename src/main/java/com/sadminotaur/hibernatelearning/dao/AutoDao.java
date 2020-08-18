package com.sadminotaur.hibernatelearning.dao;

import com.sadminotaur.hibernatelearning.model.Auto;

public interface AutoDao {

    void addAuto(Auto auto);

    Auto findAutoById(int id);

    void update(Auto auto);

    void delete(Auto auto);

    void deleteAllAuto();

}
