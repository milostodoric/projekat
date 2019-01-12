package jwd.projekat.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.projekat.model.Zadatak;
import jwd.projekat.repository.ZadatakRepository;
import jwd.projekat.service.AutomobilService;

@Service
@Transactional
public class JpaAutomobilServiceImpl implements AutomobilService {
	
	@Autowired
	private ZadatakRepository zadatakRepository;

	@Override
	public Page<Zadatak> findAll(int pageNum) {
		return zadatakRepository.findAll(
				new PageRequest(pageNum, 5));
	}

	@Override
	public Zadatak findOne(Long id) {
		return zadatakRepository.findOne(id);
	}

	@Override
	public void save(Zadatak zadatak) {
		zadatakRepository.save(zadatak);
	}

	@Override
	public void remove(Long id) {
		zadatakRepository.delete(id);
	}

	@Override
	public Page<Zadatak> findByKompanijaId(int pageNum, Long kompanijaId) {
		
		return zadatakRepository.findByKompanijaId(kompanijaId, new PageRequest(pageNum, 5));
	}

	@Override
	public Page<Zadatak> pretraga(String model, Integer godiste, Double potrosnja, int page) {
		if(model != null ){
			model = "%" + model + "%";
		}
		return zadatakRepository.pretraga(model, godiste, potrosnja, new PageRequest(page, 5));
	}

}
