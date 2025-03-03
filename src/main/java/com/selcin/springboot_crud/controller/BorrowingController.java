package com.selcin.springboot_crud.controller;

import com.selcin.springboot_crud.model.Borrowing;
import com.selcin.springboot_crud.service.BorrowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {
    private final BorrowingService borrowingService;

    public BorrowingController(BorrowingService borrowingService) {
        this.borrowingService = borrowingService;
    }

    @GetMapping
    public List<Borrowing> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowingById(@PathVariable Long id) {
        Borrowing borrowing = borrowingService.getBorrowingById(id);
        return borrowing != null ? ResponseEntity.ok(borrowing) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Borrowing createBorrowing(@RequestBody Borrowing borrowing) {
        return borrowingService.createBorrowing(borrowing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Borrowing> updateBorrowing(@PathVariable Long id, @RequestBody Borrowing borrowingDetails) {
        Borrowing updatedBorrowing = borrowingService.updateBorrowing(id, borrowingDetails);
        return updatedBorrowing != null ? ResponseEntity.ok(updatedBorrowing) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable Long id) {
        borrowingService.deleteBorrowing(id);
        return ResponseEntity.noContent().build();
    }
}
