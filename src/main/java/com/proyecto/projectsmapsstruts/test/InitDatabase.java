package com.proyecto.projectsmapsstruts.test;

import com.proyecto.projectsmapsstruts.dto.GetProduct;
import com.proyecto.projectsmapsstruts.entity.Product;
import com.proyecto.projectsmapsstruts.mapper.ProductMapper;
import com.proyecto.projectsmapsstruts.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDatabase {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand() {

        System.out.println("Con esto resumo lo anterior");

        return args -> {
            List<Product> products = productRepository.findAll();

            System.out.println("Porducts ");
            products.forEach(System.out::println);

            System.out.println("Get Porducts ");

            List<GetProduct> getProductList = productMapper.toGetProductList(products);
           /* esto reemplaza tmb la linea 37 si no se tiene el metodo toGetProductList
            List<GetProduct> getProductList = products
                    .stream().map(product -> productMapper.toGetDTO(product))
                    .peek(System.out::println)
                    .collect(Collectors.toList());

            */

            getProductList.forEach(System.out::println);

            System.out.println("Mapped Porducts ");
            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);


        };


    }
}
