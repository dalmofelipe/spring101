package com.github.dalmofelipe.spring101.controllers;

import java.util.Optional;

import com.github.dalmofelipe.spring101.dtos.IpApiDto;
import com.github.dalmofelipe.spring101.dtos.LocalWeatherDto;
import com.github.dalmofelipe.spring101.entities.LocalEntity;
import com.github.dalmofelipe.spring101.exceptions.business.IpApiUnprocessException;
import com.github.dalmofelipe.spring101.services.ClimaTempoService;
import com.github.dalmofelipe.spring101.services.IpApiService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/localize")
public class LocalizeControllerV1 {
	
	private IpApiService ipApService;
	private ClimaTempoService climaTempoService;
		
	public LocalizeControllerV1(IpApiService ipApService, ClimaTempoService climaTempoService) {
		this.ipApService = ipApService;
		this.climaTempoService = climaTempoService;
	}
	
	@GetMapping
	public LocalEntity getMeassury() {
		// IpApiDto local = this.getIpLocation();
		// String cityName = local.getCity();
		// String UF = local.getRegion();
		// String ip = local.getQuery();
		// Integer idCity = this.getCityID(cityName, UF);

		
		return null;
	}
	
	@GetMapping("/ip-local")
	public IpApiDto getIpLocation() {
		Mono<IpApiDto> ipLocationMono = this.ipApService.getIpLocation();
		Optional<IpApiDto> ipLocationOpt = ipLocationMono.blockOptional();
		if(ipLocationOpt.isEmpty()) throw new IpApiUnprocessException();
		IpApiDto ipLocation = ipLocationOpt.get();
		return ipLocation;
	}
		
	@GetMapping("/city/{name}/{UF}")
	public Integer getCityID(
		@PathVariable(required = true) String name, 
		@PathVariable(required = true) String UF
	) {
		name = capitalizeWord(name);
		return this.climaTempoService.searchCityByNameAndUF(name, UF);
	}
	
	@GetMapping("/city/{idCity}")
	public LocalWeatherDto getWeatherLocaleByCityID(@PathVariable Integer idCity) {
		return this.climaTempoService.weatherLocaleByCityID(idCity);
	}
	
	@GetMapping("/city")
	public Integer getIDCity(
		@RequestParam(required = true) String name, 
		@RequestParam(required = true) String UF
	) {
		name = capitalizeWord(name);
		return this.climaTempoService.searchCityByNameAndUF(name, UF);
	}
	
	public static String capitalizeWord(String str) {
	    String words[]=str.split("\\s");  
	    String capitalizeWord="";  
	    for(String w:words) {
	        String first=w.substring(0,1);  
	        String afterfirst=w.substring(1);  
	        capitalizeWord+=first.toUpperCase()+afterfirst+" ";  
	    }  
	    return capitalizeWord.trim();  
	}
}
