package za.co.standardbankchallenge.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity extends BaseEntity{


    private double amount;
    private int quantity;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", name = "book_id")
    private BookEntity bookEntity;
}
