package com.github.dalmofelipe.spring101.services;

import java.util.Collections;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.github.dalmofelipe.spring101.dtos.IpApiDto;

import reactor.core.publisher.Mono;

@Service
public class IpApiService {

	private final String baseIpApiURL = "http://ip-api.com/json/";
	private final WebClient webClient;

	public IpApiService() {
		this.webClient = WebClient.builder()
			.baseUrl(baseIpApiURL)
			//.defaultCookie("cookieKey", "cookieValue")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) 
			.defaultUriVariables(Collections.singletonMap("url", baseIpApiURL))
			.build();
	}

	public Mono<IpApiDto> getIpLocation() {
		return this.webClient.get()
			.uri("?fields=status,message,country,countryCode,region,regionName,city,zip,lat,lon,timezone,isp,org,as,query")
			.accept(MediaType.APPLICATION_JSON)
			.retrieve().bodyToMono(IpApiDto.class);
	}
}
