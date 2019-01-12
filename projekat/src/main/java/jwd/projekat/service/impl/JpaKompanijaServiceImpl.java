package jwd.projekat.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.projekat.model.Projekat;
import jwd.projekat.repository.ProjekatRepository;
import jwd.projekat.service.KompanijaService;

@Service
@Transactional
public class JpaKompanijaServiceImpl implements KompanijaService {
	@Autowired
	private ProjekatRepository projekatRepository;

	@Override
	public List<Projekat> findAll() {
		return projekatRepository.findAll();
	}

	@Override
	public Projekat findOne(Long id) {
		return projekatRepository.findOne(id);
	}

	@Override
	public void save(Projekat projekat) {
		projekatRepository.save(projekat);
	}

	@Override
	public void remove(Long id) {
		projekatRepository.delete(id);
	}
}
