package com.roustem.userService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.roustem.userService.entity.Claim;

public interface ClaimDao extends MongoRepository<Claim, String> {

    Claim getClaimByClaimName(String claimName);
}
