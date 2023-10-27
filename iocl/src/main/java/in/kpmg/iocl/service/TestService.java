package in.kpmg.iocl.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import in.kpmg.iocl.dto.ApiResponse2;
import in.kpmg.iocl.dto.PaymentDto;
import in.kpmg.iocl.dto.YV_LU_PCK_Rate_Response;
import in.kpmg.iocl.models.YV_LU_PCK_RATE_ET_TRANSRATE;
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
    YV_LU_PCK_RATE_ET_TRANSRATE_REPO yv_lu_pck_rate_et_transrate_repo;
    public ApiResponse2 fetchAPI_YV_TPT_CUSTRTD(PaymentDto dto) {
        try {
            String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_TPT_CUSTRTD";
            String result="";
            URL obj = new URL(url);
            CloseableHttpClient closeableHttpClient = getCloseableHttpClient();
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("b2buser:iocl1234");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"VAL_DATE\": 2022-09-09"+"\n" +
                    "\"I_BURKS\":" +""+ "\n" +
                    "\"I_WERKS\":" + "1140,31HS," + "\n" +
                    "}";
            DataOutputStream writeRequest = new DataOutputStream(HTTPConnection.getOutputStream());
            writeRequest.writeBytes(jsonInputString);
            writeRequest.flush();
            writeRequest.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(HTTPConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            ObjectMapper mapper = new ObjectMapper();
            return new ApiResponse2<>(true,"Success",result,200);

//            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (Exception e){
            return new ApiResponse2<>(false,"Internal server error",e.getMessage(),500);
        }
    }
    private String base64encoder (String str){
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
    public ApiResponse2 fetchAPI_YM_PO_DET_RFC_HO_LUBES(PaymentDto dto) {
        try {
            String url = "https://coisebizuat.ds.indianoil.in:6900/uat/RESTAdapter/RFC/YM_PO_DET_RFC_HO_LUBES";
            String result="";



            URL obj = new URL(url);
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("b2buser:iocl1234");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"CREATED_ON\": 2022-09-09"+"\n" +
                    "\"MATERIAL_TYPE\":" +""+ "\n" +
                    "\"WERKS\":" + "1140,31HS," + "\n" +
                    "}";
            DataOutputStream writeRequest = new DataOutputStream(HTTPConnection.getOutputStream());
            writeRequest.writeBytes(jsonInputString);
            writeRequest.flush();
            writeRequest.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(HTTPConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            return new ApiResponse2<>(true,"Success",result,200);
//            ObjectMapper mapper = new ObjectMapper();
//            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ApiResponse2 fetchAPI_YV_LU_PCK_RATE(PaymentDto dto) {
        try {
            String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_LU_PCK_RATE";
            String result="";



            URL obj = new URL(url);
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("b2buser:iocl1234");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"VAL_DATE\": 2022-09-09"+"\n" +
                    "\"I_BURKS\":" +""+ "\n" +
                    "\"I_WERKS\":" + "1140,31HS," + "\n" +
                    "}";
            DataOutputStream writeRequest = new DataOutputStream(HTTPConnection.getOutputStream());
            writeRequest.writeBytes(jsonInputString);
            writeRequest.flush();
            writeRequest.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(HTTPConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            return new ApiResponse2<>(true,"Success",result,200);
//            ObjectMapper mapper = new ObjectMapper();
//            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ApiResponse2 fetchAPI_YV_MATERIAL_MASTER_ALL_VIEWS(PaymentDto dto) {
        try {
            String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_MATERIAL_MASTER_ALL_VIEWS";
            String result="";



            URL obj = new URL(url);
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("b2buser:iocl1234");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"VAL_DATE\": 2022-09-09"+"\n" +
                    "\"I_BURKS\":" +""+ "\n" +
                    "\"I_WERKS\":" + "1140,31HS," + "\n" +
                    "}";
            DataOutputStream writeRequest = new DataOutputStream(HTTPConnection.getOutputStream());
            writeRequest.writeBytes(jsonInputString);
            writeRequest.flush();
            writeRequest.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(HTTPConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            return new ApiResponse2<>(true,"Success",result,200);
//            ObjectMapper mapper = new ObjectMapper();
//            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ApiResponse2 fetchAPI_YV_EXCHG_RATE(PaymentDto dto) {
        try {
            String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_EXCHG_RATE";
            String result="";



            URL obj = new URL(url);
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("b2buser:iocl1234");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"VAL_DATE\": 2022-09-09"+"\n" +
                    "\"I_BURKS\":" +""+ "\n" +
                    "\"I_WERKS\":" + "1140,31HS," + "\n" +
                    "}";
            DataOutputStream writeRequest = new DataOutputStream(HTTPConnection.getOutputStream());
            writeRequest.writeBytes(jsonInputString);
            writeRequest.flush();
            writeRequest.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(HTTPConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            result = response.toString();
            return new ApiResponse2<>(true,"Success",result,200);
//            ObjectMapper mapper = new ObjectMapper();
//            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ApiResponse2 testservice(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_LU_PCK_RATE",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
            String jsonInputString = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";

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
            System.out.println("Test" + json);
            responseMap.put(response1.getStatusLine().getStatusCode(), json);
            return new ApiResponse2<>(true,"Success",json,200);

        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);

        }
    }
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
    public ApiResponse2 testservice1(PaymentDto dto) {
        String url = "https://coisebizuat.ds.indianoil.in:7000/uat/RESTAdapter/RFC/MKHO/YV_LU_PCK_RATE",
                userName = "b2buser", password = "iocl1234", request = "";
        Map<Integer, String> responseMap = new HashMap<>();

        try {

            StringEntity inputString = null;
//            String jsonInputString1 = "{\r\n" + "    \"I_FROM_DATE\": \"2022-01-05\",\r\n"
//                    + "    \"I_TO_DATE\": \"2022-01-30\",\r\n" + "    \"I_WERKS\": {\r\n" + "      \"item\": {\r\n"
//                    + "        \"WERKS\": \"4136\"\r\n" + "      }\r\n" + "    }\r\n" + "  }";

            String jsonInputString = "{\n" +
                    "    \"I_FROM_DATE\"   :   \"2022-01-05\",\n" +
                    "    \"I_TO_DATE\" :   \"2022-01-30\",\n" +
                    "    \"I_WERKS\":\n" +
                    "    {\n" +
                    "        \"item\":\n" +
                    "        {\n" +
                    "            \"WERKS\" :   \"4136\"\n" +
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
            return new ApiResponse2<>(true,"Success",response,200);

        } catch (Exception e) {
            e.printStackTrace();
            return new ApiResponse2<>(false,"Internal Server Error",e.getMessage(),500);

        }}

}
