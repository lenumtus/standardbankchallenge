package za.co.standardbankchallenge.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity extends BaseEntity{


    private String isbn;
    private String description;
    private String title;
    private String author;
}
