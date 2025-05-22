package com.roustem.userService.business.abstracts;

import com.roustem.userService.entity.Claim;

public interface ClaimService {

    Claim getClaimByClaimName(String claimName);
}
