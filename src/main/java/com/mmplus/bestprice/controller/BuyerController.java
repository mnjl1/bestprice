package com.mmplus.bestprice.controller;

import com.mmplus.bestprice.entity.profile.Company;
import com.mmplus.bestprice.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/buyer")
public class BuyerController {
    private final CompanyService companyService;

    public BuyerController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companyForm")
    public String showCompanyForm(Model model, Company company){
        model.addAttribute("company", company);
        return "companyForm";
    }

    @PostMapping("/process-company-form")
    public String processCompanyForm(@Valid Company company, Errors errors){
        if (errors.hasErrors()){
            return "companyForm";
        }
        companyService.saveCompany(company);
        return "redirect:/home";
    }


}
