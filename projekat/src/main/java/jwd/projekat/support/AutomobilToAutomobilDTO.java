package jwd.projekat.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.projekat.model.Zadatak;
import jwd.projekat.web.dto.AutomobilDTO;

@Component
public class AutomobilToAutomobilDTO 
	implements Converter<Zadatak, AutomobilDTO> {

	@Override
	public AutomobilDTO convert(Zadatak source) {
		AutomobilDTO dto = new AutomobilDTO();
		dto.setId(source.getId());
		dto.setModel(source.getNaziv());
		dto.setRegistracija(source.getRegistracija());
		dto.setGodiste(source.getGodiste());
		dto.setPotrosnja(source.getPotrosnja());
		dto.setIznajmljen(source.getIznajmljen());
		dto.setKompanijaId(source.getKompanija().getId());
		dto.setKompanijaNaziv(source.getKompanija().getNaziv());
		
		return dto;
	}
	
	public List<AutomobilDTO> convert(List<Zadatak> automobili){
		List<AutomobilDTO> ret = new ArrayList<>();
		
		for(Zadatak a : automobili){
			ret.add(convert(a));
		}
		
		return ret;
	}

}
