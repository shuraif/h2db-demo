package com.ms.h2db.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.h2db.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
