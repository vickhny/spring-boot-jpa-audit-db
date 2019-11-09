package com.example.SpringDataEnversAuditApplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.example.SpringDataEnversAuditApplication.entity.Book;

public interface BookRepo extends RevisionRepository<Book, Integer, Integer>, JpaRepository<Book, Integer> {
}
