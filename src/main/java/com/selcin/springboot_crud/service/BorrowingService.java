package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.Borrowing;
import java.util.List;

public interface BorrowingService {
    List<Borrowing> getAllBorrowings();
    Borrowing getBorrowingById(Long id);
    Borrowing createBorrowing(Borrowing borrowing);
    Borrowing updateBorrowing(Long id, Borrowing borrowingDetails);
    void deleteBorrowing(Long id);
}
