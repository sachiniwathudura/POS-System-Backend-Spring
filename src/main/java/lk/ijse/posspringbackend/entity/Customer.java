package lk.ijse.posspringbackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer implements SuperEntity {
    @Id
    @Pattern(regexp = "C\\d{3}", message = "Customer ID must follow the pattern CXXX (e.g., C001)")
    private String id;
    private String name;
    private String address;
    private Double salary;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Orders> orders;
}
