
package com.wbd.dorayakisupplier;

import com.wbd.dorayakisupplier.model.Recipe;
import com.wbd.dorayakisupplier.model.RecipeList;
import com.wbd.dorayakisupplier.model.Request;
import com.wbd.dorayakisupplier.model.RequestList;
import com.wbd.dorayakisupplier.request.GetRequestsRequest;
import com.wbd.dorayakisupplier.request.RestockRequest;
import com.wbd.dorayakisupplier.response.GetRecipesResponse;
import com.wbd.dorayakisupplier.response.GetRequestsResponse;
import com.wbd.dorayakisupplier.response.MessageResponse;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.wbd.dorayakisupplier package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wbd.dorayakisupplier
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRequestsRequest }
     *
     */
    public GetRequestsRequest createGetRequestsRequest() {
        return new GetRequestsRequest();
    }

    /**
     * Create an instance of {@link MessageResponse }
     *
     */
    public MessageResponse createMessageResponse() {
        return new MessageResponse();
    }

    /**
     * Create an instance of {@link Request }
     *
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link GetRequestsResponse }
     *
     */
    public GetRequestsResponse createGetRequestsResponse() {
        return new GetRequestsResponse();
    }

    /**
     * Create an instance of {@link RequestList }
     *
     */
    public RequestList createRequestList() {
        return new RequestList();
    }

    /**
     * Create an instance of {@link GetRecipesResponse }
     *
     */
    public GetRecipesResponse createGetRecipesResponse() {
        return new GetRecipesResponse();
    }

    /**
     * Create an instance of {@link RecipeList }
     *
     */
    public RecipeList createRecipeList() {
        return new RecipeList();
    }

    /**
     * Create an instance of {@link RestockRequest }
     *
     */
    public RestockRequest createRestockRequest() {
        return new RestockRequest();
    }

    /**
     * Create an instance of {@link Recipe }
     *
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

}
