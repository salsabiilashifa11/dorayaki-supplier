package com.wbd.dorayakisupplier.service;

import com.sun.net.httpserver.HttpExchange;
import com.sun.xml.internal.ws.developer.JAXWSProperties;
import com.wbd.dorayakisupplier.httpclient.HttpClient;
import com.wbd.dorayakisupplier.model.RecipeList;
import com.wbd.dorayakisupplier.model.Request;
import com.wbd.dorayakisupplier.model.RequestList;
import com.wbd.dorayakisupplier.repository.DBConnector;
import com.wbd.dorayakisupplier.repository.RequestLogRepository;
import com.wbd.dorayakisupplier.request.GetRequestsRequest;
import com.wbd.dorayakisupplier.response.GetRecipesResponse;
import com.wbd.dorayakisupplier.response.GetRequestsResponse;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(name = "DorayakiSupplierService", targetNamespace = "http://dorastore.com/",
        endpointInterface = "com.wbd.dorayakisupplier.service.DorayakiSupplierService")
public class DorayakiSupplierServiceImpl implements DorayakiSupplierService {

    @Resource
    private WebServiceContext webServiceContext;

    private final HttpClient httpClient = new HttpClient();

    private final RequestLogRepository requestLogRepository;

    private static final int REQUEST_LIMIT = 5;

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public DorayakiSupplierServiceImpl() {
        Connection dbConnection = DBConnector.getConnection();
        requestLogRepository = new RequestLogRepository(dbConnection);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            DBConnector.closeConnection(dbConnection);
        }));
    }

    @WebMethod
    public GetRecipesResponse getRecipes() {
        GetRecipesResponse response = new GetRecipesResponse();
        RecipeList recipeList = httpClient.getAllRecipes();

        response.setCode(200);
        response.setMessage("OK");
        response.setData(recipeList);

        return response;
    }

    @WebMethod
    public GetRequestsResponse getRequests(GetRequestsRequest parameters) {
        GetRequestsResponse response = new GetRequestsResponse();
        RequestList requestList = httpClient.getAllRequests();

        response.setCode(200);
        response.setMessage("OK");
        response.setData(requestList);

        return response;
    }

    @WebMethod
    public void restockRequest(int recipeId, int quantity, Holder<Integer> code, Holder<String> message, Holder<Request> data) {
        MessageContext messageContext = webServiceContext.getMessageContext();

        HttpExchange httpExchange = (HttpExchange) messageContext.get(JAXWSProperties.HTTP_EXCHANGE);
        String sourceIpAddress = httpExchange.getRemoteAddress().getAddress().getHostAddress();
        String endpoint = httpExchange.getRequestURI().getPath();

        int requestLogCount = requestLogRepository.countRequest(sourceIpAddress, endpoint, 90);
        LOGGER.log(Level.INFO, String.format("Request log count for IP Address %s, endpoint %s: %d",
                sourceIpAddress, endpoint, requestLogCount));

        if (requestLogCount > REQUEST_LIMIT) {
            code.value = 403;
            message.value = "Request limit has reached, try again in 1 minute";
            data.value = null;
            return;
        }

        requestLogRepository.createRequestLog(sourceIpAddress, endpoint);
        Request request = httpClient.createNewRequest(recipeId, quantity);

        if (request != null) {
            code.value = 200;
            message.value = "OK";
            data.value = request;
        } else {
            code.value = 500;
            message.value = "Something went wrong";
            data.value = null;
        }
    }

//    @WebMethod
//    public void restockRequest(int recipeId, int quantity, Holder<Integer> code, Holder<String> message) {
//        MessageContext messageContext = webServiceContext.getMessageContext();
//
//        HttpExchange httpExchange = (HttpExchange) messageContext.get(JAXWSProperties.HTTP_EXCHANGE);
//        String sourceIpAddress = httpExchange.getRemoteAddress().getAddress().getHostAddress();
//        String endpoint = httpExchange.getRequestURI().getPath();
//
//        int requestLogCount = requestLogRepository.countRequest(sourceIpAddress, endpoint, 90);
//        LOGGER.log(Level.INFO, String.format("Request log count for IP Address %s, endpoint %s: %d",
//                sourceIpAddress, endpoint, requestLogCount));
//
//        if (requestLogCount > REQUEST_LIMIT) {
//            code.value = 403;
//            message.value = "Request limit has reached, try again in 1 minute";
//            return;
//        }
//
//        requestLogRepository.createRequestLog(sourceIpAddress, endpoint);
//        Request request = httpClient.createNewRequest(recipeId, quantity);
//
//        if (request != null) {
//            code.value = 200;
//            message.value = "OK";
//        } else {
//            code.value = 500;
//            message.value = "Something went wrong";
//        }
//    }
}
