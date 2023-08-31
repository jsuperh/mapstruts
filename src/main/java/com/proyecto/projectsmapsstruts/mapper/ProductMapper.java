package com.proyecto.projectsmapsstruts.mapper;

import com.proyecto.projectsmapsstruts.dto.GetProduct;
import com.proyecto.projectsmapsstruts.entity.Product;
import org.mapstruct.*;

import java.util.List;

//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "id", target = "idP"),
            @Mapping(source = "name", target = "nameP"),
            @Mapping(source = "creationDate", target = "creationDataP",
                    dateFormat = "yyyy-MM-dd HH:mm:ss")
    })

    GetProduct toGetDTO(Product product);

    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);

}
