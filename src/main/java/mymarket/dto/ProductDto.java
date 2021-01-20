package mymarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mymarket.entity.Product;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int cost;

    public ProductDto(Product p){
        this.id= p.getId();
        this.title= p.getTitle();
        this.cost= p.getCost();

    }
}
