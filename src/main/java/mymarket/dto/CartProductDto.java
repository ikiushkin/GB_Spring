package mymarket.dto;

import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CartProductDto {
    private Long id;
    private String title;
    private int cost;
    private int count = 1;
}
