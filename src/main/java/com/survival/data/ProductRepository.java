package com.survival.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.survival.domain.model.Product;

public class ProductRepository {
	
//	public static void main(String[] args) {
//		// ArrayList - �Ϲ����� �迭, ũ�Ⱑ Ŭ���� ������, ���������� �迭�̶� ������ ������.
//		// LinkedList - ���� �迭, ���� ������ ����� �� ����, but �˻��� ������. �޸𸮰� ���� ũ��
//		// List - interface, ����� ���� �Ǿ����� ���� ����, ������
//		
//		LinkedList<Product> products = new LinkedList<>();
//		
//		ArrayList<Product> products2 = new ArrayList<>();
//		
//		sort(products);
//		sort(products2);
//	}
//	
//	public static List<Product> sort(List<Product> Products) {
//		return new ArrayList<>();
//	}
	
	private List<Product> products = new ArrayList<>();
	
	//�̱��� ����
	// 1. static �ν��Ͻ� �غ�
	// 2. static �ż���� �ν��Ͻ� ���� (getInstance() �̸��� �ַ� ��)
	// 3. ������ ���� (private)
	private static ProductRepository instance = new ProductRepository();
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private ProductRepository() {
		Product phone = new Product("P1234", "iPhone 6s", 800000);
		phone.setDescription("4.7-inch, 1334x750 Retina HD display");
		phone.setCategory("Smart Phone");
		phone.setManufacturer("Apple");
		phone.setUnitsInStock(1000);
		phone.setCondition("New");
		
		Product notebook = new Product("P1235", "LG PC �׷�", 1500000);
		notebook.setDescription("!4.7-inch, 1334x750 Retina HD display");
		notebook.setCategory("!Smart Phone");
		notebook.setManufacturer("!Apple");
		notebook.setUnitsInStock(1000);
		notebook.setCondition("Refubished");
		
		Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
		tablet.setDescription("?4.7-inch, 1334x750 Retina HD display");
		tablet.setCategory("?Smart Phone");
		tablet.setManufacturer("?Apple");
		tablet.setUnitsInStock(1000);
		tablet.setCondition("Old");
		
		products.add(phone);
		products.add(notebook);
		products.add(tablet);
	}
	
	// ��� ��ǰ ������ ����
	public List<Product> getAllProducts() {
		return products;
	}
	
	public Product getProductById(String id) {
		// List -> Steam (�������� �帧)
		return products.stream()
					.filter((product) -> product.getId().equals(id))	// ���� 
					.findFirst()	// ù��° ��
					.get();	// ������
	}
	
	public void addProduct(Product product) {
		products.add(product);
	}
}