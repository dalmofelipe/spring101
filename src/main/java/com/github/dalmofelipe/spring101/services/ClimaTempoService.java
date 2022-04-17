package com.github.dalmofelipe.spring101.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.dalmofelipe.spring101.dtos.LocalWeatherDto;
import com.github.dalmofelipe.spring101.dtos.SearchCityDto;
import com.github.dalmofelipe.spring101.exceptions.business.CityNotFoundException;
import com.github.dalmofelipe.spring101.exceptions.business.WeatherLocaleNotFoundException;

import reactor.core.publisher.Mono;

@Service
public class ClimaTempoService {

	private final String baseUrl = "http://apiadvisor.climatempo.com.br/api/v1";
	
	@Value("${app.api.climatempo.token}")
	private String token;

	private final WebClient webClient;

	public ClimaTempoService() {
		this.webClient = WebClient.builder()
			.baseUrl(baseUrl)
			//.defaultCookie("cookieKey", "cookieValue")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
			.defaultUriVariables(Collections.singletonMap("url", baseUrl))
			.build();
	}
	
	// pesquisar cidade por nome
	// http://apiadvisor.climatempo.com.br/api/v1/locale/city?name=Belo%20Horizonte&state=UF&country=BR&token=your-app-token
	public Integer searchCityByNameAndUF(String name, String UF) {
		
		// /api/v1/locale/city?name=Belo%20Horizonte&country=BR&token=your-app-token
		Mono<List<SearchCityDto>> response = this.webClient.get()
			.uri(builder -> builder.path("/locale/city")
				.queryParam("name", name)
				.queryParam("state", UF)
				.queryParam("country", "BR")
				.queryParam("token", this.token)
				.build()
			)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference<List<SearchCityDto>>() {});
		
		List<SearchCityDto> cities = response.block();
		
		Optional<SearchCityDto> cityOpt = cities.stream()
				.filter(c -> c.getName().equals(name) && c.getState().equals(UF))
				.findFirst();
		if(cityOpt.isEmpty()) throw new CityNotFoundException(name, UF);
		
		return cityOpt.get().getId();
	}
	
	// pesquisar clima com id da cidade
	// http://apiadvisor.climatempo.com.br/api/v1/weather/locale/{idCity}/current?token={token}
	public LocalWeatherDto weatherLocaleByCityID(Integer idCity) {
		Mono<LocalWeatherDto> response = this.webClient.get()
			.uri(builder -> builder.path("/weather/locale/" + idCity + "/current")
				.queryParam("token", this.token)
				.build()
			)
			.accept(MediaType.APPLICATION_JSON)
			.retrieve()
			.bodyToMono(LocalWeatherDto.class);
		
		Optional<LocalWeatherDto> opt = response.blockOptional();
		if(opt.isEmpty()) throw new WeatherLocaleNotFoundException(idCity);
		return opt.get();
	}
}
