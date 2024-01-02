package com.example.serverpersegipanjang.service;

import org.springframework.stereotype.Service;
import com.example.serverpersegipanjang.dto.InputDto;
@Service
public class CalculatorService {
    public double calculateResult(InputDto input) {
        return input.getA() * input.getB();
    }
}
