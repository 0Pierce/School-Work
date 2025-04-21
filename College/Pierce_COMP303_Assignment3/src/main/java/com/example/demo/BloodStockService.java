package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BloodStockService {

    private List<BloodStock> bloodStocks = new ArrayList<>();

    public List<BloodStock> getAllBloodStocks() {
        return bloodStocks;
    }

    public BloodStock addBloodStock(BloodStock bloodStock) {
        bloodStocks.add(bloodStock);
        return bloodStock;
    }

    public BloodStock updateBloodStock(Long id, BloodStock updatedBloodStock) {
        for (int i = 0; i < bloodStocks.size(); i++) {
            if (bloodStocks.get(i).getId().equals(id)) {
                bloodStocks.set(i, updatedBloodStock);
                return updatedBloodStock;
            }
        }
        return null; 
    }

    public void deleteBloodStock(Long id) {
        bloodStocks.removeIf(bloodStock -> bloodStock.getId().equals(id));
    }
}