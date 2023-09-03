package com.proyecto.projectsmapsstruts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProduct {

    private long idP;
    private String nameP;
    private String creationDataP;

    private GetCategory category;

}
