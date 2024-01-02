package com.example.serverlayanglayang.service;


import com.example.serverlayanglayang.dto.InputDto;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculateResult(InputDto input){
        return input.getA() * input.getB() / 2;
    }
}
