package com.lawyer.services.users;

import com.lawyer.models.User;
import com.lawyer.helpers.Helper;
import com.lawyer.repository.RepositoryUser;
import com.lawyer.responses.ResponseBuilder;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service.
 */
@Service
public class StrategyServiceUserDelete implements StrategyService {

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
        // Negative scenario
        if (repositoryUser.findById(helper.getId()).orElse(null) == null) {
            return responseBuilder.getResponseNotFound();   
        }
        // Positive scenario
        repositoryUser.deleteById(helper.getId());
        return responseBuilder.getResponseOkForDelete();
    }
}
