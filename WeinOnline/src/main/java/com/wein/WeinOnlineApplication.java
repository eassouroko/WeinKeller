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
import com.service.IWineCategoryService;
import com.service.IWineService;
import com.service.WineCategoryService;
import com.service.WineService;

@Controller
@SpringBootApplication
@EntityScan("com.model")
@EnableJpaRepositories("com.repository")
@ComponentScan("com.service")



public class WeinOnlineApplication implements CommandLineRunner{
	
	@Autowired
	private IWineCategoryService wineCategoryService;
	@Autowired
	private IWineService wineService;
	
	public static void main(String[] args) {
		SpringApplication.run(WeinOnlineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		

		
	}
}
