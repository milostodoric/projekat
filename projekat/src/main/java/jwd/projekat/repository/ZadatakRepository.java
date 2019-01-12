package jwd.projekat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.projekat.model.Zadatak;

@Repository
public interface ZadatakRepository 
	extends JpaRepository<Zadatak, Long> {

	Page<Zadatak> findByKompanijaId(Long kompanijaId, Pageable pageRequest);

	@Query("SELECT a FROM Automobil a WHERE "
			+ "(:model IS NULL or a.model like :model ) AND "
			+ "(:godiste IS NULL or a.godiste >= :godiste ) AND "
			+ "(:potrosnja IS NULL OR a.potrosnja <= :potrosnja)"
			)
	Page<Zadatak> pretraga(
			@Param("model") String model, 
			@Param("godiste") Integer godiste, 
			@Param("potrosnja") Double potrosnja,
			Pageable pageRequest);

}
