package com.example.serversegitiga.controller;
import com.example.serversegitiga.dto.InputDto;
import com.example.serversegitiga.dto.OutputDto;
import com.example.serversegitiga.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        output.setJenisPerhitungan("Segitiga");
        output.setResult(result);
        return ResponseEntity.ok(output);
    }
}
