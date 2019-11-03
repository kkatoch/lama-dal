package com.lama.dal.controller;

import com.lama.dal.model.Email;
import com.lama.dal.service.EmailService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
@Slf4j
@RequiredArgsConstructor
@Api(tags = "Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity sendEmail(@Valid @RequestBody Email email) {
        emailService.sendMail(email);
        return ResponseEntity.ok().build();
    }
}
