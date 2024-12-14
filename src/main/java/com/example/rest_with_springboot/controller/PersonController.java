package com.example.rest_with_springboot.controller;

import com.example.rest_with_springboot.DTO.V1.PersonDTO;
import com.example.rest_with_springboot.DTO.V2.PersonDTOV2;
import com.example.rest_with_springboot.model.PersonModel;
import com.example.rest_with_springboot.services.PersonServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
@Tag(name="People", description = "Endpoints for manage People")
public class PersonController {

    private final PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }


    @Operation(
            summary = "Finds a people",
            description = "Finds a people",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(
                            description = "No content",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content
                    ),
            }
    )
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(
            @PathVariable(value = "id") Long id
            ){
        return service.findById(id);
    }

    @Operation(
            summary = "Finds all people",
            description = "Finds all people",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(
                                                    implementation = PersonDTO.class
                                            ))
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content
                    ),
            }
    )
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(
    ){
        return service.findAll();
    }

    @Operation(
            summary = "Adds a new person",
            description = "Adds a new person by passing the in a JSON",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Created",
                            responseCode = "201",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content
                    ),
            }
    )
    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person
    ){
        return service.create(person);
    }

    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person
    ){
        return service.createV2(person);
    }

    @Operation(
            summary = "Updats a person",
            description = "Updats a person by passing the in a JSON",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "Updated",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content
                    ),
            }
    )
    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO person
    ){
        return service.update(person);
    }


    @Operation(
            summary = "Delete a person",
            description = "Delete a person by passing the in a JSON",
            tags = {"People"},
            responses = {
                    @ApiResponse(
                            description = "No content",
                            responseCode = "204",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Bad Request",
                            responseCode = "400",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "401",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server Error",
                            responseCode = "500",
                            content = @Content
                    ),
            }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOnePerson(
            @PathVariable(value = "id") Long id
    ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
