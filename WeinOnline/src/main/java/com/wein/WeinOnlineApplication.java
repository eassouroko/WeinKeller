package com.wein;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
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
	
	public static void main(String[] args) {
		SpringApplication.run(WeinOnlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Wine wine=this.wineService.findByWineCode("V153");
		System.out.println(wine.getWineName());
		wine.setWineColor("White");
		this.wineService.saveWine(wine);
		//Wine toUpdate=this.win
		
		List<Wine> rosa = new ArrayList<Wine>();
		String searchTerm= "Line";
		rosa = this.wineService.searchWithNativeQuery(searchTerm);
		//searchTerm does not correspond to any wine. In that case search for wine category matching the searchterm
		if(rosa.isEmpty()) {
			System.out.println("##############################################");
			System.out.println("this no wine name: "+ searchTerm);
			System.out.println("Need to check in wine category for : "+ searchTerm);
			System.out.println("##############################################");
			List<WineCategory> matchingCat=this.wineCategoryService.searchWithNativeQuery(searchTerm);
			
			if(!matchingCat.isEmpty()) {
				
				
				for(int i=0; i<matchingCat.size();i++) {
					System.out.println(matchingCat.get(i).getCategoryDescription()+ " "+this.wineService.findByWineCategoryId((matchingCat.get(i).getId())).size() );
					//System.out.println("");
				
				List<Wine> list= this.wineService.findByWineCategoryId((matchingCat.get(i).getId()));
				    for(int count=0;count<list.size();count++) {
				    	System.out.println(list.get(count).getWineName());
				    	
				    	
				    }
				 }
					
				
				
			}
			
			
		}

		
	}
}
