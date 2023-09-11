package za.co.standardbankchallenge.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> items = new ArrayList<>();
    private int totalPage  , size,currentpage;
    private Long  totalElements;
}
