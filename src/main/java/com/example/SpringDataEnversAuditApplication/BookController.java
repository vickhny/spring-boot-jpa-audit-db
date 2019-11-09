package com.example.SpringDataEnversAuditApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDataEnversAuditApplication.entity.Book;
import com.example.SpringDataEnversAuditApplication.repo.BookRepo;

@RestController
public class BookController {

	@Autowired
	private BookRepo repository;

	@PostMapping("/saveBook")
	public Book saveBook(@RequestBody Book book) {
		return repository.save(book);
	}

	@PutMapping("/update/{id}/{pages}")
	public String updateBook(@PathVariable int id, @PathVariable int pages) {
		Book book = repository.findById(id).get();
		book.setPages(pages);
		repository.save(book);
		return "book updated";
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		repository.deleteById(id);
		return "book deleted";
	}

	@GetMapping("/getInfo/{id}")
	public String getInfo(@PathVariable int id) {
		System.out.println(repository.findLastChangeRevision(id));
		return repository.findLastChangeRevision(id).get().toString();
	}

}
