package lvov.lab4.lab2.service;

import lvov.lab4.lab2.model.Request;
import org.springframework.stereotype.Service;

@Service
public interface ModifyRequestService {
    void modify(Request request);
}
