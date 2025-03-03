package com.selcin.springboot_crud.service;

import com.selcin.springboot_crud.model.Borrowing;
import com.selcin.springboot_crud.repository.BorrowingRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingServiceImpl implements BorrowingService {
    private final BorrowingRepository borrowingRepository;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    @Override
    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    @Override
    public Borrowing getBorrowingById(Long id) {
        return borrowingRepository.findById(id).orElse(null);
    }

    @Override
    public Borrowing createBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing updateBorrowing(Long id, Borrowing borrowingDetails) {
        Optional<Borrowing> borrowing = borrowingRepository.findById(id);
        if (borrowing.isPresent()) {
            Borrowing updatedBorrowing = borrowing.get();
            updatedBorrowing.setBorrowDate(borrowingDetails.getBorrowDate());
            updatedBorrowing.setReturnDate(borrowingDetails.getReturnDate());
            return borrowingRepository.save(updatedBorrowing);
        }
        return null;
    }

    @Override
    public void deleteBorrowing(Long id) {
        borrowingRepository.deleteById(id);
    }
}
