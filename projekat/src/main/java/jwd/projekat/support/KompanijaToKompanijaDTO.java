package jwd.projekat.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.projekat.model.Projekat;
import jwd.projekat.web.dto.KompanijaDTO;

@Component
public class KompanijaToKompanijaDTO 
	implements Converter<Projekat, KompanijaDTO> {

	@Override
	public KompanijaDTO convert(Projekat projekat) {
		KompanijaDTO kompanijaDTO = new KompanijaDTO();
		kompanijaDTO.setId(projekat.getId());
		kompanijaDTO.setNaziv(projekat.getNaziv());
		kompanijaDTO.setAdresa(projekat.getRokZavrsetka());
		kompanijaDTO.setTelefon(projekat.getTelefon());
		return kompanijaDTO;
	}

	public List<KompanijaDTO> convert(List<Projekat> kompanije) {
		List<KompanijaDTO> ret = new ArrayList<>();
		
		for(Projekat k: kompanije){
			ret.add(convert(k));
		}
		
		return ret;
	}
}
