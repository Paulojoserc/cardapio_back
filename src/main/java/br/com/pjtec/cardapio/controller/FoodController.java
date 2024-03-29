package br.com.pjtec.cardapio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pjtec.cardapio.food.Food;
import br.com.pjtec.cardapio.food.FoodRequestDTO;
import br.com.pjtec.cardapio.food.FoodResponseDTO;
import br.com.pjtec.cardapio.repository.FoodRepository;

@RestController
@RequestMapping("food")
public class FoodController {
	@Autowired
	private FoodRepository repository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void saveFood(@RequestBody FoodRequestDTO data) {
		Food fodaData = new Food(data);
		repository.save(fodaData);
		return;
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<FoodResponseDTO> getAll() {

		List<FoodResponseDTO> foodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
		return foodList;

	}
}
