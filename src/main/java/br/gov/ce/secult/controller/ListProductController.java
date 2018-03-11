package br.gov.ce.secult.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.ce.secult.model.Product;
import br.gov.ce.secult.repository.ProductRepository;

@Named
@ViewScoped
public class ListProductController {
	@Autowired
	private ProductRepository productRepository;

	private List<Product> products;

	@PostConstruct
	public void loadData() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String delete(Product product) {
		productRepository.delete(product.getId());
		loadData();
		return null;
	}

}
