	package jwd.projekat.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.projekat.model.Zadatak;

public interface AutomobilService {
	Page<Zadatak> findAll(int pageNum);
	Zadatak findOne(Long id);
	void save(Zadatak zadatak);
	void remove(Long id);
	Page<Zadatak> findByKompanijaId(int pageNum, Long kompanijaId);
	Page<Zadatak> pretraga(
			@Param("model") String model, 
			@Param("godiste") Integer godiste,
			@Param("potrosnja") Double potrosnja,
			int page);
}
