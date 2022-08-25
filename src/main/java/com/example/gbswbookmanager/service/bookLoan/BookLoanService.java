package com.example.gbswbookmanager.service.bookLoan;

import com.example.gbswbookmanager.dto.LoanDetailDto;
import com.example.gbswbookmanager.dto.LoanDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookLoanService {

    // 대출하기를 눌렀을 때 이미 빌린 책이 포함되어 있는 지 학인
    public Boolean checkBookLoan(LoanDto loanDto);

    // 모든 대출 리스트 가져오기
    public List<LoanDetailDto> getBookLoanList();

    // 사용자가 책을 빌림
    public void bookLoan(LoanDto loanDto);

    // 관리자가 책 대출 신청을 승인함
    public void loanApproval(Long id) throws Exception;

}
