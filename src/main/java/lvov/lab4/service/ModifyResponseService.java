package lvov.lab4.service;

import lvov.lab4.model.Response;
import org.springframework.stereotype.Service;

@Service
public interface ModifyResponseService {
    Response modify (Response response);
}
