package com.abel.cryptography.democrypto.controller;

import com.abel.cryptography.democrypto.dto.SuccessResponse;
import com.abel.cryptography.democrypto.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@RestController(value = "api/crypto/sha1")
public class CryptoController {
    @Autowired
    CryptoService cryptoService;

    @PostMapping(value = "hash", consumes = "text/plain")
    ResponseEntity<SuccessResponse> encrypt(@RequestBody String pText) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Object data = cryptoService.getSHA1(pText);
        String message = "Success Encrypted";
        return ResponseEntity.ok(SuccessResponse.body(message, data));
    }
}
