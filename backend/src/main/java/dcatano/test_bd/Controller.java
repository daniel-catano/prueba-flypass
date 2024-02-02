package dcatano.test_bd;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class Controller {
	private final PersonRepository personRepository;

	@GetMapping
	public ResponseEntity<List<Person>> findAll() {
		Iterator<Person> personList = personRepository.findAll().iterator();
		return ResponseEntity.ok(StreamSupport.stream(Spliterators.spliteratorUnknownSize(personList, Spliterator.ORDERED), false).toList());
	}

	@PostMapping
	public void save(@RequestBody Person person) {
		personRepository.save(person);
	}
}

