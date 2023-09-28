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
    @PostMapping("/fetch-details")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ApiResponse2 fetchdetails(@RequestBody PaymentDto dto) {
        return service.fetchAPI_YV_TPT_CUSTRTD(dto);
    }
    
    YV_EXCHANGE_RATE
    
    {
        "I_FROM_DATE" : "2022-01-05",
        "I_TO_DATE" :  "2022-01-05"
    }
    Material_master
    {
        "I_FROM_DATE" : "2022-01-05",
        "I_TO_DATE" :  "2022-01-05",
        "I_DIVISION"    :   "LU"
    }   
    YV_EX
    {
        "ET_EXCH_RATE": {
            "item": [
                {
                    "MANDT": 310,
                    "KURST": "FA1",
                    "FCURR": "USD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "74.48400",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "G",
                    "FCURR": "CAD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "58.28500",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "G",
                    "FCURR": "EUR",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "84.12350",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "G",
                    "FCURR": "GBP",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "100.78750",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "G",
                    "FCURR": "USD",
                    "TCURR": "CAD",
                    "GDATU": 20220105,
                    "UKURS": "1.27520",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "G",
                    "FCURR": "USD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "74.36000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "M",
                    "FCURR": "CAD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "58.32030",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "M",
                    "FCURR": "EUR",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "84.14970",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "M",
                    "FCURR": "GBP",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "100.83830",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "M",
                    "FCURR": "USD",
                    "TCURR": "CAD",
                    "GDATU": 20220105,
                    "UKURS": "1.27580",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "M",
                    "FCURR": "USD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "74.37000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "TTBR",
                    "FCURR": "EUR",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "83.27000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "TTBR",
                    "FCURR": "GBP",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "99.71000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "TTBR",
                    "FCURR": "JPY",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "63.52000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "TTBR",
                    "FCURR": "USD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "74.08000",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "ZPUR",
                    "FCURR": "CAD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "58.32030",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "ZPUR",
                    "FCURR": "EUR",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "84.14970",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "ZPUR",
                    "FCURR": "GBP",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "100.83830",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "ZPUR",
                    "FCURR": "USD",
                    "TCURR": "CAD",
                    "GDATU": 20220105,
                    "UKURS": "1.27580",
                    "FFACT": 0,
                    "TFACT": 0
                },
                {
                    "MANDT": 310,
                    "KURST": "ZPUR",
                    "FCURR": "USD",
                    "TCURR": "INR",
                    "GDATU": 20220105,
                    "UKURS": "74.37000",
                    "FFACT": 0,
                    "TFACT": 0
                }
            ]
        },
        "E_MSG": ""
    }
    
    
    Material master 
    {
        "E_MARA": {
            "item": [
                {
                    "MATNR": "AI06020",
                    "MAKTX": "STOCK 6020 - IMPORTED",
                    "BISMT": 6020,
                    "GROES": "",
                    "WRKST": 7100,
                    "FERTH": "",
                    "NORMT": "",
                    "MEINS": "L29",
                    "BRGEW": "1.000",
                    "NTGEW": "1.000",
                    "TRAGR": "0001",
                    "ERSDA": "2001-08-03",
                    "LAEDA": "2022-01-05"
                },
                {
                    "MATNR": "AI55578",
                    "MAKTX": "IMPORTED ADDITIVE 55578",
                    "BISMT": 55578,
                    "GROES": "",
                    "WRKST": 7100,
                    "FERTH": "",
                    "NORMT": "",
                    "MEINS": "L29",
                    "BRGEW": "1.000",
                    "NTGEW": "1.000",
                    "TRAGR": "0001",
                    "ERSDA": "2001-08-03",
                    "LAEDA": "2022-01-05"
                },
                {
                    "MATNR": "AI55580",
                    "MAKTX": "IMPORTED ADDTIVE 55580",
                    "BISMT": 55580,
                    "GROES": "",
                    "WRKST": 7100,
                    "FERTH": "",
                    "NORMT": "",
                    "MEINS": "L29",
                    "BRGEW": "1.000",
                    "NTGEW": "1.000",
                    "TRAGR": "0001",
                    "ERSDA": "2001-08-03",
                    "LAEDA": "2022-01-05"
                }
            ]
        },
        "E_MARC": {
            "item": [
                {
                    "MATNR": "AI55578",
                    "WERKS": "01L0",
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": "01L0",
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": "01L0",
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 1140,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 1140,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 1140,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 1466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 1466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 1466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 2136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 2136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 2136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 2138,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 2138,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 2138,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 2166,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 2166,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 2166,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3229,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3236,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3236,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3236,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3237,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3237,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3237,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3238,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3238,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3239,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3239,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3239,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3240,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3240,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3240,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 3266,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 3266,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 3266,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 4136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 4136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 4136,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 4466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 4466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI06020",
                    "WERKS": 4466,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55578",
                    "WERKS": 5767,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                },
                {
                    "MATNR": "AI55580",
                    "WERKS": 5767,
                    "UOMGR": "IN3",
                    "UMRSL": "534B",
                    "ABFAC": 1.1
                }
            ]
        },
        "E_MARM": {
            "item": [
                {
                    "MATNR": "AI06020",
                    "UMREN": 1,
                    "MEINH": "L",
                    "SEPRTR": "",
                    "UMREZ": 1,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI06020",
                    "UMREN": 1,
                    "MEINH": "K29",
                    "SEPRTR": "",
                    "UMREZ": 1000,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI06020",
                    "UMREN": 1,
                    "MEINH": "EA",
                    "SEPRTR": "",
                    "UMREZ": 181,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI06020",
                    "UMREN": 1000,
                    "MEINH": "KG",
                    "SEPRTR": "",
                    "UMREZ": 1158,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI06020",
                    "UMREN": 1,
                    "MEINH": "L29",
                    "SEPRTR": "",
                    "UMREZ": 1,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI55578",
                    "UMREN": 1000,
                    "MEINH": "KG",
                    "SEPRTR": "",
                    "UMREZ": 1190,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI55578",
                    "UMREN": 1,
                    "MEINH": "L29",
                    "SEPRTR": "",
                    "UMREZ": 1,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI55580",
                    "UMREN": 1000,
                    "MEINH": "KG",
                    "SEPRTR": "",
                    "UMREZ": 1176,
                    "MEINS": "L29"
                },
                {
                    "MATNR": "AI55580",
                    "UMREN": 1,
                    "MEINH": "L29",
                    "SEPRTR": "",
                    "UMREZ": 1,
                    "MEINS": "L29"
                }
            ]
        },
        "E_MBEW": {
            "item": [
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3236,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 231.41,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 231.41,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": "01L0",
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 450.54,
                    "STPRS": "1.00"
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3239,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 66.44,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3239,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3238,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 329.54,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 72.21,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 230.38,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "84.80",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 231.41,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 278.91,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3239,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 5767,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 211.16,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 4466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2138,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 2138,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "233.90",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 5767,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 206.61,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 2166,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3236,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 278.91,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 206.61,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 246.67,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3239,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 5767,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 230.06,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "81.20",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 211.16,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": "01L0",
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 229.68,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": "01L0",
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 74.01,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 69.54,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 1466,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 265.12,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "1.00",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 231.41,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 278.91,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 231.41,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3236,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 232.51,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 327.34,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 278.91,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 278.91,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 2138,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 279.62,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3266,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 0,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3236,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 84.69,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 58.04,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": "01L0",
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 450.54,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3239,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 88.32,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 228.96,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": "01L0",
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 229.68,
                    "STPRS": "1.00"
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3238,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 295.88,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 86.81,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 3136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "69.50",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 2136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 82.81,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 327.48,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 230.06,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 5767,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 246.67,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55578",
                    "BWKEY": 3237,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 229.29,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 1140,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 85.79,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI06020",
                    "BWKEY": 4136,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 86.79,
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3238,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": "295.70",
                    "STPRS": 0
                },
                {
                    "MATNR": "AI55580",
                    "BWKEY": 3240,
                    "BKLAS": 1300,
                    "VPRSV": "V",
                    "VERPR": 234.77,
                    "STPRS": 0
                }
            ]
        },
        "E_MSG": "",
        "E_MVKE": {
            "item": [
                {
                    "MATNR": "AI06020",
                    "VKORG": 4100,
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 4100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 3200,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 3200,
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 3100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 2100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 2100,
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 1100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": 1100,
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": "0100",
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI06020",
                    "VKORG": "0100",
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": 1100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": "0100",
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": 3200,
                    "VTWEG": "RE",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": 3200,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": 3209,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": "0100",
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55578",
                    "VKORG": 4100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 1100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 2100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 3200,
                    "VTWEG": "RE",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 3200,
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": "0100",
                    "VTWEG": "IO",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 3200,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 3209,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": 4100,
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                },
                {
                    "MATNR": "AI55580",
                    "VKORG": "0100",
                    "VTWEG": "ST",
                    "KONDM": "07",
                    "KONDMT": "BASE OILS",
                    "KTGRM": "AD",
                    "KTGRMT": "Additives",
                    "MVGR1": "",
                    "MVGR2": "",
                    "MVGR3": "",
                    "DWERK": ""
                }
            ]
        }
    }
}
