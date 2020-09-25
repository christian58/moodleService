package com.unsa.cieiapi.controller;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.unsa.cieiapi.datasource.Response;
import com.unsa.cieiapi.datasource.ResponseCreate;
import com.unsa.cieiapi.model.Create;
import com.unsa.cieiapi.model.Suma;

@Controller
@RequestMapping("/v2")
public class CreateController {
	@RequestMapping(value="/create", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<ResponseCreate> createUser(@RequestBody Create create, UriComponentsBuilder uriComponentBuilder) throws MalformedURLException, IOException{
//	public static void main(String[] args) throws ProtocolException, IOException {

		ResponseCreate data = new ResponseCreate();

        /// NEED TO BE CHANGED
        String token = "b490cc8042fd76c6cc43b615606cdd87";
        String domainName = "http://167.99.13.147/cieionline/cieionline/";

        /// REST RETURNED VALUES FORMAT
        String restformat = "xml"; //Also possible in Moodle 2.2 and later: 'json'
                                   //Setting it to 'json' will fail all calls on earlier Moodle version
        if (restformat.equals("json")) {
            restformat = "&moodlewsrestformat=" + restformat;
        } else {
            restformat = "";
        }

        /// PARAMETERS - NEED TO BE CHANGED IF YOU CALL A DIFFERENT FUNCTION
        String functionName = "core_user_create_users";
        String urlParameters =
        "users[0][username]=" + URLEncoder.encode(create.getUsername(), "UTF-8") +
        "&users[0][password]=" + URLEncoder.encode(create.getPassword(), "UTF-8") +
        "&users[0][firstname]=" + URLEncoder.encode(create.getFirstname(), "UTF-8") +
        "&users[0][lastname]=" + URLEncoder.encode(create.getLastname(), "UTF-8") +
        "&users[0][email]=" + URLEncoder.encode(create.getEmail(), "UTF-8");


        /// REST CALL

        // Send request
        String serverurl = domainName + "/webservice/rest/server.php" + "?wstoken=" + token + "&wsfunction=" + functionName;
        HttpURLConnection con = (HttpURLConnection) new URL(serverurl).openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type",
           "application/x-www-form-urlencoded");
        con.setRequestProperty("Content-Language", "en-US");
        con.setDoOutput(true);
        con.setUseCaches (false);
        con.setDoInput(true);
        DataOutputStream wr = new DataOutputStream (
                  con.getOutputStream ());
        wr.writeBytes (urlParameters);
        wr.flush ();
        wr.close ();

        //Get Response
        InputStream is =con.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuilder response = new StringBuilder();
        while((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        System.out.println(response.toString());
        //try
        data.setRespuesta(true);
        data.setMensaje("Felicidades");
//		data.setRespuesta(true);
//		data.setMensaje("Se logro sumar");
//		data.setValorSuma(suma.getOperador1()+ suma.getOperador2());
        return new ResponseEntity<ResponseCreate>(data, HttpStatus.OK);
    }
	
	
}
