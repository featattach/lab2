package lvov.lab4.lab2.service;

import lvov.lab4.lab2.model.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Qualifier("ModifyOperationUidResponceService")
public class ModifyOperationUidResponceService implements ModifyResponseService {


@Override
public Response modify(Response response) {
    UUID uuid = UUID.randomUUID();
    response.setOperationUid(uuid.toString());
    return response;
}
}