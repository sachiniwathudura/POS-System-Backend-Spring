package lk.ijse.posspringbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item implements SuperEntity {
    @Id
    @Pattern(regexp = "I\\d{3}", message = "Item code must follow the pattern CXXX (e.g., I001)")
    private String code;
    private String name;
    private int qty;
    private BigDecimal price;
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;

}
