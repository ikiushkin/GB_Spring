package lesson_six.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product_tbl")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "title_fld")
    private String title;
    @Column(name = "cost_fld")
    private int cost;

    @ManyToMany()
    @JoinTable(name = "customer_product_tbl",
            joinColumns = @JoinColumn(name = "product_fld"),
            inverseJoinColumns = @JoinColumn(name = "customer_fld"))
    private List<Customer> customerList;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
