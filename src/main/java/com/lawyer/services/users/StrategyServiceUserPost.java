package com.lawyer.services.users;

import com.lawyer.helpers.Helper;
import com.lawyer.models.User;
import com.lawyer.repository.RepositoryUser;
import com.lawyer.responses.ResponseBuilderUser;
import com.lawyer.services.StrategyService;
import com.lawyer.responses.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Service.
 */
@Service
public class StrategyServiceUserPost implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    @Autowired
    private Helper<User> helper;

    @Autowired
    private ResponseBuilderUser responseBuilderUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        helper.getList().add(helper.getEntity());
        User user = repositoryUser.findById(helper.getEntity().getId()).orElse(null);
        if (user == null) {
            repositoryUser.save(helper.getEntity());
            return responseBuilderUser.getResponseOkForPost();
        } else {
            return responseBuilderUser.getResponseConflict();
        }
    }
}
