package com.roustem.userService.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


@Data
@Document
@Builder
public class Claim {

    @Id
    private String claimId;
    private String claimName;

    @JsonCreator
    public Claim(@JsonProperty("claimId") String claimId,
                 @JsonProperty("claimName") String claimName) {
        this.claimId = claimId;
        this.claimName = claimName;
    }
}
