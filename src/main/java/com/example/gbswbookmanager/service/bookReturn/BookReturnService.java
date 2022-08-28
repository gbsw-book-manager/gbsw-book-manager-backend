package com.example.gbswbookmanager.service.bookReturn;

import com.example.gbswbookmanager.dto.BookReturnDetialDto;
import com.example.gbswbookmanager.dto.BookReturnDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookReturnService {

    public Boolean checkBookReturn(BookReturnDto bookReturnDto);

    public List<BookReturnDetialDto> getBookReturns();

    // 사용자가 반납 신청을 함
    public void bookReturn(BookReturnDto bookReturnDto);

    public void bookReturnApproval(Long returnId);

}
