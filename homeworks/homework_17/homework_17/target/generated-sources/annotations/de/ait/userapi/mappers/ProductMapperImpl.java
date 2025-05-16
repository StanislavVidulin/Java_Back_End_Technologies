package de.ait.userapi.mappers;

import de.ait.userapi.dto.ProductRequestDto;
import de.ait.userapi.dto.ProductResponseDto;
import de.ait.userapi.model.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-15T18:11:27+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public List<ProductResponseDto> toResponseDtoList(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponseDto> list = new ArrayList<ProductResponseDto>( products.size() );
        for ( Product product : products ) {
            list.add( toResponseDto( product ) );
        }

        return list;
    }

    @Override
    public ProductResponseDto toResponseDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();

        productResponseDto.setId( product.getId() );
        productResponseDto.setTitle( product.getTitle() );
        productResponseDto.setPrice( product.getPrice() );

        return productResponseDto;
    }

    @Override
    public Product toProduct(ProductRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setTitle( dto.getTitle() );
        product.setPrice( dto.getPrice() );

        return product;
    }
}
