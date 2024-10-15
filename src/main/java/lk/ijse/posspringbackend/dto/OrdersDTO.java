package lk.ijse.posspringbackend.dto;

import lk.ijse.posspringbackend.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class OrdersDTO implements SuperDTO, OrderResponse {
    private String od_id;
    private LocalDate orderDate;
    private String id;
    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal cash;
    private BigDecimal balance;
    private List<OrderDetailsDTO> orderDetails;
}
