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
    YV_LU_PCK_RATE_ET_CAR_GRP_Repo yv_lu_pck_rate_et_car_grp_repo;

    @Autowired
    YV_LU_PCK_RATE_ET_TRANSRATE_REPO yv_lu_pck_rate_et_transrate_repo;

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
                    "    \"I_FROM_DATE\"   :" + dto.getI_FROM_DATE()+","+
                    "    \"I_TO_DATE\" :" + dto.getI_TO_DATE()+","+
                    "    \"I_WERKS\":\n" +
                    "    {\n" +
                    "        \"item\":\n" +
                    "        {\n" +
                    "            \"WERKS\" :" + dto.getWERKS()+
                    "        }\n" +
                    "\n" +
                    "    }\n" +
                    "\n" +
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT,false);
//            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YV_LU_PCK_Rate_Response response = mapper.readValue(json, YV_LU_PCK_Rate_Response.class);
            System.out.println("Test" + json);

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
    public ApiResponse2 YM_PO_DET_RFC_HO_LUBES(PaymentDto dto) {


        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/YM_PO_DET_RFC_HO_LUBES",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString = "{\n" +
                    "    \"CREATED_ON\": {\n" +
                    "        \"item\" : {\n" +
                    "            \"SIGN\": \"I\",\n" +
                    "            \"OPTION\": \"BT\",\n" +
                    "            \"LOW\": \"2022-01-01\",\n" +
                    "            \"HIGH\": \"2022-06-30\"\n" +
                    "        }\n" +
                    "    },\n" +
                    "    \"DOCUMENT_TYPE\":\n" +
                    "    {\n" +
                    "        \"item\": \"ZP\"\n" +
                    "    },\n" +
                    "    \"MATERIAL_TYPE\":\n" +
                    "    {\n" +
                    "        \"item\" :\"LUBE\"\n" +
                    "    },\n" +
                    "    \"PLANT\":\n" +
                    "    {\n" +
                    "        \"item\": {\n" +
                    "            \"WERKS\":\"4221\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
//            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
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
                    "    \"I_FROM_DATE\": \"2022-01-01\",\n" +
                    "    \"I_TO_DATE\": \"2022-09-30\"\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
////            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
////            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            YV_EXCHG_RATE_Resp response = mapper.readValue(json, YV_EXCHG_RATE_Resp.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }

    public ApiResponse2 YV_MATERIAL_MASTER_ALL_VIEWS(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_MATERIAL_MASTER_ALL_VIEWS",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString = "{\n" +
                    "    \"I_FROM_DATE\": \"2022-01-05\",\n" +
                    "    \"I_TO_DATE\": \"2022-01-05\",\n" +
                    "    \"I_DIVISION\": \"LU\"\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
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
                materialMasterEmbewRepo.save(model);

            }
            for(int i=0;i<response.getE_MARM().getItem().size();i++){
                MaterialMasterEmarmModel model = new MaterialMasterEmarmModel();

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
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
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
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString = "{\n" +
                    "    \"I_ALL_BOMM\": \"X\",\n" +
                    "    \"I_MAINBOM_ONLY\": \"\"\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            Y_LUBEBOM_DNLD_Resp response = mapper.readValue(json, Y_LUBEBOM_DNLD_Resp.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
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
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString ="  {\n" +
                    "    \"I_FKDAT\": \"2022-07-01\"\n" +
                    "     \n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            YV_CONTRACT_RATES_Resp response = mapper.readValue(json, YV_CONTRACT_RATES_Resp.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
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
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";


            String jsonInputString = "{\n" +
                    "    \"VAL_DATE\": \"2022-01-01\",\n" +
                    "    \"I_BUKRS\": {\n" +
                    "      \"item\": {\n" +
                    "        \"MANDT\": \"310\",\n" +
                    "        \"BUKRS\": \"4000\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"I_WERKS\": {\n" +
                    "      \"item\": {\n" +
                    "        \"MANDT\": \"310\",\n" +
                    "        \"WERKS\": \"4221\"\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }";
            try {

                inputString = new StringEntity(jsonInputString);
                System.out.println(inputString);
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }

            HttpPost postRequest = new HttpPost(url);

            String auth = userName + ":" + password;
            byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
            System.out.println("Encoded String = " + new String(encodedAuth));
            String authHeader = "Basic " + new String(encodedAuth);
            System.out.println("Auth String =" + authHeader);
            postRequest.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

            inputString.setContentType("application/json");

            postRequest.setEntity(inputString);

            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();

            HttpResponse response1 = closeableHttpClient.execute(postRequest);

            int statusCode = response1.getStatusLine().getStatusCode();

            String json = EntityUtils.toString(response1.getEntity());
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            YV_TPT_CUSTRTD_Response response = mapper.readValue(json, YV_TPT_CUSTRTD_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",response,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }
}
