package dcatano.infraestructure.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PaginatedResponse<T>{
	private List<T> results;
	private int totalPages;
}
