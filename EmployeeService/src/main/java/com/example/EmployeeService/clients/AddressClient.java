package com.example.EmployeeService.clients;

import com.example.EmployeeService.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class AddressClient {

    @Autowired
    RestTemplate restTemplate;

    public void saveAddress(List<Address> addresses, Integer empId) {

        addresses.forEach(a -> {
            a.setEmpId(empId);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<Address> httpEntity = new HttpEntity<Address>(a,httpHeaders);
            restTemplate.exchange("http://localhost:8081/Address", HttpMethod.POST, httpEntity, String.class);
        });
    }
}
