package dev.correa.springbootsuperheroes.antiHero.controller;

import dev.correa.springbootsuperheroes.antiHero.dto.AntiHeroDto;
import dev.correa.springbootsuperheroes.antiHero.entity.AntiHeroEntity;
import dev.correa.springbootsuperheroes.antiHero.service.AntiHeroService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Author: Bruno Miguel Correa
 * Email: devsistemascorrea@gmail.com
 * Data: 18/06/2025
 **/
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/anti-heroes")
public class AntiHeroController {
	private final AntiHeroService service;
	private final ModelMapper mapper;
	
	@GetMapping("/{id}")
	public AntiHeroDto getAntiHeroById (@PathVariable("id") UUID id) {
		return convertToDto(service.findAntiHeroById(id));
	}
	
	@GetMapping
	public List<AntiHeroDto> getAllAntiHeroes () {
		var antiHeroesList =
				StreamSupport
						.stream(
								service
										.findAllAntiHeroes()
										.spliterator(), false
						).toList();
		return antiHeroesList
				.stream()
				.map(this::convertToDto)
				.collect(Collectors.toList());
	}
	
	@PostMapping
	public AntiHeroDto postAntiHero (@RequestBody AntiHeroDto dto) {
		var entity = convertToEntity(dto);
		var antiHero = service.addAntiHero(entity);
		return convertToDto(antiHero);
	}
	
	@PutMapping("/{id}")
	public void putAntiHero (@PathVariable("id") UUID id, @RequestBody AntiHeroDto dto) {
		if (!id.equals(dto.getId())) {
			throw new ResponseStatusException(BAD_REQUEST, "id does not atch");
		}
		var antiHeroEntity = convertToEntity(dto);
		service.updateAntiHero(id, antiHeroEntity);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAntiHeroById (@PathVariable("id") UUID id) {
		service.removeAntiHeroById(id);
	}
	
	private AntiHeroDto convertToDto (AntiHeroEntity entity) {
		return mapper.map(entity, AntiHeroDto.class);
	}
	
	private AntiHeroEntity convertToEntity (AntiHeroDto dto) {
		return mapper.map(dto, AntiHeroEntity.class);
	}
}
