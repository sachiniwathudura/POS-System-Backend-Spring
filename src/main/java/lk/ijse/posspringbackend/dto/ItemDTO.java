package lk.ijse.posspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO {
    private String code;
    private String name;
    private int qty;
    private BigDecimal price;
}
