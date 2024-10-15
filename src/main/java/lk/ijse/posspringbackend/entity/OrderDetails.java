package lk.ijse.posspringbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_detail")
@Entity
public class OrderDetails implements SuperEntity{
    @Id
    @Pattern(regexp = "OD\\d{3,}", message = "Order Detail ID must follow the pattern ODXXX (e.g., OD001)")
    private String od_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code", nullable = false)
    private Item item;

    private BigDecimal unitPrice;
    private int qty;
}
