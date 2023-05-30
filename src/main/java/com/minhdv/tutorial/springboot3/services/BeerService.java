package com.minhdv.tutorial.springboot3.services;

import com.minhdv.tutorial.springboot3.model.Beer;

import java.util.List;
import java.util.UUID;

/**
 * CREATE BY MinhDV
 */
public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    void updateBeerById(UUID beerId, Beer beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, Beer beer);
}
