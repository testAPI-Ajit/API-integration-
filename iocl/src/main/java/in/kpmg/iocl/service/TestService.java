package in.kpmg.iocl.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import in.kpmg.iocl.dto.*;
import in.kpmg.iocl.models.YV_LU_PCK_RATE_ET_CAR_GRP;
import in.kpmg.iocl.models.YV_LU_PCK_RATE_ET_TRANSRATE;
import in.kpmg.iocl.repository.YV_LU_PCK_RATE_ET_CAR_GRP_Repo;
import in.kpmg.iocl.repository.YV_LU_PCK_RATE_ET_TRANSRATE_REPO;
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
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
////            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
////            mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
//            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",json,200);
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
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
//            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",json,200);
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
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
//            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",json,200);
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
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            mapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
//            YM_PO_DET_RFC_HO_LUBES_Response response = mapper.readValue(json, YM_PO_DET_RFC_HO_LUBES_Response.class);
            System.out.println("Test" + json);
            return new ApiResponse2<>(true,"Data saved",json,200);
        }catch (Exception e){
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);
        }
    }
}
