package com.github.dalmofelipe.spring101.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.dalmofelipe.spring101.dtos.IpApiDto;
import com.github.dalmofelipe.spring101.exceptions.business.IpApiUnprocessException;
import com.github.dalmofelipe.spring101.services.IpApiService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/local-time")
public class LocationWeatherController {
	
	private IpApiService ipApService;
		
	public LocationWeatherController(IpApiService ipApService) {
		this.ipApService = ipApService;
	}

	@GetMapping
	public IpApiDto getIpLocation() {
		Mono<IpApiDto> ipLocationMono = this.ipApService.getIpLocation();
		Optional<IpApiDto> ipLocationOpt = ipLocationMono.blockOptional();
		if(ipLocationOpt.isEmpty()) throw new IpApiUnprocessException();
		IpApiDto ipLocation = ipLocationOpt.get();
		return ipLocation;
	}
}
