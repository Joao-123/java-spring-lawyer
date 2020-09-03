package com.lawyer.services.users;

import com.lawyer.helpers.HelperUser;
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
public class StrategyServiceUserGet implements StrategyService {

    @Autowired
    private RepositoryUser repositoryUser;

    /**
     * Constructor.
     */
    public StrategyServiceUserGet() {
    }

    @Autowired
    private HelperUser helperUser;

    @Autowired
    private ResponseBuilderUser responseBuilderUser;

    /**
     * {@inheritDoc}
     */
    @Override
    public Response getResponse() {
        Iterable<User> iterable = this.repositoryUser.findAll();
        //helperUser.getEmptyList();
        iterable.forEach(helperUser.getList()::add);
        return responseBuilderUser.getResponseOkForGet();
    }
}
