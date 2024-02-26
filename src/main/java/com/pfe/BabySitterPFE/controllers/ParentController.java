package com.pfe.BabySitterPFE.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
@Tag(name = "Parent")
public class ParentController {
    @Operation(
            description = "Get endpoint for Parent",
            summary = "This is a summary for parent get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }

    )
    @GetMapping
    public String get() {
        return "GET:: parent controller";
    }
    @PostMapping
    public String post() {
        return "POST:: parent controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: parent controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: parent controller";
    }
}