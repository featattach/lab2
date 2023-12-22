package lvov.lab4.service;

import lvov.lab4.exception.ValidationFailedException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
}
