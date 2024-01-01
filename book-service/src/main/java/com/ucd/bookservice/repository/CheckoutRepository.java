package com.ucd.bookservice.repository;

import com.ucd.bookservice.model.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository extends JpaRepository<CheckOut, Long> {
}
