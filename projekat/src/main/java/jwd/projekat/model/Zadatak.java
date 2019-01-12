package jwd.projekat.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Zadatak {
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable=false, unique=true)
	private String naziv;
	@Column(nullable=false)
	private String zaduzeni;
	@Column(nullable=false)
	private Integer procenaSati;
	@Column
	private String opis;
	@ManyToOne(fetch=FetchType.EAGER)
	private Projekat projekat;
	@OneToMany(mappedBy="zadatak",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private List<Stanje> stanja = new ArrayList<>();

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String model) {
		this.naziv = model;
	}
	public Integer getProcenaSati() {
		return procenaSati;
	}
	public void getProcenaSati(Integer procenaSati) {
		this.procenaSati = procenaSati;
	}

	public Projekat getKompanija() {
		return projekat;
	}
	public void setKompanija(Projekat projekat) {
		this.projekat = projekat;
		if(projekat!=null && !projekat.getZadaci().contains(this)){
			projekat.getZadaci().add(this);
		}
	}
	public List<Stanje> getStanje() {
		return stanja;
	}
	public void setNajmovi(List<Stanje> stanja) {
		this.stanja = stanja;
	}
	public void addStanje(Stanje stanje){
		this.stanja.add(stanje);
		
		if(!this.equals(stanje.getZadatak())){
			stanje.setZadatak(this);
		}
	}
	public String getZaduzeni() {
		return zaduzeni;
	}
	public void setZaduzeni(String zaduzeni) {
		this.zaduzeni = zaduzeni;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public Projekat getProjekat() {
		return projekat;
	}
	public void setProjekat(Projekat projekat) {
		this.projekat = projekat;
	}
	public List<Stanje> getStanja() {
		return stanja;
	}
	public void setStanja(List<Stanje> stanja) {
		this.stanja = stanja;
	}
	public void setProcenaSati(Integer procenaSati) {
		this.procenaSati = procenaSati;
	}
	public List<Stanje> getZadatak() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
