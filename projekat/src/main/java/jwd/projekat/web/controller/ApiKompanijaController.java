package jwd.projekat.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.projekat.model.Zadatak;
import jwd.projekat.model.Projekat;
import jwd.projekat.service.AutomobilService;
import jwd.projekat.service.KompanijaService;
import jwd.projekat.support.AutomobilToAutomobilDTO;
import jwd.projekat.support.KompanijaToKompanijaDTO;
import jwd.projekat.web.dto.AutomobilDTO;
import jwd.projekat.web.dto.KompanijaDTO;

@RestController
@RequestMapping(value="/api/kompanije")
public class ApiKompanijaController {
	@Autowired
	private KompanijaService kompanijaService;
	@Autowired
	private AutomobilService automobilService;
	@Autowired
	private KompanijaToKompanijaDTO toDTO;
	@Autowired
	private AutomobilToAutomobilDTO toAutomobilDTO;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<KompanijaDTO>> get(){
		return new ResponseEntity<>(
				toDTO.convert(kompanijaService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<KompanijaDTO> get(
			@PathVariable Long id){
		
		Projekat projekat = kompanijaService.findOne(id);
		
		if(projekat == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toDTO.convert(projekat),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/{komoanijaId}/automobili")
	public ResponseEntity<List<AutomobilDTO>> knjigeIzdavac(
			@PathVariable Long kompanijaId,
			@RequestParam(defaultValue="0") int pageNum){
		Page<Zadatak> automobili = automobilService.findByKompanijaId(pageNum, kompanijaId);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(automobili.getTotalPages()) );
		return  new ResponseEntity<>(
				toAutomobilDTO.convert(automobili.getContent()),
				headers,
				HttpStatus.OK);
	}
}
