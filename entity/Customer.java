package lesson_six.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "customer_tbl")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "name_fld")
    private String name;
    @ManyToMany()
    @JoinTable(name = "customer_product_tbl",
            joinColumns = @JoinColumn(name = "customer_fld"),
            inverseJoinColumns = @JoinColumn(name = "product_fld"))
    private List<Product> productList;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
