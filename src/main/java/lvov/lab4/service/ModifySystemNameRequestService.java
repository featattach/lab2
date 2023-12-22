package lvov.lab4.service;

import lvov.lab4.model.Request;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ModifySystemNameRequestService implements ModifyRequestService {
    @Override
    public void modify(Request request) {
        //request.setSystemName("Service 1");
        //request.setSource("Modified Source in Service 1");


//        HttpEntity<Request> httpEntity = new HttpEntity<>(request);
//        new RestTemplate().exchange("http://localhost:8084/feedback",
//                HttpMethod.POST,
//                httpEntity,
//                new ParameterizedTypeReference<>() {
//                });
    }
}
