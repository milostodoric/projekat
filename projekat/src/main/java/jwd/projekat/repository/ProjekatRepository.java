package jwd.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.projekat.model.Projekat;

@Repository
public interface ProjekatRepository 
	extends JpaRepository<Projekat, Long> {

}
