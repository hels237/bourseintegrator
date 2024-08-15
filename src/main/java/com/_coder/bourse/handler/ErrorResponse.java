package com._coder.bourse.handler;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String messageError;
    private Integer httpErrorStatus;
    private Set<String> msgViolations = new HashSet<>();

}
