/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.6.0-SNAPSHOT).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ClientDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.6.0-SNAPSHOT")
@Validated
@Api(value = "fake_classname_tags 123#$%^", description = "the fake_classname_tags 123#$%^ API")
public interface FakeClassnameTestApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PATCH /fake_classname_test : To test class name in snake case
     * To test class name in snake case
     *
     * @param clientDto client model (required)
     * @return successful operation (status code 200)
     */
    @ApiOperation(
        tags = { "fake_classname_tags 123#$%^" },
        value = "To test class name in snake case",
        nickname = "testClassname",
        notes = "To test class name in snake case",
        response = ClientDto.class,
        authorizations = {
            @Authorization(value = "api_key_query")
         }
    )
    @ApiResponses({
        @ApiResponse(code = 200, message = "successful operation", response = ClientDto.class)
    })
    @RequestMapping(
        method = RequestMethod.PATCH,
        value = "/fake_classname_test",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<ClientDto> testClassname(
        @ApiParam(value = "client model", required = true) @Valid @RequestBody ClientDto clientDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"client\" : \"client\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
