package com.kevin.spring.security.postgresql.controllers;

import com.kevin.spring.security.postgresql.payload.response.BorrowingRecordRes;
import com.kevin.spring.security.postgresql.service.BorrowingRecordService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/borrowingRecord")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;


    @GetMapping("/record/{inventoryId}/user/{userId}")
    public ResponseEntity<List<BorrowingRecordRes>> getBookStatus(@PathVariable("inventoryId") @NotBlank Long inventoryId, @PathVariable("userId") @NotBlank Long userId) {
        List<BorrowingRecordRes> res = borrowingRecordService.getRetunTimeNullborrowingRecordRes(inventoryId, userId);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
