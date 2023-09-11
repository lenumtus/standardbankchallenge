package za.co.standardbankchallenge.entities;


import lombok.Data;
import org.hibernate.annotations.*;


import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @UpdateTimestamp
    private Date update_date;
    @Column(updatable = false)
    @CreationTimestamp
    private Date create_date;

    public BaseEntity() {
        this.id = UUID.randomUUID();
    }

}

