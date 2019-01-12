package jwd.projekat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.projekat.model.Zadatak;
import jwd.projekat.model.Stanje;
import jwd.projekat.repository.ZadatakRepository;
import jwd.projekat.repository.StanjeRepository;
import jwd.projekat.service.NajamService;

@Service
public class JpaNajamServiceImpl implements NajamService{
	
	@Autowired
	private StanjeRepository stanjeRepository;
	@Autowired
	private ZadatakRepository zadatakRepository;
	
	@Override
	public Stanje rentACar(Long automobilId) {
		
		if(automobilId == null) {
			throw new IllegalArgumentException("Id of a car cannot be null!");
		}
		
		Zadatak zadatak = zadatakRepository.findOne(automobilId);
		if(zadatak == null) {
			throw new IllegalArgumentException("There is no car that has given id!");
		}
		
		if(!zadatak.getIznajmljen()) {
			zadatak.setIznajmljen(true);
			
			Stanje stanje = new Stanje();
			stanje.setAutomobil(zadatak);
			
			stanjeRepository.save(stanje);
			zadatakRepository.save(zadatak);
				
			return stanje;
		}
		
		return null;
	}
}
