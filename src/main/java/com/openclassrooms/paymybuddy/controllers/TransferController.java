package com.openclassrooms.paymybuddy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TransferController {


    @GetMapping(path = "transfer")
    public String getInformationForTransferPage() {
       return "transfer";
    }
}
