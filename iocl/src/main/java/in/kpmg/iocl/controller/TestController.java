package in.kpmg.iocl.controller;

import in.kpmg.iocl.dto.ApiResponse2;
import in.kpmg.iocl.dto.PaymentDto;
import in.kpmg.iocl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    TestService service;
    @PostMapping("/fetch-details-with-txn")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ApiResponse2 fetchdetails(@RequestBody PaymentDto dto) {
        return service.fetchAPI_YV_TPT_CUSTRTD(dto);
    }
}
