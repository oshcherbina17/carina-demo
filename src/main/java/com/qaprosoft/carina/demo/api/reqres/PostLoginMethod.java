package com.qaprosoft.carina.demo.api.reqres;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}/login", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/reqres/postLogin/rq.json")
@ResponseTemplatePath(path = "api/reqres/postLogin/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostLoginMethod extends AbstractApiMethodV2 {

    public PostLoginMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
