package com.qaprosoft.carina.demo.api.reqres;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.api.annotation.Endpoint;
import com.qaprosoft.carina.core.foundation.api.annotation.RequestTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.ResponseTemplatePath;
import com.qaprosoft.carina.core.foundation.api.annotation.SuccessfulHttpStatus;
import com.qaprosoft.carina.core.foundation.api.http.HttpMethodType;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

@Endpoint(url = "${base_url}/register", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/reqres/postRegister/rq.json")
@ResponseTemplatePath(path = "api/reqres/postRegister/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostRegisterMethod extends AbstractApiMethodV2 {

    public PostRegisterMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
    }
}
