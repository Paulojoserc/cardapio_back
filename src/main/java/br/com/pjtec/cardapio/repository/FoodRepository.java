package br.com.pjtec.cardapio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pjtec.cardapio.food.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
