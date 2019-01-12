package jwd.projekat.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.projekat.model.Zadatak;
import jwd.projekat.service.AutomobilService;
import jwd.projekat.service.KompanijaService;
import jwd.projekat.web.dto.AutomobilDTO;

@Component
public class AutomobilDTOToAutomobil 
	implements Converter<AutomobilDTO, Zadatak>{
	
	@Autowired
	private AutomobilService automobilService;
	@Autowired
	private KompanijaService kompanijaService;
	
	
	@Override
	public Zadatak convert(AutomobilDTO source) {
		Zadatak zadatak;
		if(source.getId()==null){
			zadatak = new Zadatak();
			zadatak.setKompanija(
					kompanijaService.findOne(
							source.getKompanijaId()));
		}else{
			zadatak = automobilService.findOne(source.getId());
		}
		
		
		zadatak.setNaziv(source.getModel());
		zadatak.setRegistracija(source.getRegistracija());
		zadatak.setGodiste(source.getGodiste());
		zadatak.setPotrosnja(source.getPotrosnja());
		zadatak.setIznajmljen(source.getIznajmljen());
		
		return zadatak;
	}

}
