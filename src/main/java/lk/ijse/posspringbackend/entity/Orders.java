package lk.ijse.posspringbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Orders implements SuperEntity {
    @Id
    @Pattern(regexp = "O\\d{3,}", message = "Order ID must follow the pattern OXXX (e.g., O001)")
    private String orderId;
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Customer customer;

    private BigDecimal total;
    private BigDecimal discount;
    private BigDecimal subTotal;
    private BigDecimal cash;
    private BigDecimal balance;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails = new ArrayList<>();
}
