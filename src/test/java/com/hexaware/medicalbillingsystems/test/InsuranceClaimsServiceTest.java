package com.hexaware.medicalbillingsystems.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.medicalbillingsystems.dto.InsuranceClaimsDTO;
import com.hexaware.medicalbillingsystems.repository.InsuranceClaimsRepository;
import com.hexaware.medicalbillingsystems.service.InsuranceClaimsServiceImp;

@SpringBootTest
public class InsuranceClaimsServiceTest {

    @Autowired
    private InsuranceClaimsRepository claimsRepository;

   @Autowired
    private InsuranceClaimsServiceImp claimsService;

    @Test
    public void testInsertClaims() {
        InsuranceClaimsDTO newClaim = new InsuranceClaimsDTO();

        claimsService.insertClaims(newClaim);

        
        verify(claimsRepository, times(1)).save(newClaim);
    }

    @Test
    public void testUpdateClaims() {
        long claimId = 1L;
        InsuranceClaimsDTO updatedClaim = new InsuranceClaimsDTO(/* add relevant data */);

        when(claimsRepository.findById(claimId)).thenReturn(Optional.of(new InsuranceClaimsDTO()));

        claimsService.updateClaims(updatedClaim, claimId);

        
        verify(claimsRepository, times(1)).save(updatedClaim);
    }

    @Test
    public void testGetById() {
        long claimId = 1L;
        InsuranceClaimsDTO claim = new InsuranceClaimsDTO(/* add relevant data */);

        when(claimsRepository.findById(claimId)).thenReturn(Optional.of(claim));

        InsuranceClaimsDTO result = claimsService.getById(claimId);

        // Verify that the result is the same as the one returned by the repository
        assertEquals(claim, result);
    }

    @Test
    public void testGetTotalPendingInsuranceClaims() {
        String claimStatus = "Pending";

        when(claimsRepository.countByClaimStatus(claimStatus)).thenReturn(5L);

        long result = claimsService.getTotalPendingInsuranceClaims(claimStatus);

        
        assertEquals(5L, result);
    }

    @Test
    public void testGetTotalApprovedClaims() {
        String claimStatus = "Approved";

        when(claimsRepository.countByClaimStatus(claimStatus)).thenReturn(10L);

        long result = claimsService.getTotalApprovedClaims(claimStatus);

        
        assertEquals(10L, result);
    }

    @Test
    public void testGetAllInsuranceClaims() {
        List<InsuranceClaimsDTO> claimsList = new ArrayList<>();
       

        when(claimsRepository.findAll()).thenReturn(claimsList);

        List<InsuranceClaimsDTO> result = claimsService.getAllInsuranceClaims();

        
        assertEquals(claimsList, result);
    }
}