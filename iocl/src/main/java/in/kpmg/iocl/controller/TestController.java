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
        return service.YV_LU_PCK_RATE(dto);
        else if(dto.getService()==2)
            return service.YM_PO_DET_RFC_HO_LUBES(dto);
        else
            return new ApiResponse2<>(false,"Incorrect Service",null,400);
    }
    @PostMapping("/fetch-details1")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ApiResponse2 fetchdetails1(@RequestBody PaymentDto dto) {
//        if(dto.getService()==1)
        return service.testservice(dto);
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
