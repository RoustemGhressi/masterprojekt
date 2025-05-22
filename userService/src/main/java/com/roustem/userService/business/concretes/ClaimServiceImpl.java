package com.roustem.userService.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.roustem.userService.business.abstracts.ClaimService;
import com.roustem.userService.dao.ClaimDao;
import com.roustem.userService.entity.Claim;

@Service
@RequiredArgsConstructor
public class ClaimServiceImpl implements ClaimService {

    private final ClaimDao claimDao;

    @Override
    public Claim getClaimByClaimName(String claimName) {
        return claimDao.getClaimByClaimName(claimName);
    }
}
