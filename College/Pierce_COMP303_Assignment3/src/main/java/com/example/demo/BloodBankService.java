package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BloodBankService {

    private List<BloodBank> bloodBanks = new ArrayList<>();

    public List<BloodBank> getAllBloodBanks() {
        return bloodBanks;
    }

    public BloodBank addBloodBank(BloodBank bloodBank) {
        bloodBanks.add(bloodBank);
        return bloodBank;
    }

    public BloodBank updateBloodBank(Long id, BloodBank updatedBloodBank) {
        for (int i = 0; i < bloodBanks.size(); i++) {
            if (bloodBanks.get(i).getId().equals(id)) {
                bloodBanks.set(i, updatedBloodBank);
                return updatedBloodBank;
            }
        }
        return null;
    }

    public void deleteBloodBank(Long id) {
        bloodBanks.removeIf(bloodBank -> bloodBank.getId().equals(id));
    }
}