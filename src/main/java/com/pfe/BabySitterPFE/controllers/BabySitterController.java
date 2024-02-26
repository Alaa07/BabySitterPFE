package com.pfe.BabySitterPFE.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/babySitter")
@Tag(name = "BabySitter")
public class BabySitterController {
    @Operation(
            description = "Get endpoint for BabySitter",
            summary = "This is a summary for BabySitter get endpoint",
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
        return "GET:: babySitter controller";
    }
    @PostMapping
    public String post() {
        return "POST:: babySitter controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: babySitter controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: babySitter controller";
    }
}
