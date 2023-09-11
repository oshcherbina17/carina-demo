package com.qaprosoft.carina.demo;

import java.lang.invoke.MethodHandles;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import com.qaprosoft.apitools.validation.JsonCompareKeywords;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.api.APIMethodPoller;
import com.qaprosoft.carina.demo.api.reqres.DeleteUsersMethod;
import com.qaprosoft.carina.demo.api.reqres.GetListUsersMethod;
import com.qaprosoft.carina.demo.api.reqres.PostLoginMethod;
import com.qaprosoft.carina.demo.api.reqres.PostRegisterMethod;
import com.qaprosoft.carina.demo.api.reqres.PutUserMethod;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class ApiReqresUserTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void testCreateRegister() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostRegisterMethod api = new PostRegisterMethod();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void testPutReqUser() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PutUserMethod api = new PutUserMethod();
        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 2)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void testCreateLogin() throws Exception {
        LOGGER.info("test");
        setCases("4555,54545");
        PostLoginMethod api = new PostLoginMethod();

        AtomicInteger counter = new AtomicInteger(0);

        api.callAPIWithRetry()
                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
                .peek(rs -> counter.getAndIncrement())
                .until(rs -> counter.get() == 4)
                .pollEvery(1, ChronoUnit.SECONDS)
                .stopAfter(10, ChronoUnit.SECONDS)
                .execute();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void testGetListUsers(){
        GetListUsersMethod api = new GetListUsersMethod();
        api.callAPIExpectSuccess();
        api.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
        api.validateResponseAgainstSchema("api/reqres/get/rs.schema");

    }

    @Test()
    @MethodOwner(owner = "oshcherbina")
    public void testDeleteUsers() {
        DeleteUsersMethod deleteUserMethod = new DeleteUsersMethod();
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }

}
