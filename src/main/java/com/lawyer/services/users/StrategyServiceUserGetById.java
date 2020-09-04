package com.lawyer.services.users;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
import com.lawyer.repository.RepositoryUser;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyServiceUserGetById implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private Helper<User> helper;

    @Autowired
    private ResponseBuilder<User> responseBuilder;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        User user = repositoryUser.findById(helper.getId()).orElse(null);
        // Negative scenario
        if (user == null) {
          return responseBuilder.getResponseNotFound();
        }
        // Positive scenario 
        helper.getList().add(user);
        return responseBuilder.getResponseOkForGet();  
    }
}
