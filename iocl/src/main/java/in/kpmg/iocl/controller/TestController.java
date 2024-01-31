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
                            dto.setI_DIVISION("\"LD\",\"LN\",\"LP\",\"LS\",\"LU\",\"MH\",\"SO\",\"AL\",\"AV\",\"CG\",\"FO\"");
                            response = service.YV_MATERIAL_MASTER_ALL_VIEWS(dto);
                        System.out.println("Executed " + serviceNumber);
                        break;
                    }
                    case 2: {


                        PaymentDto dto = new PaymentDto();
                        dto.setI_FROM_DATE(environment.getProperty("I_FROM_DATE_YV_EXCHG_RATE"));
                        dto.setI_TO_DATE(LocalDate.now().toString());
                        dto.setWERKS("[\"2251\",\"5516\",\"5517\",\"5526\",\"5534\",\"5549\",\"5552\",\"5554\",\"5577\",\"5578\",\"5587\",\"5607\",\"5608\",\"5610\",\"5638\",\"5644\",\"5651\",\"5652\",\"5680\",\"5700\",\"5702\",\"734\",\"5746\",\"5747\",\"5748\",\"5750\",\"5765\",\"5766\",\"5768\",\"5810\",\"5811\",\"5825\",\"5841\",\"5849\",\"5862\",\"5863\",\"5864\",\"5870\",\"7F01\",\"7F06\",\"1140\",\"1146\",\"2136\",\"2138\",\"3136\",\"3236\",\"3237\",\"3266\",\"3267\",\"4136\",\"4466\",\"3240\",\"4196\",\"21HS\",\"32HS\",\"41HS\"]");
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

                        List<String> documentType = Arrays.asList("MK","WK","ZQ","ZP");
                        List<String> materialType = Arrays.asList("ADDT", "BASE", "PACK");

                        List<String> werks = Arrays.asList("1140", "1146","2136", "2138","3136", "3236","3237", "3266", "3267",
                                "4136","4466","3240","4196","21HS","32HS","41HS");

                        Integer size = documentType.size();

                        for(int i=0;i<documentType.size();i++){
                            dto.setDOCUMENT_TYPE(documentType.get(i));
                            for(int j=0;j<materialType.size();j++){
                                dto.setMATERIAL_TYPE(materialType.get(j));
                                for(int k=0;k<werks.size();k++){
                                    dto.setWERKS(werks.get(k));
                                    response = service.YM_PO_DET_RFC_HO_LUBES(dto);
                                }
                            }
                        }

//                        dto.setWERKS(environment.getProperty("werks_YM_PO_DET_RFC_HO_LUBES"));
//                        response = service.YM_PO_DET_RFC_HO_LUBES(dto);
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
                        dto.setBUKRS("\"0005\",\"0015\",\"0100\",\"1000\",\"1100\",\"1200\",\"1300\",\"1400\",\"1500\",\"2000\",\"2100\",\"2200\",\"2300\",\"2400\",\"2500\",\"3000\",\"3100\",\"3200\",\"3300\",\"4000\",\"4100\",\"4200\",\"4300\",\"4400\",\"7200\",\"7500\",\"9000\",\"9010\",\"9020\",\"9030\",\"9040\",\"9050\",\"9060\",\"9070\",\"9100\",\"9200\",\"9201\",\"9210\",\"9220\",\"9230\",\"9240\",\"9250\",\"9260\",\"9270\",\"9280\",\"9290\",\"9291\",\"9310\",\"9320\",\"9330\",\"9340\",\"9400\",\"9500\",\"9600\",\"9610\",\"9700\",\"9750\",\"9760\",\"9800\",\"9850\",\"9860\",\"9870\",\"9880\",\"9910\",\"9930\",\"RRPL\"");
                        dto.setWERKS(environment.getProperty("WERKS_YV_TPT_CUSTRTD"));
                        dto.setWERKS("\"2251\",\"5516\",\"5517\",\"5526\",\"5534\",\"5549\",\"5552\",\"5554\",\"5577\",\"5578\",\"5587\",\"5607\",\"5608\",\"5610\",\"5638\",\"5644\",\"5651\",\"5652\",\"5680\",\"5700\",\"5702\",\"734\",\"5746\",\"5747\",\"5748\",\"5750\",\"5765\",\"5766\",\"5768\",\"5810\",\"5811\",\"5825\",\"5841\",\"5849\",\"5862\",\"5863\",\"5864\",\"5870\",\"7F01\",\"7F06\",\"1140\",\"1146\",\"2136\",\"2138\",\"3136\",\"3236\",\"3237\",\"3266\",\"3267\",\"4136\",\"4466\",\"3240\",\"4196\",\"21HS\",\"32HS\",\"41HS\"]");
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
