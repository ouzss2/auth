package com.mosofty.crm.service;

 
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mosofty.crm.dto.AuthorView;
import com.mosofty.crm.dto.EditAuthorRequest;
import com.mosofty.crm.dto.Page;
import com.mosofty.crm.dto.SearchAuthorsQuery;
import com.mosofty.crm.mapper.AuthorEditMapper;
import com.mosofty.crm.mapper.AuthorViewMapper;
import com.mosofty.crm.repository.AuthorRepo;
import com.mosofty.crm.repository.BookRepo;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthorService {

  private final AuthorRepo authorRepo;
  private final BookRepo bookRepo;
  private final AuthorEditMapper authorEditMapper;
  private final AuthorViewMapper authorViewMapper;

  @Transactional
  public AuthorView create(EditAuthorRequest request) {
    var author = authorEditMapper.create(request);

    author = authorRepo.save(author);

    return authorViewMapper.toAuthorView(author);
  }

  @Transactional
  public AuthorView update(ObjectId id, EditAuthorRequest request) {
    var author = authorRepo.getById(id);
    authorEditMapper.update(request, author);

    author = authorRepo.save(author);

    return authorViewMapper.toAuthorView(author);
  }

  @Transactional
  public AuthorView delete(ObjectId id) {
    var author = authorRepo.getById(id);

    authorRepo.delete(author);
    bookRepo.deleteAll(bookRepo.findAllById(author.getBookIds()));

    return authorViewMapper.toAuthorView(author);
  }

  public AuthorView getAuthor(ObjectId id) {
    return authorViewMapper.toAuthorView(authorRepo.getById(id));
  }

  public List<AuthorView> getAuthors(Iterable<ObjectId> ids) {
    return authorViewMapper.toAuthorView(authorRepo.findAllById(ids));
  }
  
  public List<AuthorView> getAuthors( ) {
	    return authorViewMapper.toAuthorView(authorRepo.findAll());
	  }

  public List<AuthorView> getBookAuthors(ObjectId bookId) {
    var book = bookRepo.getById(bookId);
    return authorViewMapper.toAuthorView(authorRepo.findAllById(book.getAuthorIds()));
  }

  public List<AuthorView> searchAuthors(Page page, SearchAuthorsQuery query) {
    return authorViewMapper.toAuthorView(authorRepo.searchAuthors(page, query));
  }
}
