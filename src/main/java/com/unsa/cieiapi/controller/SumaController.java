package com.unsa.cieiapi.controller;

import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.unsa.cieiapi.datasource.Response;
import com.unsa.cieiapi.model.Suma;


@Controller
@RequestMapping("/v1")
public class SumaController {
	@RequestMapping(value="/sumar", method=RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity<Response> sendMail(@RequestBody Suma suma, UriComponentsBuilder uriComponentBuilder){
		Response data = new Response();
		data.setRespuesta(true);
		data.setMensaje("Se logro sumar");
		data.setValorSuma(suma.getOperador1()+ suma.getOperador2());
		
		return new ResponseEntity<Response>(data, HttpStatus.OK);
	}
	

}
