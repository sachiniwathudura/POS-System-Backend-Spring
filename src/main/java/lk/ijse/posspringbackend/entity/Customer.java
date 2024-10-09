package lk.ijse.posspringbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.*;

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
}
