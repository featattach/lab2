package lvov.lab4.lab2.service;

import lvov.lab4.lab2.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify (Response response);
}
