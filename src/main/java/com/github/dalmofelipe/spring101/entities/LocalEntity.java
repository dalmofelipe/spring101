package com.github.dalmofelipe.spring101.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Table(name = "tb_locals")
@Data
public class LocalEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String state;
	private String name;
	private Float lat;
	private Float lon;
	private String ip;
	private Float temperature;
	private Float humidity;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime date;
}
