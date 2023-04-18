package io.reactivestax.controller;

import io.reactivestax.entity.Book;
import io.reactivestax.model.AuthenticateRequest;
import io.reactivestax.model.AuthenticateResponse;
import io.reactivestax.repository.BookRepository;
import io.reactivestax.service.MyUserDetailsService;
import io.reactivestax.utils.JwtUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password: ");
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticateResponse(jwt));

    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        log.info("**** saving book ***** ");
        log.info("book is: "+book);
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> findBooks() {
        log.info("**** fetching all books ***** ");
        return bookRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public Book findBook(@PathVariable int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));
        return book;
    }


}
