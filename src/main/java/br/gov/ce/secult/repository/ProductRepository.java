package br.gov.ce.secult.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.ce.secult.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
