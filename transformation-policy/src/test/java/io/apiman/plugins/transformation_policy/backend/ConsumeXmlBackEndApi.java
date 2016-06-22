package io.apiman.plugins.transformation_policy.backend;

import io.apiman.gateway.engine.beans.ApiRequest;
import io.apiman.gateway.engine.beans.ApiResponse;
import io.apiman.test.policies.IPolicyTestBackEndApi;
import io.apiman.test.policies.PolicyTestBackEndApiResponse;

import org.junit.Assert;

@SuppressWarnings("nls")
public class ConsumeXmlBackEndApi implements IPolicyTestBackEndApi {

    @Override
    public PolicyTestBackEndApiResponse invoke(ApiRequest apiRequest, byte[] requestBody) {
        String body = new String(requestBody);
        Assert.assertEquals("<name>apiman</name>", body);
        ApiResponse apiResponse = new ApiResponse();
        return new PolicyTestBackEndApiResponse(apiResponse, null);
    }

}
