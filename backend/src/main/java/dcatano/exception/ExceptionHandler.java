
package dcatano.exception;

import dcatano.infraestructure.controller.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler extends Exception {
    @org.springframework.web.bind.annotation.ExceptionHandler({LenghExceededException.class, NoDataFoundException.class})
    public ResponseEntity<Response> processException(Exception ex) {
        return ResponseEntity.badRequest().body(new Response(ex.getMessage()));
    }

}