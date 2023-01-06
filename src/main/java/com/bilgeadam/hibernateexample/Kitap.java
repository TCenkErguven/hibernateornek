package com.bilgeadam.hibernateexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//codefirst yaklaşımı

@Entity	//mysql'le bağlantıyı sağlayacak
@Table(name = "book")
public class Kitap {

	@Id
	@Column(name="kitap_id")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@Column(name="baslik")//kolonlarla değişkenler 
	private String baslik;
	
	@Column(name="yazar")
	private String yazar;
	
	@Column(name="fiyat")
	private float fiyat;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBaslik() {
		return baslik;
	}

	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}

	public String getYazar() {
		return yazar;
	}

	public void setYazar(String yazar) {
		this.yazar = yazar;
	}

	public float getFiyat() {
		return fiyat;
	}

	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}

}
