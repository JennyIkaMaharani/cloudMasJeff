package com.example.serverlayanglayang.controller;
import com.example.serverlayanglayang.dto.InputDto;
import com.example.serverlayanglayang.service.CalculatorService;
import com.example.serverlayanglayang.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @RequestMapping(value = "/calc", method = RequestMethod.POST)
    public ResponseEntity<OutputDto> calculatorEndPoint(@RequestBody InputDto input){
        double result = calculatorService.calculateResult(input);
        OutputDto output = new OutputDto();
        output.setA(input.getA());
        output.setB(input.getB());
        output.setJenisPerhitungan("LayangLayang");
        output.setResult(result);
        return ResponseEntity.ok(output);
    }

}
