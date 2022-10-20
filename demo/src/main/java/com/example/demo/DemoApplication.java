package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		
		//BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgorithm());
		
		ApplicationContext applicationContext = 
				SpringApplication.run(DemoApplication.class, args);
		
		BinarySearchImpl binarySearch = 
				applicationContext.getBean(BinarySearchImpl.class);
		int result = binarySearch.binarySearch(new int[] { 12, 4, 6 }, 3);
		
		System.out.println(result);
		
//		SpringApplication.run(DemoApplication.class, args);
	}

}

// What are the beans?
// what are the dependencies of a bean?
// where to search for beans?