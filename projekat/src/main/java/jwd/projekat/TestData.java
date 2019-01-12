package jwd.projekat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.projekat.model.Zadatak;
import jwd.projekat.model.Projekat;
import jwd.projekat.service.AutomobilService;
import jwd.projekat.service.KompanijaService;


@Component
public class TestData {

	@Autowired
	private KompanijaService kompanijaService;
	
	@Autowired
	private AutomobilService automobilService;
	
	@PostConstruct
	public void init() {
		
		Projekat k1 = new Projekat();
		k1.setNaziv("SuRent");
		k1.setRokZavrsetka("Balzakova 1");
		k1.setTelefon("024/151-363");
		kompanijaService.save(k1);
		
		Projekat k2 = new Projekat();
		k2.setNaziv("NSRent");
		k2.setRokZavrsetka("Maksima Gorkog 2");
		k2.setTelefon("021/4141-515");
		kompanijaService.save(k2);
		
		Zadatak a1 = new Zadatak();
		a1.setNaziv("Nissan Prairie");
		a1.setRegistracija("SU82404");
		a1.setGodiste(1991);
		a1.setPotrosnja(10.3);
		a1.setKompanija(k1);
		
		automobilService.save(a1);
	}
}