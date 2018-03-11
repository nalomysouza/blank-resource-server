package br.gov.ce.secult.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import br.gov.ce.secult.model.Product;
import br.gov.ce.secult.repository.ProductRepository;

@Named
@ViewScoped
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	private Product product = new Product();

	public String save() {
		productRepository.save(product);
		product = new Product();
		return "/product/product-list.xhtml?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
