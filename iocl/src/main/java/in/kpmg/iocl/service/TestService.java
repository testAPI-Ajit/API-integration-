package in.kpmg.iocl.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.kpmg.iocl.dto.ApiResponse2;
import in.kpmg.iocl.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Base64;

@Service
public class TestService {
    public ApiResponse2 fetchAPI(PaymentDto dto) {
        try {
            String url = "";
            String result="";



            URL obj = new URL(url);
            HttpURLConnection HTTPConnection = (HttpURLConnection) obj.openConnection();

            HTTPConnection.setRequestMethod("POST");
            HTTPConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            HTTPConnection.setDoOutput(true);
            String hash = base64encoder("username:password");
            HTTPConnection.setRequestProperty("Authorization", "Basic " + hash);

            String jsonInputString = "{\n" +
                    "\"aadhaar_number\":" + aadharNumber + "\n" +
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
            UidVault uidVault = mapper.readValue(result, UidVault.class);
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String base64encoder (String str){
        return Base64.getEncoder().encodeToString(str.getBytes());
    }
}
