package com.ucd.bookservice.repository;

import com.ucd.bookservice.model.Return;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<Return, Long> {
}
