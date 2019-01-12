package jwd.projekat.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.projekat.model.Stanje;
import jwd.projekat.web.dto.NajamDTO;

@Component
public class NajamToNajamDTO implements Converter<Stanje, NajamDTO> {

	@Override
	public NajamDTO convert(Stanje arg0) {
		
		NajamDTO dto = new NajamDTO();
		dto.setId(arg0.getId());
		
		return dto;
	}

}
