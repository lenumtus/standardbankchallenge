package za.co.standardbankchallenge.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import za.co.standardbankchallenge.api.response.BookResponse;
import za.co.standardbankchallenge.entities.BookEntity;

@Mapper(componentModel = "spring" , uses = {})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "isbn", target = "book_isbn")
    @Mapping(source = "description", target = "book_description")
    @Mapping(source = "author", target = "book_author")
    @Mapping(source = "title", target = "book_title")
    BookResponse bookTobookResponse(BookEntity bookEntity);
}
