package com.bilgeadam.hibernateexample;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class KitapManager {
	protected SessionFactory sessionFactory;
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
	
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		}catch(Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry); 
			//yaptığım değişikliklerle alakalı bir sorun yaşanırsan bunları RAM'den kaldır.
		}
	}
	protected void exit() {
		sessionFactory.close();
	}
	public void KayitEkle() 
	{
		Kitap kitap = new Kitap();
		kitap.setBaslik("Kitap1");
		kitap.setYazar("İbrahim");
		kitap.setFiyat(33);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(kitap); //insert into kitap("başlik","Yazar","Price") values("Kitap1","İbrahim",33);
		session.getTransaction().commit();
		session.close();
	}
	
	public void KayitGetir() {
		Session session = sessionFactory.openSession();
		long kitapId = 1;
		Kitap kitap = session.get(Kitap.class, kitapId);
		System.out.println("Başlık : " + kitap.getBaslik());
		System.out.println("Fiyat : " + kitap.getFiyat());
	}
	
	public static void main(String[] args)
	{
		KitapManager manager = new KitapManager();
		manager.setup();
	//	manager.KayitEkle();
		manager.KayitGetir();
		manager.exit();
	}
}
