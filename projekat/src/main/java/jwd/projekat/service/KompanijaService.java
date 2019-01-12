package jwd.projekat.service;

import java.util.List;

import jwd.projekat.model.Projekat;


public interface KompanijaService {
	List<Projekat> findAll();
	Projekat findOne(Long id);
	void save(Projekat projekat);
	void remove(Long id);

}
