package lk.ijse.posspringbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrderDetailsDTO implements SuperDTO {
    private String od_id;
    private String code;
    private BigDecimal unitPrice;
    private int qty;
}
