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
//    @PostMapping("/fetch-details")
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public ApiResponse2 fetchdetails(@RequestBody PaymentDto dto) {
//        return service.fetchAPI_YV_TPT_CUSTRTD(dto);
//    }

    @PostMapping("/fetch-details")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ApiResponse2 fetchdetails(@RequestBody PaymentDto dto) {
      if(dto.getService()==1)
        return service.YV_MATERIAL_MASTER_ALL_VIEWS(dto);
        else if(dto.getService()==2)
            return service.YV_EXCHG_RATE(dto);
        else if(dto.getService()==3)
            return service.YM_PO_DET_RFC_HO_LUBES(dto);//
        else if(dto.getService()==4)
            return service.YV_LU_PCK_RATE(dto);
        else if(dto.getService()==5)
             return service.YV_TPT_CFARATES(dto);
        else if(dto.getService()==6)
            return service.YV_TPT_CUSTRTD(dto);
        else if(dto.getService()==7)
            return service.YV_CONTRACT_RATES(dto);
        else if(dto.getService()==8)
            return service.Y_LUBEBOM_DNLD(dto);
                else
            return new ApiResponse2<>(false,"Incorrect Service",null,400);
    }
}
