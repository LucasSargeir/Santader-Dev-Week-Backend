package com.project.bootcamp.controller;

import com.project.bootcamp.model.dto.StockDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( value = "/stock")
public class StockController {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(dto);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(dto);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<StockDTO>> findAll(){
		List<StockDTO> list = new ArrayList<>();

		StockDTO dto1 = new StockDTO();
		StockDTO dto2 = new StockDTO();

		dto1.setId(1L);
		dto1.setName("Magalu");
		dto1.setPrice(100D);
		dto1.setVariation(10D);
		dto1.setDate(LocalDate.now());

		dto2.setId(2L);
		dto2.setName("Amazon");
		dto2.setPrice(250D);
		dto2.setVariation(5D);
		dto2.setDate(LocalDate.now());

		list.add(dto1);
		list.add(dto2);

		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StockDTO> findById(@PathVariable Long id){
		List<StockDTO> list = new ArrayList<>();

		StockDTO dto1 = new StockDTO();
		StockDTO dto2 = new StockDTO();

		dto1.setId(1L);
		dto1.setName("Magalu");
		dto1.setPrice(100D);
		dto1.setVariation(10D);
		dto1.setDate(LocalDate.now());

		dto2.setId(2L);
		dto2.setName("Amazon");
		dto2.setPrice(250D);
		dto2.setVariation(5D);
		dto2.setDate(LocalDate.now());

		list.add(dto1);
		list.add(dto2);

		StockDTO selecionado = list.stream().filter(x-> x.getId().compareTo(id) == 0).findFirst().get();

		return ResponseEntity.ok(selecionado);
	}
}