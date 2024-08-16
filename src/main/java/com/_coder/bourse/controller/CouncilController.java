package com._coder.bourse.controller;


import com._coder.bourse.dto.CouncilDto;
import com._coder.bourse.service.CouncilService;
import com._coder.bourse.util.CouncilUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/council" )
@RequiredArgsConstructor
public class CouncilController {

    private final CouncilService councilService;

    @Operation(summary = " create a council")
    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    //requestBody
    public ResponseEntity<String> createCouncil(
            @RequestParam("name") String councilName,
            @RequestParam("country") String country,
            @RequestParam("mayor") String mayorName,
            @RequestParam("email") String email,
            @RequestParam("region") String region,
            @RequestParam("image") MultipartFile imageCouncil
    ) {
        councilService.save(CouncilUtil.councilUtilDto
                (
                        councilName, country, mayorName,
                        email, region,imageCouncil
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(" COUNCIL SUCCESSFULLY CREATED !");
    }

    @Operation(summary = " get council by ID ")
    @GetMapping("/{council-id}")
    public ResponseEntity<CouncilDto> findCouncilById(@PathVariable("council-id") Integer id) {
        return ResponseEntity.ok(councilService.findById(id));
    }

    @Operation(summary = " find all council")
    @GetMapping("/")
    public ResponseEntity<List<CouncilDto>> findAllCouncil() {
        return ResponseEntity.ok(councilService.findAll());
    }

    @Operation(summary = " get council by ID ")
    @DeleteMapping("/{council-id}")
    public ResponseEntity<String> deleteCouncilById(@PathVariable("council-id") Integer id) {
        councilService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(" COUNCIL SUCCESSFULLY DELETED !");
    }


}
