package com.github.dalmofelipe.spring101.services;

import com.github.dalmofelipe.spring101.dtos.CityIDsRegisterDto;
import com.github.dalmofelipe.spring101.dtos.ResponseManagerTokenDto;
import com.github.dalmofelipe.spring101.exceptions.business.RegisterCityIdOnTokenUnproccessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Optional;

@Service
public class TokenManagerService {

	@Value("${app.api.climatempo.token}")
	private String token;
    private final String baseUrl = "http://apiadvisor.climatempo.com.br/api-manager/user-token/";
    private final WebClient webClient;

    public TokenManagerService() {
        this.webClient  = WebClient.builder()
			.baseUrl(baseUrl)
			//.defaultCookie("cookieKey", "cookieValue")
			.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.defaultUriVariables(Collections.singletonMap("url", baseUrl))
			.build();
    }

    public ResponseManagerTokenDto registerCityIdOnToken(CityIDsRegisterDto cityIds) {
		Mono<ResponseManagerTokenDto> response = this.webClient
			.put()
			.uri(baseUrl + token + "/locales")
			.body(BodyInserters.fromValue(cityIds))
			.exchangeToMono(clientResponse -> clientResponse.bodyToMono(ResponseManagerTokenDto.class));
			//.body(Mono.just(cityIds), CityIDsRegisterDto.class)
			//.retrieve()
			//.bodyToMono(ResponseManagerTokenDto.class);
        Optional<ResponseManagerTokenDto> opt = response.blockOptional();
        return opt.orElseThrow(() -> { throw new RegisterCityIdOnTokenUnproccessException(); });
    }
}
