package com.example.gateserver.controller;
import com.example.gateserver.dto.TransferDto;
import com.example.gateserver.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping(method = RequestMethod.GET)
public class GateController {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @GetMapping("/{a}/{b}/{jenisPerhitungan}")
    public ResponseEntity<ResultDto> calculatorEndPoint(@PathVariable("a") Integer a,
                                                        @PathVariable("b") Integer b,
                                                        @PathVariable("jenisPerhitungan") String jenisPerhitungan)
    {
        ServiceInstance serviceInstance = new ServiceInstance() {
            @Override
            public String getServiceId() {
                return null;
            }

            @Override
            public String getHost() {
                return null;
            }

            @Override
            public int getPort() {
                return 0;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public URI getUri() {
                return null;
            }

            @Override
            public Map<String, String> getMetadata() {
                return null;
            }
        };
        TransferDto transferDto = new TransferDto();
        transferDto.setA(a);
        transferDto.setB(b);
        if(jenisPerhitungan.equals("LayangLayang")){
            serviceInstance = loadBalancer.choose("layang-layang-server");
        } else if (jenisPerhitungan.equals("Segitiga")) {
            serviceInstance = loadBalancer.choose("segitiga-server");
        } else if (jenisPerhitungan.equals("PersegiPanjang")) {
            serviceInstance = loadBalancer.choose("Persegi_panjang-Server");

        }
        String selectedUrl = serviceInstance.getUri().toString();
        String baseUrl = selectedUrl+"/calc";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResultDto> response = restTemplate.postForEntity(baseUrl, transferDto, ResultDto.class);
        ResultDto resultDto = response.getBody();
        return ResponseEntity.ok(resultDto);
    }
}
