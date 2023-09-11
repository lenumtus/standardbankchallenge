package za.co.standardbankchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.standardbankchallenge.entities.BookEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> {


    Optional<BookEntity> findByIsbn(String isbn);
}
