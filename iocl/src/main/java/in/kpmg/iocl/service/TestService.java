package in.kpmg.iocl.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import in.kpmg.iocl.dto.*;
import in.kpmg.iocl.models.*;
import in.kpmg.iocl.repository.*;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    I_TPT_CUSTRTD_I_WERKS_Repo i_tpt_custrtd_i_werks_repo;

    @Autowired
    I_TPT_CUSTRTD_I_BUKRS_Repo i_tpt_custrtd_i_bukrs_repo;
    @Autowired
    YV_EXCHG_RATE_ET_EXCH_RATE_Repo yv_exchg_rate_et_exch_rate_repo;

    @Autowired
    YV_LU_PCK_RATE_ET_CAR_GRP_Repo yv_lu_pck_rate_et_car_grp_repo;

    @Autowired
    Y_LUBEBOM_DNLD_Repo y_lubebom_dnld_repo;

    @Autowired
    I_TPT_CUSTRTD_Repo i_tpt_custrtd_repo;

    @Autowired
    YV_LU_PCK_RATE_ET_TRANSRATE_REPO yv_lu_pck_rate_et_transrate_repo;

    @Autowired
    YM_PO_DET_RFC_HO_LUBES_Repo ym_po_det_rfc_ho_lubes_repo;

    @Autowired
    MaterialMasterEmvkeRepo materialMasterEmvkeRepo;

    @Autowired
    MaterialMasterEmbewRepo materialMasterEmbewRepo;

    @Autowired
    MaterialMasterEmarmRepo materialMasterEmarmRepo;

    @Autowired
    MaterialMasterEmarcRepo materialMasterEmarcRepo;

    @Autowired
    MaterialMasterEmaraRepo materialMasterEmaraRepo;

    @Autowired
    YV_CONTRACT_RATES_O_REPORT_Repo yv_contract_rates_o_report_repo;

    @Autowired
    YV_CONTRACT_RATE_I_BURKS_Repo yv_contract_rate_i_burks_repo;

    @Autowired
    YV_CONTRACT_RATES_I_TPLST_Repo yv_contract_rates_i_tplst_repo;

    @Autowired
    YV_ET_CFACONT_Repo yv_et_cfacont_repo;

    @Autowired
    YV_ET_CFARATES_Repo yvEtCfaratesRepo;


    public static CloseableHttpClient getCloseableHttpClient() {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.custom().setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                    .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                        public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                            return true;
                        }
                    }).build()).build();
        } catch (KeyManagementException e) {
            System.out.println("KeyManagementException in creating http client instance" + e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException in creating http client instance" + e);
        } catch (KeyStoreException e) {
            System.out.println("KeyStoreException in creating http client instance" + e);
        }
        return httpClient;
    }
    public ApiResponse2 YV_LU_PCK_RATE(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_LU_PCK_RATE",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";



            String jsonInputString = "{\n" +
                    "    \"I_FROM_DATE\" :" + dto.getI_FROM_DATE() + "," +
                    "    \"I_TO_DATE\" :" + dto.getI_TO_DATE() + "," +
                    "    \"I_WERKS\":\n" +
                    "    {\n" +
                    "        \"item\":\n" +
                    "        {\n" +
                    "            \"WERKS\" :" + dto.getWERKS() +
                    "        }\n" +
                            "\n"+
                    "    }\n" +
                    "\n"+
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT,false);
//            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YV_LU_PCK_Rate_Response response = mapper.readValue(json, YV_LU_PCK_Rate_Response.class);
//            System.out.println("Test" + json);

            for(int i=0;i<response.getET_CAR_GRP().getItem().size();i++){
                YV_LU_PCK_RATE_ET_CAR_GRP model = new YV_LU_PCK_RATE_ET_CAR_GRP();
                try {
                    model.setMANDT(response.getET_CAR_GRP().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);
                }
                try {
                    model.setWERKS(response.getET_CAR_GRP().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);
                }
                try {
                    model.setYYCARTON_GRP(response.getET_CAR_GRP().getItem().get(i).getYYCARTON_GRP());
                } catch (NullPointerException e) {
                    model.setYYCARTON_GRP(null);
                }
                try {
                    model.setENDDA(response.getET_CAR_GRP().getItem().get(i).getENDDA());
                } catch (NullPointerException e) {
                    model.setENDDA(null);
                }
                try {
                    model.setBEGDA(response.getET_CAR_GRP().getItem().get(i).getBEGDA());
                } catch (NullPointerException e) {
                    model.setBEGDA(null);
                }
                try {
                    model.setWGT_FROM(response.getET_CAR_GRP().getItem().get(i).getWGT_FROM());
                } catch (NullPointerException e) {
                    model.setWGT_FROM(null);
                }
                try {
                    model.setWGT_TO(response.getET_CAR_GRP().getItem().get(i).getWGT_TO());
                } catch (NullPointerException e) {
                    model.setWGT_TO(null);
                }
                try {
                    model.setYYRATE_PERCENT(response.getET_CAR_GRP().getItem().get(i).getYYRATE_PERCENT());
                } catch (NullPointerException e) {
                    model.setYYRATE_PERCENT(null);
                }
                yv_lu_pck_rate_et_car_grp_repo.save(model);


            }

            for(int i=0;i<response.getET_TRANSRATE().getItem().size();i++) {
                YV_LU_PCK_RATE_ET_TRANSRATE model = new YV_LU_PCK_RATE_ET_TRANSRATE();
                try {
                    model.setBEGDA(response.getET_TRANSRATE().getItem().get(i).getBEGDA());
                }catch (NullPointerException e){
                    model.setBEGDA(null);
                }
                try {
                    model.setBZIRK(response.getET_TRANSRATE().getItem().get(i).getBZIRK());
                }catch (NullPointerException e){
                    model.setBZIRK(null);
                }
                try {
                    model.setMANDT(response.getET_TRANSRATE().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);
                }
                try {
                    model.setWERKS(response.getET_TRANSRATE().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);
                }
                try {
                    model.setVEH_TYPE(response.getET_TRANSRATE().getItem().get(i).getVEH_TYPE());
                } catch (NullPointerException e) {
                    model.setVEH_TYPE(null);
                }
                try {
                    model.setTU_NUMBER(response.getET_TRANSRATE().getItem().get(i).getTU_NUMBER());
                } catch (NullPointerException e) {
                    model.setTU_NUMBER(null);
                }
                try {
                    model.setKUNNR(response.getET_TRANSRATE().getItem().get(i).getKUNNR());
                } catch (NullPointerException e) {
                    model.setKUNNR(null);
                }
                try {
                    model.setYYRATE_APPLIC(response.getET_TRANSRATE().getItem().get(i).getYYRATE_APPLIC());
                } catch (NullPointerException e) {
                    model.setYYRATE_APPLIC(null);
                }
                try {
                    model.setENDDA(response.getET_TRANSRATE().getItem().get(i).getENDDA());
                } catch (NullPointerException e) {
                    model.setENDDA(null);
                }
                try {
                    model.setYYBASE_RATE(response.getET_TRANSRATE().getItem().get(i).getYYBASE_RATE());
                } catch (NullPointerException e) {
                    model.setYYBASE_RATE(null);
                }
                try {
                    model.setPROVISIONAL(response.getET_TRANSRATE().getItem().get(i).getPROVISIONAL());
                } catch (NullPointerException e) {
                    model.setPROVISIONAL(null);
                }
                try {
                    model.setREMARKS(response.getET_TRANSRATE().getItem().get(i).getREMARKS());
                } catch (NullPointerException e) {
                    model.setREMARKS(null);
                }
                yv_lu_pck_rate_et_transrate_repo.save(model);
            }
            responseMap.put(response1.getStatusLine().getStatusCode(), json);
            return new ApiResponse2<>(true,"Success","data saved",200);

        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);

        }}

    //==============================================YV_TPT_CFARATES==============================================================================
    public ApiResponse2 YV_TPT_CFARATES(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_TPT_CFARATES",
                userName = "b2buser", password = "iocl1234", request = "";
        //  System.out.println("......CFA Data url................"+url);
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";



            String jsonInputString = "{\n" +
                    "    \"I_AS_ON_DATE\"   :" + dto.getI_AS_ON_DATE()+ "\n" +
                    "}";

            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
//            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
//            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);
            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            //    System.out.println("Input Data is............:"+json);
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);

            YV_TPT_CFARATE_Response response = mapper.readValue(json, YV_TPT_CFARATE_Response.class);

            for(int i=0;i<response.getYV_TPT_CFACONT().getItem().size();i++){
                YV_TPT_CFACONT_Model model = new YV_TPT_CFACONT_Model();
                try{
                    model.setMANDT(response.getYV_TPT_CFACONT().getItem().get(i).getMANDT());
                }catch (NullPointerException e1){
                    model.setMANDT(null);
                }
                try
                {
                    model.setVSTEL(response.getYV_TPT_CFACONT().getItem().get(i).getVSTEL());
                }catch (NullPointerException e)
                {
                    model.setVSTEL(null);
                }
                try{
                    model.setYYTENDERNO(response.getYV_TPT_CFACONT().getItem().get(i).getYYTENDERNO());
                }catch(NullPointerException e){
                    model.setYYTENDERNO(null);
                }
                try
                {
                    model.setREMARKS(response.getYV_TPT_CFACONT().getItem().get(i).getREMARKS());
                }catch (NullPointerException e){
                    model.setREMARKS(null);
                }
                try{
                    model.setTRANS_UOM(response.getYV_TPT_CFACONT().getItem().get(i).getTRANS_UOM());
                }catch (NullPointerException e)
                {
                    model.setTRANS_UOM(null);
                }
                try{
                    model.setYYVENDOR(response.getYV_TPT_CFACONT().getItem().get(i).getYYVENDOR());
                }catch(NullPointerException e)
                {
                    model.setYYVENDOR(null);
                }
                try{
                    model.setFIXED_CHARGES(response.getYV_TPT_CFACONT().getItem().get(i).getFIXED_CHARGES());
                }catch (NullPointerException e)
                {
                    model.setFIXED_CHARGES(null);
                }
                try
                {
                    model.setHANDLING_RATE(response.getYV_TPT_CFACONT().getItem().get(i).getHANDLING_RATE());
                }catch (NullPointerException e)
                {
                    model.setHANDLING_RATE(null);
                }
                try
                {
                    model.setHSD_BASERATE(response.getYV_TPT_CFACONT().getItem().get(i).getHSD_BASERATE());
                }catch (NullPointerException e)
                {
                    model.setHSD_BASERATE(null);
                }
                try{
                    model.setERNAM(response.getYV_TPT_CFACONT().getItem().get(i).getERNAM());
                }catch (NullPointerException e)
                {
                    model.setERNAM(null);
                }
                try
                {
                    model.setERZET(response.getYV_TPT_CFACONT().getItem().get(i).getERZET());
                }catch(NullPointerException e)
                {
                    model.setERNAM(null);
                }
                try
                {
                    model.setAENAM(response.getYV_TPT_CFACONT().getItem().get(i).getAENAM());
                }catch(NullPointerException e)
                {
                    model.setAENAM(null);
                }

                try
                {
                    model.setAEZET(response.getYV_TPT_CFACONT().getItem().get(i).getAEZET());
                }
                catch(NullPointerException e) {
                    model.setAEZET(null);
                }
                yv_et_cfacont_repo.save(model);
                //       System.out.println("............First CFA data saved in repo...............");
            }
            for(int i=0;i<response.getYV_TPT_CFARATES().getItem().size();i++) {
                YV_TPT_CFARATES_Model model = new YV_TPT_CFARATES_Model();
                try
                {
                    model.setMANDT(response.getYV_TPT_CFARATES().getItem().get(i).getMANDT());
                }catch (Exception e)
                {
                    model.setMANDT(null);
                }
                try
                {
                    model.setVSTEL(response.getYV_TPT_CFARATES().getItem().get(i).getVSTEL());
                }catch (Exception e)
                {
                    model.setVSTEL(null);
                }
                try{
                    model.setYYTENDERNO(response.getYV_TPT_CFARATES().getItem().get(i).getYYTENDERNO());
                }catch(NullPointerException e)
                {
                    model.setYYTENDERNO(null);
                }
                try{
                    model.setOUTSIDESTATE(response.getYV_TPT_CFARATES().getItem().get(i).getOUTSIDESTATE());
                }
                catch(NullPointerException ex)
                {
                    model.setOUTSIDESTATE(null);
                }
                try{
                    model.setSLAB_FROM_KM(response.getYV_TPT_CFARATES().getItem().get(i).getSLAB_FROM_KM());
                }catch (NullPointerException e)
                {
                    model.setSLAB_FROM_KM(null);
                }
                try{
                    model.setSLAB_TO_KM(response.getYV_TPT_CFARATES().getItem().get(i).getSLAB_TO_KM());
                }catch (NullPointerException e)
                {
                    model.setSLAB_TO_KM(null);
                }
                try{
                    model.setRATEUOM(response.getYV_TPT_CFARATES().getItem().get(i).getRATEUOM());
                }catch (NullPointerException e)
                {
                    model.setRATEUOM(null);
                }
                try{
                    model.setREMARKS(response.getYV_TPT_CFARATES().getItem().get(i).getREMARKS());
                }catch (NullPointerException e)
                {
                    model.setREMARKS(null);
                }
                try{
                    model.setERNAM(response.getYV_TPT_CFARATES().getItem().get(i).getERNAM());
                }catch (NullPointerException e)
                {
                    model.setERNAM(null);
                }
                try{
                    model.setERZET(response.getYV_TPT_CFARATES().getItem().get(i).getERZET());
                }catch(NullPointerException e)
                {
                    model.setERZET(null);
                }
                try{
                    model.setAENAM(response.getYV_TPT_CFARATES().getItem().get(i).getAENAM());
                }catch (NullPointerException e)
                {
                    model.setAENAM(null);
                }
                try{
                    model.setAEZET(response.getYV_TPT_CFARATES().getItem().get(i).getAEZET());
                }catch (NullPointerException e){
                    model.setAEZET(null);
                }
                yvEtCfaratesRepo.save(model);
                //  System.out.println("coming out of CFA...........................");
            }

            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }





    //============================================================================================================================================
    public ApiResponse2     YM_PO_DET_RFC_HO_LUBES(PaymentDto dto) {

      //  System.out.println(".........inside Ho Lubes...........................");
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/YM_PO_DET_RFC_HO_LUBES",
                userName = "b2buser", password = "iocl1234", request = "";
        // String url= "http://localhost:8085/YM_PO_DET_RFC_HO_LUBES";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";

/*            {
                "CREATED_ON": {
                "item": {
                    "SIGN": "I",
                            "OPTION": "BT",
                            "LOW": "2022-01-01",
                            "HIGH": "2022-06-30"
                }
            },
                "DOCUMENT_TYPE": {
                "item": "ZP"
            },
                "MATERIAL_TYPE": {
                "item": "LUBE"
            },
                "PLANT": {
                "item": {
                    "WERKS": "4221"
                }
            }}*/
            String jsonInputString = "{\n" +
                    "    \"CREATED_ON\": {\n" +
                    "        \"item\" : {\n" +
                    "            \"SIGN\":" + dto.getSIGN() +"," +
                    "            \"OPTION\":" + dto.getOPTION() +"," +
                    "            \"LOW\":" + dto.getLOW() +"," +
                    "            \"HIGH\":" + dto.getHIGH() +
                    "        }\n" +
                    "    },\n" +
                    "    \"DOCUMENT_TYPE\":\n" +
                    "    {\n" +
                    "        \"item\":" + dto.getDOCUMENT_TYPE() +
                    "    },\n" +
                    "    \"MATERIAL_TYPE\":\n" +
                    "    {\n" +
                    "        \"item\" :" + dto.getMATERIAL_TYPE() +
                    "    },\n" +
                    "    \"PLANT\":\n" +
                    "    {\n" +
                    "        \"item\": {\n" +
                    "            \"WERKS\":"+ dto.getWERKS() +"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
//                System.out.println("HO Lubes json-------------------"+inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
//            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
//            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
//            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);

            for(int i=0;i<response.getOUTPUT().getItem().size();i++){
                YM_PO_DET_RFC_HO_LUBES_Model model = new YM_PO_DET_RFC_HO_LUBES_Model();

                try {
                    model.setBSART(response.getOUTPUT().getItem().get(i).getBSART());
                } catch (NullPointerException e) {
                    model.setBSART(null);

                }
                try {
                    model.setWRBTR(response.getOUTPUT().getItem().get(i).getWRBTR());
                } catch (NullPointerException e) {
                    model.setWRBTR(null);

                }
                try {
                    model.setBSTYP(response.getOUTPUT().getItem().get(i).getBSTYP());
                } catch (NullPointerException e) {
                    model.setBSTYP(null);

                }
                try {
                    model.setEBELN(response.getOUTPUT().getItem().get(i).getEBELN());
                } catch (NullPointerException e) {
                    model.setEBELN(null);

                }
                try {
                    model.setEBELP(response.getOUTPUT().getItem().get(i).getEBELP());
                } catch (NullPointerException e) {
                    model.setEBELP(null);

                }
                try {
                    model.setLOEKZ(response.getOUTPUT().getItem().get(i).getLOEKZ());
                } catch (NullPointerException e) {
                    model.setLOEKZ(null);

                }
                try {
                    model.setWERKS(response.getOUTPUT().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);

                }
                try {
                    model.setAEDAT(response.getOUTPUT().getItem().get(i).getAEDAT());
                } catch (NullPointerException e) {
                    model.setAEDAT(null);

                }
                try {
                    model.setWAERS(response.getOUTPUT().getItem().get(i).getWAERS());
                } catch (NullPointerException e) {
                    model.setWAERS(null);

                }
                try {
                    model.setKONNR(response.getOUTPUT().getItem().get(i).getKONNR());
                } catch (NullPointerException e) {
                    model.setKONNR(null);

                }
                try {
                    model.setKTPNR(response.getOUTPUT().getItem().get(i).getKTPNR());
                } catch (NullPointerException e) {
                    model.setKTPNR(null);

                }
                try {
                    model.setMTART(response.getOUTPUT().getItem().get(i).getMTART());
                } catch (NullPointerException e) {
                    model.setMTART(null);

                }
                try {
                    model.setMATKL(response.getOUTPUT().getItem().get(i).getMATKL());
                } catch (NullPointerException e) {
                    model.setMATKL(null);

                }
                try {
                    model.setMATNR(response.getOUTPUT().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);

                }
                try {
                    model.setBELNR(response.getOUTPUT().getItem().get(i).getBELNR());
                } catch (NullPointerException e) {
                    model.setBELNR(null);

                }
                try {
                    model.setGJAHR(response.getOUTPUT().getItem().get(i).getGJAHR());
                } catch (NullPointerException e) {
                    model.setGJAHR(null);

                }
                try {
                    model.setBUZEI(response.getOUTPUT().getItem().get(i).getBUZEI());
                } catch (NullPointerException e) {
                    model.setBUZEI(null);
                }
                try {
                    model.setMEINS(response.getOUTPUT().getItem().get(i).getMEINS());
                } catch (NullPointerException e) {
                    model.setMEINS(null);

                }
                try {
                    model.setBSTME(response.getOUTPUT().getItem().get(i).getBSTME());
                } catch (NullPointerException e) {
                    model.setBSTME(null);
                }
                ym_po_det_rfc_ho_lubes_repo.save(model);
                System.out.println(".......................ho lubes method 1 saved...........................");
            }
//            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }

    }

    public ApiResponse2 YV_EXCHG_RATE(PaymentDto dto) {

        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_EXCHG_RATE",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString = "{\n" +
                    "    \"I_FROM_DATE\":" +dto.getI_FROM_DATE()+"," +"\n"+
                    "    \"I_TO_DATE\":" +dto.getI_TO_DATE()+"\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
////            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
////            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YV_EXCHG_RATE_Resp response = mapper.readValue(json, YV_EXCHG_RATE_Resp.class);
            for(int i=0;i<response.getET_EXCH_RATE().getItem().size();i++){
                YV_EXCHG_RATE_ET_EXCH_RATE_Model model = new YV_EXCHG_RATE_ET_EXCH_RATE_Model();


                try {
                    model.setMANDT(response.getET_EXCH_RATE().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);

                }
                try {
                    model.setKURST(response.getET_EXCH_RATE().getItem().get(i).getKURST());
                } catch (NullPointerException e) {
                    model.setKURST(null);

                }
                try {
                    model.setFCURR(response.getET_EXCH_RATE().getItem().get(i).getFCURR());
                } catch (NullPointerException e) {
                    model.setFCURR(null);

                }
                try {
                    model.setTCURR(response.getET_EXCH_RATE().getItem().get(i).getTCURR());
                } catch (NullPointerException e) {
                    model.setTCURR(null);

                }
                try {
                    model.setGDATU(response.getET_EXCH_RATE().getItem().get(i).getGDATU());
                } catch (NullPointerException e) {
                    model.setGDATU(null);

                }
                try {
                    model.setUKURS(response.getET_EXCH_RATE().getItem().get(i).getUKURS());
                } catch (NullPointerException e) {
                    model.setUKURS(null);

                }
                try {
                    model.setFFACT(response.getET_EXCH_RATE().getItem().get(i).getFFACT());
                } catch (NullPointerException e) {
                    model.setFFACT(null);

                }
                try {
                    model.setTFACT(response.getET_EXCH_RATE().getItem().get(i).getTFACT());
                } catch (NullPointerException e) {
                    model.setTFACT(null);
                }
                yv_exchg_rate_et_exch_rate_repo.save(model);
            }
            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }

    private boolean finderror(String json) {
        if(json.length()<20){
            return true;
        }
        boolean isFound = json.contains("Data not found");
        return isFound;
    }

    public ApiResponse2
    YV_MATERIAL_MASTER_ALL_VIEWS(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_MATERIAL_MASTER_ALL_VIEWS",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;

            String jsonInputString = "{\n" +
                    "    \"I_FROM_DATE\":" + dto.getI_FROM_DATE()+","+"\n" +
                    "    \"I_TO_DATE\":" + dto.getI_TO_DATE()+","+"\n" +
                    "    \"I_DIVISION\":" +dto.getI_DIVISION()+"\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);

            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            MaterialMasterResponse response = mapper.readValue(json, MaterialMasterResponse.class);
            for(int i=0;i<response.getE_MARA().getItem().size();i++){
                MaterialMasterEmaraModel model = new MaterialMasterEmaraModel();
                try {
                    model.setMATNR(response.getE_MARA().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);
                }

                try {
                    model.setMAKTX(response.getE_MARA().getItem().get(i).getMAKTX());
                } catch (NullPointerException e) {
                    model.setMAKTX(null);

                }
                try {
                    model.setBISM(response.getE_MARA().getItem().get(i).getBISM());
                } catch (NullPointerException e) {
                    model.setBISM(null);
                }

                try {
                    model.setGROES(response.getE_MARA().getItem().get(i).getGROES());
                } catch (NullPointerException e) {
                    model.setGROES(null);
                }
                try {
                    model.setWRKST(response.getE_MARA().getItem().get(i).getWRKST());
                } catch (NullPointerException e) {
                    model.setWRKST(null);
                }
                try {
                    model.setFERTH(response.getE_MARA().getItem().get(i).getFERTH());
                } catch (NullPointerException e) {
                    model.setFERTH(null);

                }
                try {
                    model.setNORMT(response.getE_MARA().getItem().get(i).getNORMT());
                } catch (NullPointerException e) {
                    model.setNORMT(null);

                }
                try {
                    model.setMEINS(response.getE_MARA().getItem().get(i).getMEINS());
                } catch (NullPointerException e) {
                    model.setMEINS(null);

                }
                try {
                    model.setBRGEW(response.getE_MARA().getItem().get(i).getBRGEW());
                } catch (NullPointerException e) {
                    model.setBRGEW(null);

                }
                try {
                    model.setNTGEW(response.getE_MARA().getItem().get(i).getNTGEW());
                } catch (NullPointerException e) {
                    model.setNTGEW(null);

                }
                try {
                    model.setTRAGR(response.getE_MARA().getItem().get(i).getTRAGR());
                } catch (NullPointerException e) {
                    model.setTRAGR(null);

                }
                try {
                    model.setERSDA(response.getE_MARA().getItem().get(i).getERSDA());
                } catch (NullPointerException e) {
                    model.setERSDA(null);

                }
                try {
                    model.setLAEDA(response.getE_MARA().getItem().get(i).getLAEDA());
                } catch (NullPointerException e) {
                    model.setLAEDA(null);

                }
                model.setDivision_code(dto.getI_DIVISION());
                materialMasterEmaraRepo.save(model);
            }
            for(int i=0;i<response.getE_MARC().getItem().size();i++){

                MaterialMasterEmarcModel model = new MaterialMasterEmarcModel();
                try {
                    model.setMATNR(response.getE_MARC().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);

                }
                try {
                    model.setWERKS(response.getE_MARC().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);

                }
                try {
                    model.setUOMGR(response.getE_MARC().getItem().get(i).getUOMGR());
                } catch (NullPointerException e) {
                    model.setUOMGR(null);

                }
                try {
                    model.setUMRSL(response.getE_MARC().getItem().get(i).getUMRSL());
                } catch (NullPointerException e) {
                    model.setUMRSL(null);
                }
                try {
                    model.setABFAC(response.getE_MARC().getItem().get(i).getABFAC());
                } catch (NullPointerException e) {
                    model.setABFAC(null);

                }
                model.setDivision_code(dto.getI_DIVISION());
                materialMasterEmarcRepo.save(model);


            }
            for(int i=0;i<response.getE_MVKE().getItem().size();i++){
                MaterialMasterEmvkeModel model = new MaterialMasterEmvkeModel();
                try {
                    model.setMATNR(response.getE_MVKE().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);
                }
                try {
                    model.setVKORG(response.getE_MVKE().getItem().get(i).getVKORG());
                } catch (NullPointerException e) {
                    model.setVKORG(null);
                }
                try {
                    model.setVTWEG(response.getE_MVKE().getItem().get(i).getVTWEG());
                } catch (NullPointerException e) {
                    model.setVTWEG(null);
                }
                try {
                    model.setKONDM(response.getE_MVKE().getItem().get(i).getKONDM());
                } catch (NullPointerException e) {
                    model.setKONDM(null);

                }
                try {
                    model.setKONDMT(response.getE_MVKE().getItem().get(i).getKONDMT());
                } catch (NullPointerException e) {
                    model.setKONDMT(null);

                }
                try {
                    model.setKTGRM(response.getE_MVKE().getItem().get(i).getKTGRM());
                } catch (NullPointerException e) {
                    model.setKTGRM(null);

                }
                try {
                    model.setKTGRMT(response.getE_MVKE().getItem().get(i).getKTGRMT());
                } catch (NullPointerException e) {
                    model.setKTGRMT(null);

                }
                try {
                    model.setMVGR1(response.getE_MVKE().getItem().get(i).getMVGR1());
                } catch (NullPointerException e) {
                    model.setMVGR1(null);

                }
                try {
                    model.setMVGR2(response.getE_MVKE().getItem().get(i).getMVGR2());
                } catch (NullPointerException e) {
                    model.setMVGR2(null);

                }
                try {
                    model.setMVGR3(response.getE_MVKE().getItem().get(i).getMVGR3());
                } catch (NullPointerException e) {
                    model.setMVGR3(null);

                }
                try {
                    model.setDWERK(response.getE_MVKE().getItem().get(i).getDWERK());
                } catch (NullPointerException e) {
                    model.setDWERK(null);

                }
                model.setDivision_code(dto.getI_DIVISION());
                materialMasterEmvkeRepo.save(model);
            }
            for(int i=0;i<response.getE_MBEW().getItem().size();i++){
                MaterialMasterEmbewModel model = new MaterialMasterEmbewModel();
                try {
                    model.setMATNR(response.getE_MBEW().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);

                }
                try {
                    model.setBWKEY(response.getE_MBEW().getItem().get(i).getBWKEY());
                } catch (NullPointerException e) {
                    model.setBWKEY(null);

                }
                try {
                    model.setBKLAS(response.getE_MBEW().getItem().get(i).getBKLAS());
                } catch (NullPointerException e) {
                    model.setBKLAS(null);

                }
                try {
                    model.setVPRSV(response.getE_MBEW().getItem().get(i).getVPRSV());
                } catch (NullPointerException e) {
                    model.setVPRSV(null);

                }
                try {
                    model.setVERPR(response.getE_MBEW().getItem().get(i).getVERPR());
                } catch (NullPointerException e) {
                    model.setVERPR(null);

                }
                try {
                    model.setSTPRS(response.getE_MBEW().getItem().get(i).getSTPRS());
                } catch (NullPointerException e) {
                    model.setSTPRS(null);

                }
                model.setDivision_code(dto.getI_DIVISION());
                materialMasterEmbewRepo.save(model);

            }
            for(int i=0;i<response.getE_MARM().getItem().size();i++){
                MaterialMasterEmarmModel model = new MaterialMasterEmarmModel();
model.setDivision_code(dto.getI_DIVISION());
                try {
                    model.setMATNR(response.getE_MARM().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);

                }
                try {
                    model.setUMREN(response.getE_MARM().getItem().get(i).getUMREN());
                } catch (NullPointerException e) {
                    model.setUMREN(null);

                }
                try {
                    model.setMEINH(response.getE_MARM().getItem().get(i).getMEINH());
                } catch (NullPointerException e) {
                    model.setMEINH(null);

                }
                try {
                    model.setSEPRTR(response.getE_MARM().getItem().get(i).getSEPRTR());
                } catch (NullPointerException e) {
                    model.setSEPRTR(null);

                }
                try {
                    model.setUMREZ(response.getE_MARM().getItem().get(i).getUMREZ());
                } catch (NullPointerException e) {
                    model.setUMREZ(null);

                }
                try {
                    model.setMEINS(response.getE_MARM().getItem().get(i).getMEINS());
                } catch (NullPointerException e) {
                    model.setMEINS(null);

                }
                materialMasterEmarmRepo.save(model);

            }
            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }

    public ApiResponse2 Y_LUBEBOM_DNLD(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/Y_LUBEBOM_DNLD",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
            String jsonInputString = "{\n" +
                    "    \"I_ALL_BOMM\":" + dto.getI_ALL_BOMM() + ",\n" +
                    "    \"I_MAINBOM_ONLY\":" + dto.getI_MAINBOM_ONLY() + "\n" +
                    "}";

            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            Y_LUBEBOM_DNLD_Resp response = mapper.readValue(json, Y_LUBEBOM_DNLD_Resp.class);
            for(int i=-0;i<response.getE_BOM().getItem().size();i++){
                Y_LUBEBOM_DNLD_Model model = new Y_LUBEBOM_DNLD_Model();
                try {
                    model.setWERKS(response.getE_BOM().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);
                }
                try {
                    model.setMATNR(response.getE_BOM().getItem().get(i).getMATNR());
                } catch (NullPointerException e) {
                    model.setMATNR(null);

                }
                try {
                    model.setSTLNR(response.getE_BOM().getItem().get(i).getSTLNR());
                } catch (NullPointerException e) {
                    model.setSTLNR(null);

                }
                try {
                    model.setSTLAL(response.getE_BOM().getItem().get(i).getSTLAL());
                } catch (NullPointerException e) {
                    model.setSTLAL(null);

                }
                try {
                    model.setPOSNR(response.getE_BOM().getItem().get(i).getPOSNR());
                } catch (NullPointerException e) {
                    model.setPOSNR(null);

                }
                try {
                    model.setSTLKN(response.getE_BOM().getItem().get(i).getSTLKN());
                } catch (NullPointerException e) {
                    model.setSTLKN(null);
                }
                try {
                    model.setIDNRK(response.getE_BOM().getItem().get(i).getIDNRK());
                } catch (NullPointerException e) {
                    model.setIDNRK(null);

                }
                try {
                    model.setCOMNM(response.getE_BOM().getItem().get(i).getCOMNM());
                } catch (NullPointerException e) {
                    model.setCOMNM(null);

                }
                try {
                    model.setMEINS(response.getE_BOM().getItem().get(i).getMEINS());
                } catch (NullPointerException e) {
                    model.setMEINS(null);

                }
                try {
                    model.setMENGE(response.getE_BOM().getItem().get(i).getMENGE());
                } catch (NullPointerException e) {
                    model.setMENGE(null);

                }
                try {
                    model.setVERPR(response.getE_BOM().getItem().get(i).getVERPR());
                } catch (NullPointerException e) {
                    model.setVERPR(null);

                }
                try {
                    model.setSTPRS(response.getE_BOM().getItem().get(i).getSTPRS());
                } catch (NullPointerException e) {
                    model.setSTPRS(null);

                }
                try {
                    model.setMTART(response.getE_BOM().getItem().get(i).getMTART());
                } catch (NullPointerException e) {
                    model.setMTART(null);

                }
                try {
                    model.setDATUV(response.getE_BOM().getItem().get(i).getDATUV());
                } catch (NullPointerException e) {
                    model.setDATUV(null);

                }
                y_lubebom_dnld_repo.save(model);

            }
            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }

    public ApiResponse2 YV_CONTRACT_RATES(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_CONTRACT_RATES",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;

            String jsonInputString = "{\n" +
                    "    \"I_FKDAT\": \"" + dto.getI_FKDAT() + "\"\n" +
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            YV_CONTRACT_RATES_Resp response = mapper.readValue(json, YV_CONTRACT_RATES_Resp.class);
            for(int i=0;i<response.getI_TPLST().getItem().size();i++){
                YV_CONTRACT_RATES_I_TPLST model = new YV_CONTRACT_RATES_I_TPLST();
                try {
                    model.setTPLST_SIGN(response.getI_TPLST().getItem().get(i).getTPLST_SIGN());
                } catch (Exception e) {
                    model.setTPLST_SIGN(null);
                }
                try {
                    model.setTPLST_OPTION(response.getI_TPLST().getItem().get(i).getTPLST_OPTION());
                } catch (Exception e) {
                    model.setTPLST_OPTION(null);
                }
                try {
                    model.setTPLST_LOW(response.getI_TPLST().getItem().get(i).getTPLST_LOW());
                } catch (Exception e) {
                    model.setTPLST_LOW(null);
                }
                try {
                    model.setTPLST_HIGH(response.getI_TPLST().getItem().get(i).getTPLST_HIGH());
                } catch (Exception e) {
                    model.setTPLST_HIGH(null);

                }
                yv_contract_rates_i_tplst_repo.save(model);
            }
            for(int i=0;i<response.getI_BUKRS().getItem().size();i++){
                YV_CONTRACT_RATE_I_BURKS model = new YV_CONTRACT_RATE_I_BURKS();

                try {
                    model.setHIGH(response.getI_BUKRS().getItem().get(i).getHIGH());
                } catch (Exception e) {
                    model.setHIGH(null);

                }
                try {
                    model.setLOW(response.getI_BUKRS().getItem().get(i).getLOW());
                } catch (Exception e) {
                    model.setLOW(null);

                }
                try {
                    model.setSIGN(response.getI_BUKRS().getItem().get(i).getSIGN());
                } catch (Exception e) {
                    model.setSIGN(null);

                }
                try {
                    model.setOPTION(response.getI_BUKRS().getItem().get(i).getOPTION());
                } catch (Exception e) {
                    model.setOPTION(null);

                }
                yv_contract_rate_i_burks_repo.save(model);

            }
            for(int i=0;i<response.getO_REPORT().getItem().size();i++){
                YV_CONTRACT_RATES_O_REPORT model = new YV_CONTRACT_RATES_O_REPORT();
                try {
                    model.setBUKRS(response.getO_REPORT().getItem().get(i).getBUKRS());
                } catch (Exception e) {
                    model.setBUKRS(null);

                }
                try {
                    model.setTPLST(response.getO_REPORT().getItem().get(i).getTPLST());
                } catch (Exception e) {
                    model.setTPLST(null);

                }
                try {
                    model.setVSTEL(response.getO_REPORT().getItem().get(i).getVSTEL());
                } catch (Exception e) {
                    model.setVSTEL(null);

                }
                try {
                    model.setNAME1(response.getO_REPORT().getItem().get(i).getNAME1());
                } catch (Exception e) {
                    model.setNAME1(null);

                }
                try {
                    model.setYYTENDERNO(response.getO_REPORT().getItem().get(i).getYYTENDERNO());
                } catch (Exception e) {
                    model.setYYTENDERNO(null);

                }
                try {
                    model.setMATKL(response.getO_REPORT().getItem().get(i).getMATKL());
                } catch (Exception e) {
                    model.setMATKL(null);

                }
                try {
                    model.setCAPCLUSTER(response.getO_REPORT().getItem().get(i).getCAPCLUSTER());
                } catch (Exception e) {
                    model.setCAPCLUSTER(null);

                }
                try {
                    model.setCAP_DESC(response.getO_REPORT().getItem().get(i).getCAP_DESC());
                } catch (Exception e) {
                    model.setCAP_DESC(null);

                }
                try {
                    model.setRTDCLUSTER(response.getO_REPORT().getItem().get(i).getRTDCLUSTER());
                } catch (Exception e) {
                    model.setRTDCLUSTER(null);

                }
                try {
                    model.setRTD_DESC(response.getO_REPORT().getItem().get(i).getRTD_DESC());
                } catch (Exception e) {
                    model.setRTD_DESC(null);

                }
                try {
                    model.setDESTCLUSTER(response.getO_REPORT().getItem().get(i).getDESTCLUSTER());
                } catch (Exception e) {
                    model.setDESTCLUSTER(null);

                }
                try {
                    model.setDEST_DESC(response.getO_REPORT().getItem().get(i).getDEST_DESC());
                } catch (Exception e) {
                    model.setDEST_DESC(null);

                }
                try {
                    model.setKUNWE(response.getO_REPORT().getItem().get(i).getKUNWE());
                } catch (Exception e) {
                    model.setKUNWE(null);

                }
                try {
                    model.setNAME2(response.getO_REPORT().getItem().get(i).getNAME2());
                } catch (Exception e) {
                    model.setNAME2(null);

                }
                try {
                    model.setRATEAPP_DESC(response.getO_REPORT().getItem().get(i).getRATEAPP_DESC());
                } catch (Exception e) {
                    model.setRATEAPP_DESC(null);

                }
                try {
                    model.setFINAL_UOM(response.getO_REPORT().getItem().get(i).getFINAL_UOM());
                } catch (Exception e) {
                    model.setFINAL_UOM(null);

                }
                try {
                    model.setFINAL_UOMKM(response.getO_REPORT().getItem().get(i).getFINAL_UOMKM());
                } catch (Exception e) {
                    model.setFINAL_UOMKM(null);

                }
                try {
                    model.setREMARKS(response.getO_REPORT().getItem().get(i).getREMARKS());
                } catch (Exception e) {
                    model.setREMARKS(null);

                }
                yv_contract_rates_o_report_repo.save(model);
            }


            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }

    public ApiResponse2 YV_TPT_CUSTRTD(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_TPT_CUSTRTD",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;


            String jsonInputString = "{\n" +
                    "    \"VAL_DATE\": \""+dto.getVAL_DATE()+"\",\n" +
                    "    \"I_BUKRS\": {\n" +
                    "      \"item\": {\n" +
                    "        \"MANDT\": \""+dto.getMANDT()+"\",\n" +
                    "        \"BUKRS\": \""+dto.getBUKRS()+"\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"I_WERKS\": {\n" +
                    "      \"item\": {\n" +
                    "        \"MANDT\": \""+dto.getMANDT()+"\",\n" +
                    "        \"WERKS\": \""+dto.getWERKS()+"\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";

            String test = "{\n" +
                    "    \"VAL_DATE\": " + dto.getVAL_DATE() + ",\n" +
                    "    \"I_BUKRS\": {\n" +
                    "        \"item\": {\n" +
                    "            \"MANDT\": \"" + dto.getMANDT() + ",\n" +
                    "            \"BUKRS\": "+dto.getBUKRS()+"\" "+
                    "        }\n" +
                    "    },\n" +
                    "    \"I_WERKS\": {\n" +
                    "        \"item\": {\n" +
                    "            \"MANDT\": " + dto.getMANDT() + ",\n" +
                    "            \"WERKS\": " + dto.getWERKS() + "\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            String authHeader = "Basic " + new String(encodedAuth);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            if(finderror(json)){
                System.out.print("No data   ------------>"+jsonInputString);
                return new ApiResponse2<>(true,"No Data found",null,400);
            }
            ObjectMapper mapper = new ObjectMapper();
//                .featuresToDisable(MapperFeature.ALLOW_COERCION_OF_SCALARS)
//                    .featuresToDisable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
//                    .featuresToDisable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
//                    .featuresToDisable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
//                    .featuresToDisable(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS)
//                    .featuresToEnable(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES)
//                    .featuresToEnable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES)
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT,true);
            mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,true);
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            YV_TPT_CUSTRTD_Response response = mapper.readValue(json, YV_TPT_CUSTRTD_Response.class);
            for(int i=0;i<response.getI_TPT_CUSTRTD().getItem().size();i++){
                I_TPT_CUSTRTD_Model model = new I_TPT_CUSTRTD_Model();
                try {
                    model.setMANDT(response.getI_TPT_CUSTRTD().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);
                }
                try {
                    model.setVSTEL(response.getI_TPT_CUSTRTD().getItem().get(i).getVSTEL());
                } catch (NullPointerException e) {
                    model.setVSTEL(null);

                }
                try {
                    model.setKUNWE(response.getI_TPT_CUSTRTD().getItem().get(i).getKUNWE());
                } catch (NullPointerException e) {
                    model.setKUNWE(null);

                }
                try {
                    model.setRTDSTATUS(response.getI_TPT_CUSTRTD().getItem().get(i).getRTDSTATUS());
                } catch (NullPointerException e) {
                    model.setRTDSTATUS(null);

                }
                try {
                    model.setBEGDA(response.getI_TPT_CUSTRTD().getItem().get(i).getBEGDA());
                } catch (NullPointerException e) {
                    model.setBEGDA(null);

                }
                try {
                    model.setENDDA(response.getI_TPT_CUSTRTD().getItem().get(i).getENDDA());
                } catch (NullPointerException e) {
                    model.setENDDA(null);

                }
                try {
                    model.setDIST_P(response.getI_TPT_CUSTRTD().getItem().get(i).getDIST_P());
                } catch (NullPointerException e) {
                    model.setDIST_P(null);

                }
                try {
                    model.setDIST_H(response.getI_TPT_CUSTRTD().getItem().get(i).getDIST_H());
                } catch (NullPointerException e) {
                    model.setDIST_H(null);

                }
                try {
                    model.setDESTCLUSTER(response.getI_TPT_CUSTRTD().getItem().get(i).getDESTCLUSTER());
                } catch (NullPointerException e) {
                    model.setDESTCLUSTER(null);

                }
                try {
                    model.setFDZ_IND(response.getI_TPT_CUSTRTD().getItem().get(i).getFDZ_IND());
                } catch (NullPointerException e) {
                    model.setFDZ_IND(null);

                }
                try {
                    model.setVEHCAP_IND(response.getI_TPT_CUSTRTD().getItem().get(i).getVEHCAP_IND());
                } catch (NullPointerException e) {
                    model.setVEHCAP_IND(null);

                }
                try {
                    model.setLEVI_ONEWAY(response.getI_TPT_CUSTRTD().getItem().get(i).getLEVI_ONEWAY());
                } catch (NullPointerException e) {
                    model.setLEVI_ONEWAY(null);

                }
                try {
                    model.setLEVI_TWOWAY(response.getI_TPT_CUSTRTD().getItem().get(i).getLEVI_TWOWAY());
                } catch (NullPointerException e) {
                    model.setLEVI_TWOWAY(null);
                }
                try {
                    model.setAPPROVAL_REF(response.getI_TPT_CUSTRTD().getItem().get(i).getAPPROVAL_REF());
                } catch (NullPointerException e) {
                    model.setAPPROVAL_REF(null);

                }
                try {
                    model.setCHANGE_REF(response.getI_TPT_CUSTRTD().getItem().get(i).getCHANGE_REF());
                } catch (NullPointerException e) {
                    model.setCHANGE_REF(null);

                }
                try {
                    model.setERNAM(response.getI_TPT_CUSTRTD().getItem().get(i).getERNAM());
                } catch (NullPointerException e) {
                    model.setERNAM(null);

                }
                try {
                    model.setERDAT(response.getI_TPT_CUSTRTD().getItem().get(i).getERDAT());
                } catch (NullPointerException e) {
                    model.setERDAT(null);

                }
                try {
                    model.setERZET(response.getI_TPT_CUSTRTD().getItem().get(i).getERZET());
                } catch (NullPointerException e) {
                    model.setERZET(null);

                }
                try {
                    model.setAENAM(response.getI_TPT_CUSTRTD().getItem().get(i).getAENAM());
                } catch (NullPointerException e) {
                    model.setAENAM(null);

                }
                try {
                    model.setAEDAT(response.getI_TPT_CUSTRTD().getItem().get(i).getAEDAT());
                } catch (NullPointerException e) {
                    model.setAEDAT(null);

                }
                try {
                    model.setAEZET(response.getI_TPT_CUSTRTD().getItem().get(i).getAEZET());
                } catch (NullPointerException e) {
                    model.setAEZET(null);

                }
                try {
                    model.setGEO_RTD(response.getI_TPT_CUSTRTD().getItem().get(i).getGEO_RTD());
                } catch (NullPointerException e) {
                    model.setGEO_RTD(null);

                }
                try {
                    model.setSHIP_STATE(response.getI_TPT_CUSTRTD().getItem().get(i).getSHIP_STATE());
                } catch (NullPointerException e) {
                    model.setSHIP_STATE(null);

                }
                try {
                    model.setSHPT_STATE(response.getI_TPT_CUSTRTD().getItem().get(i).getSHPT_STATE());
                } catch (NullPointerException e) {
                    model.setSHPT_STATE(null);
                }
                try {
                    model.setSHPT_BOTTOM_LOAD(response.getI_TPT_CUSTRTD().getItem().get(i).getSHPT_BOTTOM_LOAD());
                } catch (NullPointerException e) {
                    model.setSHPT_BOTTOM_LOAD(null);
                }
                i_tpt_custrtd_repo.save(model);
            }
            for(int i=0;i<response.getI_BUKRS().getItem().size();i++){
                I_TPT_CUSTRTD_I_BUKRS model = new I_TPT_CUSTRTD_I_BUKRS();
                try {
                    model.setMANDT(response.getI_BUKRS().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);

                }
                try {
                    model.setBUKRS(response.getI_BUKRS().getItem().get(i).getBUKRS());
                } catch (NullPointerException e) {
                    model.setBUKRS(null);

                }
                i_tpt_custrtd_i_bukrs_repo.save(model);
            }
            for(int i=0;i<response.getI_WERKS().getItem().size();i++){
                I_TPT_CUSTRTD_I_WERKS model = new I_TPT_CUSTRTD_I_WERKS();
                try {
                    model.setMANDT(response.getI_WERKS().getItem().get(i).getMANDT());
                } catch (NullPointerException e) {
                    model.setMANDT(null);

                }
                try {
                    model.setWERKS(response.getI_WERKS().getItem().get(i).getWERKS());
                } catch (NullPointerException e) {
                    model.setWERKS(null);

                }
                i_tpt_custrtd_i_werks_repo.save(model);

            }
            return new ApiResponse2<>(true,"Data saved",null,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }
}