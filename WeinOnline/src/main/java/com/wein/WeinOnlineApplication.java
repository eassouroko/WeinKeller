package com.wein;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.*;
import com.repository.*;
import com.service.WineCategoryService;
import com.service.WineService;

@Controller
@SpringBootApplication
@EntityScan("com.model")
@EnableJpaRepositories("com.repository")
@ComponentScan("com.service")



public class WeinOnlineApplication implements CommandLineRunner{
	
	@Autowired
	private WineCategoryService wineCategoryService;
	@Autowired
	private WineService wineService;
	 @RequestMapping("/")
	    public String welcome() {
	        return "home";
	    }
	public static void main(String[] args) {
		SpringApplication.run(WeinOnlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		/*public Wine(WineCategory wineCategory, String windeCode, String wineName, String wineDescription, double wineUnitPrice,
				double wineSize, double alcoolContent, int numberPerPackage, String wineColor) {
			super();
			this.wineCategory = wineCategory;
			this.wineCode = windeCode;
			this.wineName = wineName;
			this.wineDescription = wineDescription;
			this.wineUnitPrice = wineUnitPrice;
			this.wineSize = wineSize;
			this.alcoolContent = alcoolContent;
			this.numberPerPackage = numberPerPackage;
			this.wineColor = wineColor;
		}*/
		
	    com.model.WineCategory cat=	wineCategoryService.findByCategoryDescription("Linea Supemante \"Bollicine\"") ;  //("Linea \"Selezione\"");
		Wine w= new Wine();
		w.setWineCode("V153");
		w.setWineName("BreZZa Riva");
		//w.setWineDescription("TRENTO D.O.C. \(100 \% CHARDONNAY\)");
		w.setWineDescription("TRENTO D.O.C. "+"("+100+ "% Chardonnay"+")");
		w.setWineCategory(cat);
		w.setWineUnitPrice(7.65);
		w.setWineSize(0.75);
		w.setAlcoolContent(13.5);
		w.setNumberPerPackage(6);
		
		
		wineService.saveWine(w);
		
	
		
		


		
		
	}
}
