package com.wein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.model.*;
import com.repository.*;



@SpringBootApplication
@EntityScan("com.model")
@EnableJpaRepositories("com.repository")



public class WeinOnlineApplication implements CommandLineRunner{
	
	@Autowired
	private WineCategoryRepository catrep;
	@Autowired
	private WineRepository wineRep;

	public static void main(String[] args) {
		SpringApplication.run(WeinOnlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		public Wine(WineCategory wineCategory, String windeCode, String wineName, String wineDescription, double wineUnitPrice,
//		double wineSize, double alcoolContent, int numberPerPackage, String wineColor)
		//WineCategory cat =new WineCategory("Linea Selezione");
//		String [] categories= {"Line Supemante \"Bollicine\"","Line \"Apponale\"","Linea \"Classica\"","Pouch-up","Bag-in-Box","BIRGER - OrganicVegan Wines - 3L Bag-inBox"};
//		for (int i=0;i<categories.length;i++) {
//			catrep.save(new WineCategory(categories[i]));
//			
//		}
		//catrep.save(cat);
		//Wine w1 =new Wine(cat, "V101","La Prea","D.O.C. -Traminer aromaticop trentino", 6.97,0.75,14,6,"Red");
		//wineRep.save(w1);
	}
}
