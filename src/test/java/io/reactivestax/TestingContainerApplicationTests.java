package io.reactivestax;

import io.reactivestax.entity.Book;
import io.reactivestax.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.JsonPathResultMatchers;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.hamcrest.CoreMatchers;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Duration;
import java.util.Optional;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testcontainers.shaded.org.awaitility.Awaitility.await;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@AutoConfigureMockMvc
class TestingContainerApplicationTests {
	@Test
	void contextLoads() {
	}

	static MySQLContainer<?> mysql=
			new MySQLContainer<>("mysql:8.0.27");

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		bookRepository.deleteAll();
		bookRepository.save(new Book(1, "book1", 12.25));
	}

	@Test
	void shouldReturnBooks() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/books"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", CoreMatchers.equalTo("book1")))
				.andExpect(jsonPath("$[0].price", CoreMatchers.equalTo(12.25)))
		;
	}

	@Test
	void shouldCreateBookSuccessfully() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/books")
						.contentType(MediaType.APPLICATION_JSON)
						.content("""
                            {
                                "name": "book-2",
                                "price": 25.50
                            }
                        """))
				.andExpect(status().isOk());

		await().pollInterval(Duration.ofSeconds(5)).atMost(30, SECONDS).untilAsserted(() -> {
			assertThat(bookRepository.findByName("book-2")).isNotEmpty();
		});
	}



}
