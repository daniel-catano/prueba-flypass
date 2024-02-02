package dcatano.infraestructure.database.client;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class DBPage<T> {
	private final List<T> results;
	private final int totalPages;
}
