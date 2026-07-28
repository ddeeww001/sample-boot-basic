package th.mfu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // impror RequestMapping ต้องมี RestController ด้วยเพื่อให้ class นี้เป็น
                // controller ของ spring boot
@RequestMapping("/api") // import RestController
public class BookControllor {
    // db จำลองเก็บข้อมูลเป็น Map<Long,Book> โดยใช้ id เป็น key และ Book เป็น value
    public static Map<Long, Book> bookMap = new HashMap<>();
    private static long nextId = 1; // id ถัดไปที่จะใช้สำหรับ book ใหม่

    // create new book
    @PostMapping("/books") // import PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        long id = nextId++;
        book.setId(id);
        bookMap.put(id, book);
        return new ResponseEntity<String>("Book created successfully with ID: " + id, HttpStatus.CREATED);
    }

    // list all books
    @GetMapping("/books")
    public ResponseEntity<Collection> listBook() {
        return new ResponseEntity<>(bookMap.values(), HttpStatus.OK);
    }

    // Get book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable long id) {
        Book book = bookMap.get(id);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    // Delete book by id
    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable long id) {
        Book book = bookMap.remove(id);
        if (book == null) {
            return new ResponseEntity<>("Book not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Book deleted successfully with ID: " + id, HttpStatus.OK);
    }
}
