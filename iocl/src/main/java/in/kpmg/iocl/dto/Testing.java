package in.kpmg.iocl.dto;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Testing {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
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
            byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.ISO_8859_1));
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

        } catch (Exception e) {
            e.printStackTrace();
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
}
