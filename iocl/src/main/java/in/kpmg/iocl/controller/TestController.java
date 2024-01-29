package in.kpmg.iocl.controller;

import in.kpmg.iocl.dto.ApiResponse2;
import in.kpmg.iocl.dto.PaymentDto;
import in.kpmg.iocl.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestController {
    @Autowired
    TestService service;
    @Autowired
    private Environment environment;

////////////////////////below can be used to test apis from postman//////////////////
    //        @PostMapping("/fetch-details")
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//    public ApiResponse2 fetchdetails(@RequestBody PaymentDto dto) {
//     //  System.out.println("Inside controller...........................");
//        if(dto.getService()==1)
//        return service.YV_MATERIAL_MASTER_ALL_VIEWS(dto);
//        else if(dto.getService()==2) {
//            return service.YV_EXCHG_RATE(dto);
//        }
//        else if(dto.getService()==3)
//            return service.YM_PO_DET_RFC_HO_LUBES(dto);//
//        else if(dto.getService()==4)
//            return service.YV_LU_PCK_RATE(dto);
//        else if(dto.getService()==5)
//             return service.YV_TPT_CFARATES(dto);
//        else if(dto.getService()==6)
//            return service.YV_TPT_CUSTRTD(dto);
//        else if(dto.getService()==7)
//            return service.YV_CONTRACT_RATES(dto);
//        else if(dto.getService()==8)
//            return service.Y_LUBEBOM_DNLD(dto);
//                else
//            return new ApiResponse2<>(false,"Incorrect Service",null,400);
//    }


   // @GetMapping("/fetch-details")
    public List<ApiResponse2> fetchdetails() {
        ApiResponse2 response = null;
        boolean isError = false;
        List<ApiResponse2> finalResult = new ArrayList<>();
        for (int serviceNumber = 1; serviceNumber <= 8; serviceNumber++) {
            try {
                switch (serviceNumber) {
                    case 1: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_FROM_DATE(environment.getProperty("I_FROM_DATE_YV_MATERIAL_MASTER_ALL_VIEWS"));
                        dto.setI_TO_DATE(LocalDate.now().toString());
                        List<String> divisionCodes = Arrays.asList("LD","LN","LP","LS","LU","MH","SO","AL","AV","CG","FO");
                        for(int i=0;i<divisionCodes.size();i++) {
                            dto.setI_DIVISION(divisionCodes.get(i));
                            response = service.YV_MATERIAL_MASTER_ALL_VIEWS(dto);
                        }
                        System.out.println("Executed " + serviceNumber);
                        break;
                    }
                    case 2: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_FROM_DATE(environment.getProperty("I_FROM_DATE_YV_EXCHG_RATE"));
                        dto.setI_TO_DATE(LocalDate.now().toString());
                        dto.setWERKS("4136");
                        response = service.YV_EXCHG_RATE(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }

                    case 3: {
                        PaymentDto dto = new PaymentDto();
                        dto.setSIGN(environment.getProperty("sign_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setOPTION(environment.getProperty("option_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setLOW(environment.getProperty("low_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setHIGH(environment.getProperty("high_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setDOCUMENT_TYPE(environment.getProperty("document_type_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setMATERIAL_TYPE(environment.getProperty("material_type_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setWERKS(environment.getProperty("werks_YM_PO_DET_RFC_HO_LUBES"));
                        response = service.YM_PO_DET_RFC_HO_LUBES(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 4: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_FROM_DATE(environment.getProperty("I_FROM_DATE"));
                        // dto.setI_TO_DATE(LocalDate.now().toString());
//                        dto.setI_TO_DATE(environment.getProperty("I_TO_DATE"));
                        dto.setI_TO_DATE(LocalDate.now().toString());

                        dto.setWERKS(environment.getProperty("WERKS"));
                        response = service.YV_LU_PCK_RATE(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 5: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_AS_ON_DATE(environment.getProperty("I_AS_ON_DATE_YV_TPT_CFARATES"));
                        response = service.YV_TPT_CFARATES(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }

                    case 6: {
                        PaymentDto dto = new PaymentDto();
                        dto.setVAL_DATE(environment.getProperty("VAL_DATE_YV_TPT_CUSTRTD"));
                        dto.setMANDT(environment.getProperty("MANDT_YV_TPT_CUSTRTD"));
                        dto.setBUKRS(environment.getProperty("BUKRS_YV_TPT_CUSTRTD"));
                        dto.setWERKS(environment.getProperty("WERKS_YV_TPT_CUSTRTD"));
                        response = service.YV_TPT_CUSTRTD(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 7: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_FKDAT(environment.getProperty("I_FKDAT_YV_CONTRACT_RATES"));
                        response = service.YV_CONTRACT_RATES(dto);
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 8: {
                        PaymentDto dto = new PaymentDto();
                        dto.setI_ALL_BOMM(environment.getProperty("I_ALL_BOMM_Y_LUBEBOM_DNLD"));
                        response = service.Y_LUBEBOM_DNLD(dto);
                        System.out.println("Executed " + serviceNumber);


                        break;
                    }

                    default:
                        response = new ApiResponse2<>(false, "Incorrect Service", null, 400);
                        break;
                }

                if (response != null && !response.getStatus()) //!response.getStatus()==false
                {
                    isError = true;
                    // finalResult.put(serviceNumber,"Failed with code "+response.getStatusCode());
                    finalResult.add(new ApiResponse2<>(false, "Failed", "API Number " + serviceNumber + " Failed with code " + response.getStatusCode(), response.getStatusCode()));
                } else {
                    isError = false;
                    finalResult.add(new ApiResponse2<>(true, "API Number " + serviceNumber + " Success"));

                }
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception
                finalResult.add(new ApiResponse2<>(false, "Internal Server Error", e.getMessage(), 500));
                isError = true;
            }

            if (isError) {

                continue;

            }
        }

        return finalResult;
    }


//    YV_EXCHANGE_RATE
//
//    {
//        "I_FROM_DATE" : "2022-01-05",
//        "I_TO_DATE" :  "2022-01-05"
//    }
//    Material_master
//    {
//        "I_FROM_DATE" : "2022-01-05",
//        "I_TO_DATE" :  "2022-01-05",
//        "I_DIVISION"    :   "LU"
//    }
//    YV_EX
//    {
//        "ET_EXCH_RATE": {
//            "item": [
//                {
//                    "MANDT": 310,
//                    "KURST": "FA1",
//                    "FCURR": "USD",
//                    "TCURR": "INR",
//                    "GDATU": 20220105,
//                    "UKURS": "74.48400",
//                    "FFACT": 0,
//                    "TFACT": 0
//                },
//                {
//                    "MANDT": 310,
//                    "KURST": "G",
//                    "FCURR": "CAD",
//                    "TCURR": "INR",
//                    "GDATU": 20220105,
//                    "UKURS": "58.28500",
//                    "FFACT": 0,
//                    "TFACT": 0
//                }
//            ]
//        },
//        "E_MSG": ""
//    }
//
//
//    Material master
//    {
//        "E_MARA": {
//            "item": [
//                {
//                    "MATNR": "AI06020",
//                    "MAKTX": "STOCK 6020 - IMPORTED",
//                    "BISMT": 6020,
//                    "GROES": "",
//                    "WRKST": 7100,
//                    "FERTH": "",
//                    "NORMT": "",
//                    "MEINS": "L29",
//                    "BRGEW": "1.000",
//                    "NTGEW": "1.000",
//                    "TRAGR": "0001",
//                    "ERSDA": "2001-08-03",
//                    "LAEDA": "2022-01-05"
//                }
//            ]
//        },
//        "E_MARC": {
//            "item": [
//                {
//                    "MATNR": "AI55578",
//                    "WERKS": "01L0",
//                    "UOMGR": "IN3",
//                    "UMRSL": "534B",
//                    "ABFAC": 1.1
//                },
//            ]
//        },
//        "E_MARM": {
//            "item": [
//                {
//                    "MATNR": "AI06020",
//                    "UMREN": 1,
//                    "MEINH": "L",
//                    "SEPRTR": "",
//                    "UMREZ": 1,
//                    "MEINS": "L29"
//                }
//
//            ]
//        },
//        "E_MBEW": {
//            "item": [
//                {
//                    "MATNR": "AI55578",
//                    "BWKEY": 3236,
//                    "BKLAS": 1300,
//                    "VPRSV": "V",
//                    "VERPR": 231.41,
//                    "STPRS": 0
//                },
//                {
//                    "MATNR": "AI55578",
//                    "BWKEY": 3237,
//                    "BKLAS": 1300,
//                    "VPRSV": "V",
//                    "VERPR": 231.41,
//                    "STPRS": 0
//                }
//            ]
//        },
//        "E_MSG": "",
//        "E_MVKE": {
//            "item": [
//                {
//                    "MATNR": "AI06020",
//                    "VKORG": 4100,
//                    "VTWEG": "IO",
//                    "KONDM": "07",
//                    "KONDMT": "BASE OILS",
//                    "KTGRM": "AD",
//                    "KTGRMT": "Additives",
//                    "MVGR1": "",
//                    "MVGR2": "",
//                    "MVGR3": "",
//                    "DWERK": ""
//                },
//                {
//                    "MATNR": "AI55580",
//                    "VKORG": "0100",
//                    "VTWEG": "ST",
//                    "KONDM": "07",
//                    "KONDMT": "BASE OILS",
//                    "KTGRM": "AD",
//                    "KTGRMT": "Additives",
//                    "MVGR1": "",
//                    "MVGR2": "",
//                    "MVGR3": "",
//                    "DWERK": ""
//                }
//            ]
//        }
//    }
}
