package in.kpmg.iocl.controller;

import in.kpmg.iocl.dto.ApiResponse2;
import in.kpmg.iocl.dto.MaterialMasterEmarm;
import in.kpmg.iocl.dto.PaymentDto;
import in.kpmg.iocl.models.API_type_config;
import in.kpmg.iocl.repository.*;
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


    //financial year = pck_rate

    @Autowired
    Y_LUBEBOM_DNLD_Repo y_lubebom_dnld_repo;
    @Autowired
    I_TPT_CUSTRTD_I_WERKS_Repo i_tpt_custrtd_i_werks_repo;
@Autowired MaterialMasterEmarmRepo materialMasterEmarmRepo;

    @Autowired
    YV_CONTRACT_RATES_O_REPORT_Repo yv_contract_rates_o_report_repo;

    @Autowired
    YV_CONTRACT_RATE_I_BURKS_Repo yv_contract_rate_i_burks_repo;


    @Autowired
    YV_CONTRACT_RATES_I_TPLST_Repo yv_contract_rates_i_tplst_repo;


    @Autowired
    I_TPT_CUSTRTD_Repo i_tpt_custrtd_repo;

    @Autowired
    I_TPT_CUSTRTD_I_BUKRS_Repo i_tpt_custrtd_i_bukrs_repo;
    @Autowired
    YV_ET_CFACONT_Repo yv_et_cfacont_repo;

    @Autowired
    YV_ET_CFARATES_Repo yvEtCfaratesRepo;

    @Autowired
    YV_LU_PCK_RATE_ET_TRANSRATE_REPO yv_lu_pck_rate_et_transrate_repo;

    @Autowired
    YV_LU_PCK_RATE_ET_CAR_GRP_Repo yv_lu_pck_rate_et_car_grp_repo;

@Autowired
MaterialMasterEmaraRepo materialMasterEmaraRepo;

@Autowired
MaterialMasterEmarcRepo materialMasterEmarcRepo;

@Autowired
MaterialMasterEmvkeRepo materialMasterEmvkeRepo;

@Autowired
MaterialMasterEmbewRepo materialMasterEmbewRepo;

@Autowired
    YV_EXCHG_RATE_ET_EXCH_RATE_Repo yv_exchg_rate_et_exch_rate_repo;

    @Autowired
    YM_PO_DET_RFC_HO_LUBES_Repo ym_po_det_rfc_ho_lubes_repo;

    @Autowired
    API_type_config_repo repo;

    public List<ApiResponse2> fetchdetails() {
        LocalDate currentDate = LocalDate.now();
        LocalDate yesterdayDate = currentDate.minusDays(1);
        ApiResponse2 response = null;
        boolean isError = false;
        List<ApiResponse2> finalResult = new ArrayList<>();
        List<String> divisionCodes = Arrays.asList("LD","LN","LP","LS","LU","MH","SO","AL","AV","CG","FO");
        List<String> WERKS = Arrays.asList("2251","5516","5517","5526","5534","5549","5552","5554","5577","5578","5587","5607","5608","5610","5638","5644","5651","5652","5680","5700","5702","734","5746","5747","5748","5750","5765","5766","5768","5810","5811","5825","5841","5849","5862","5863","5864","5870","7F01","7F06","1140","1146","2136","2138","3136","3236","3237","3266","3267","4136","4466","3240","4196","21HS","32HS","41HS");
        List<String> BUKRS = Arrays.asList("0005","0015","0100","1000","1100","1200","1300","1400","1500","2000","2100","2200","2300","2400","2500","3000","3100","3200","3300","4000","4100","4200","4300","4400","7200","7500","9000","9010","9020","9030","9040","9050","9060","9070","9100","9200","9201","9210","9220","9230","9240","9250","9260","9270","9280","9290","9291","9310","9320","9330","9340","9400","9500","9600","9610","9700","9750","9760","9800","9850","9860","9870","9880","9910","9930","RRPL");
        for (int serviceNumber = 1; serviceNumber <= 7; serviceNumber++) {
            try {
                switch (serviceNumber) {
                    case 1: {
                        PaymentDto dto = new PaymentDto();try {
                            API_type_config config = repo.findById(1).get();
                            if (config.getFromDate().equals("Yesterday")) {
                                dto.setI_FROM_DATE(yesterdayDate.toString());

                            } else {
                                dto.setI_FROM_DATE(config.getFromDate());
                            }
                            if (config.getToDate().equals("CurrentDay")) {
                                dto.setI_TO_DATE(currentDate.toString());
                            } else {
                                dto.setI_FROM_DATE(config.getToDate());
                            }
                        }catch (Exception e){
                            System.out.print("Error in service 1 API config");
                            e.printStackTrace();
                        }

                        System.out.print("Inside Service 1 Controller");
//                        dto.setI_FROM_DATE(environment.getProperty("I_FROM_DATE_YV_MATERIAL_MASTER_ALL_VIEWS"));
//                        dto.setI_TO_DATE("2023-12-31");



//
//                        dto.setI_TO_DATE(currentDate.toString());
                        for(int i=0;i<divisionCodes.size();i++) {
                                dto.setI_DIVISION(divisionCodes.get(i));
                                response = service.YV_MATERIAL_MASTER_ALL_VIEWS(dto);
                            }
                        System.out.print("deleting service 1 duplicates");
                        materialMasterEmaraRepo.delete();
                        materialMasterEmarcRepo.delete();
                        materialMasterEmvkeRepo.delete();
                        materialMasterEmbewRepo.delete();
                        materialMasterEmarmRepo.delete();
                        System.out.println("Executed " + serviceNumber);
                        break;
                    }
                    case 2: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(2).get();
                            if(config.getFromDate().equals("Yesterday"))
                            {dto.setI_FROM_DATE(yesterdayDate.toString());

                            }else {
                                dto.setI_FROM_DATE(config.getFromDate());
                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setI_TO_DATE(currentDate.toString());
                            }else {
                                dto.setI_FROM_DATE(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 2 API config");
                            e.printStackTrace();
                        }
                        System.out.print("Inside Service 2 Controller");
                            response = service.YV_EXCHG_RATE(dto);
                        System.out.print("deleting service 2 duplicates");
                            yv_exchg_rate_et_exch_rate_repo.delete();
                        System.out.println("Executed " + serviceNumber);
                        break;
                    }
                    case 3: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(3).get();
                            if(config.getFromDate().equals("Yesterday"))
                            {dto.setLOW(yesterdayDate.toString());
                            }else {
                                dto.setLOW(config.getFromDate());
                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setHIGH(currentDate.toString());
                            }else {
                                dto.setHIGH(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 3 API config");
                            e.printStackTrace();
                        }
                        System.out.print("Inside Service 3 Controller");
                        dto.setSIGN(environment.getProperty("sign_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setOPTION(environment.getProperty("option_YM_PO_DET_RFC_HO_LUBES"));
//
                        dto.setDOCUMENT_TYPE(environment.getProperty("document_type_YM_PO_DET_RFC_HO_LUBES"));
                        dto.setMATERIAL_TYPE(environment.getProperty("material_type_YM_PO_DET_RFC_HO_LUBES"));
                        List<String> documentType = Arrays.asList("MK","WK","ZQ","ZP");
                        List<String> materialType = Arrays.asList("ADDT", "BASE", "PACK");
                        List<String> werks = Arrays.asList("1140", "1146","2136", "2138","3136", "3236","3237", "3266", "3267",
                                "4136","4466","3240","4196","21HS","32HS","41HS");
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
                        System.out.print("deleting service 3 duplicates");
                        ym_po_det_rfc_ho_lubes_repo.delete();
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 4: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(4).get();
                            if(config.getFromDate().equals("Yesterday"))
                            {dto.setI_FROM_DATE(yesterdayDate.toString());

                            }else {
                                dto.setI_FROM_DATE(config.getFromDate());
                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setI_TO_DATE(currentDate.toString());
                            }else {
                                dto.setI_FROM_DATE(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 4 API config");
                            e.printStackTrace();
                        }
                        System.out.print("Inside Service 4 Controller");

                        for(int i=0;i<WERKS.size();i++) {
                            dto.setWERKS(WERKS.get(i));
                            response = service.YV_LU_PCK_RATE(dto);
                        }
                        System.out.print("deleting service 4 duplicates");
                        yv_lu_pck_rate_et_car_grp_repo.delete();;
                        yv_lu_pck_rate_et_transrate_repo.delete();
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 5: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(5).get();
                            if(config.getToDate().equals("Yesterday"))
                            {dto.setI_AS_ON_DATE(yesterdayDate.toString().replace("-",""));

                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setI_AS_ON_DATE(currentDate.toString().replace("-",""));
                            }else {
                                dto.setI_AS_ON_DATE(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 5 API config");
                            e.printStackTrace();
                        }
                        System.out.print("Inside Service 5 Controller");

                        String date = currentDate.toString();

//                        String test =date.replace("-","");
//                        dto.setI_AS_ON_DATE(environment.getProperty("I_AS_ON_DATE_YV_TPT_CFARATES"));
                        response = service.YV_TPT_CFARATES(dto);
                        System.out.println("Executed " + serviceNumber);
                        System.out.print("deleting service 5 duplicates");
                        yv_et_cfacont_repo.delete();
                        yvEtCfaratesRepo.delete();
                        break;
                    }

                    case 6: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(6).get();
                            if(config.getToDate().equals("Yesterday"))
                            {dto.setVAL_DATE(yesterdayDate.toString());

                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setVAL_DATE(currentDate.toString());
                            }else {
                                dto.setVAL_DATE(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 6 API config");
                            e.printStackTrace();
                        }

                        System.out.print("Inside Service 6 Controller");

//                        dto.setVAL_DATE(environment.getProperty("VAL_DATE_YV_TPT_CUSTRTD"));
//                        dto.setVAL_DATE(currentDate.toString());
                        dto.setMANDT(environment.getProperty("MANDT_YV_TPT_CUSTRTD"));
                        for(int i=0;i<BUKRS.size();i++){
                            dto.setBUKRS(BUKRS.get(i));
                            for(int j=0;j< WERKS.size();j++){
                                dto.setWERKS(WERKS.get(j));
                                response = service.YV_TPT_CUSTRTD(dto);
                            }
                        }
                        System.out.print("deleting service 6 duplicates");
//                        i_tpt_custrtd_repo.delete();
                        i_tpt_custrtd_i_bukrs_repo.delete();
                        i_tpt_custrtd_i_werks_repo.delete();
                        System.out.println("Executed " + serviceNumber);

                        break;
                    }
                    case 7: {
                        PaymentDto dto = new PaymentDto();
                        try {
                            API_type_config config = repo.findById(7).get();
                            if(config.getToDate().equals("Yesterday"))
                            {dto.setI_FKDAT(yesterdayDate.toString());

                            }
                            if(config.getToDate().equals("CurrentDay"))
                            {
                                dto.setI_FKDAT(currentDate.toString());
                            }else {
                                dto.setI_FKDAT(config.getToDate());
                            }
                        } catch (Exception e) {
                            System.out.print("Error in service 6 API config");
                            e.printStackTrace();
                        }
                        System.out.print("Inside Service 7 Controller");

//                        dto.setI_FKDAT(environment.getProperty("I_FKDAT_YV_CONTRACT_RATES"));
//                        dto.setI_FKDAT(currentDate.toString());
                        response = service.YV_CONTRACT_RATES(dto);
                        System.out.println("Executed " + serviceNumber);
                        System.out.print("deleting service 7 duplicates");
                        yv_contract_rates_o_report_repo.delete();
                        yv_contract_rates_i_tplst_repo.delete();
                        yv_contract_rate_i_burks_repo.delete();

                        break;
                    }
                    case 8: {
                        System.out.print("Inside Service 8 Controller");

                        PaymentDto dto = new PaymentDto();
                        dto.setI_ALL_BOMM(environment.getProperty("I_ALL_BOMM_Y_LUBEBOM_DNLD"));
                        response = service.Y_LUBEBOM_DNLD(dto);
                        System.out.println("Executed " + serviceNumber);
                        System.out.print("deleting service 8 duplicates");
                        y_lubebom_dnld_repo.delete();


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

}
