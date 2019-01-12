package jwd.projekat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stanje {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@ManyToOne(fetch=FetchType.EAGER)
	private Zadatak zadatak;
	
	public Zadatak getZadatak() {
		return zadatak;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public void setZadatak(Zadatak zadatak) {
		this.zadatak = zadatak;
		if(zadatak!=null && !zadatak.getStanje().contains(this)){
			zadatak.getZadatak().add(this);
		}
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
}
