package com.springapp.mvc.controller;


import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import com.springapp.mvc.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ListIterator;

@Controller
public class MainController {

    private MemberOfFamilyRepository memberRepository;
    private CostRepository costRepository;
    private MemberValidation memberValidation;
    private PropertiesCostRepository propertiesCostRepository;
    private IncomeRepository incomeRepository;
    private AuthorityRepository authorityRepository;

    @Autowired
    public MainController(MemberOfFamilyRepository memberRepository, CostRepository costRepository, MemberValidation memberValidation, PropertiesCostRepository propertiesCostRepository, IncomeRepository incomeRepository, AuthorityRepository authorityRepository) {
        this.memberRepository = memberRepository;
        this.costRepository = costRepository;
        this.incomeRepository = incomeRepository;
        this.memberValidation = memberValidation;
        this.propertiesCostRepository = propertiesCostRepository;
        this.authorityRepository = authorityRepository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<MemberOfFamily> members = this.memberRepository.listAll();

               model.addAttribute("members", members);


        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String main(Model model) {
       return "index";
    }

    @RequestMapping(value = "management", method = RequestMethod.GET)
    public String management(Model model) {



        return "management";
    }

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registration(Model model) {

        return "registration";
    }

    @RequestMapping(value = "registration2", method = RequestMethod.GET)
    public String registration2(@ModelAttribute("member") MemberOfFamily member, BindingResult bindingResult) {

        this.memberValidation.validate(member, bindingResult);

        if(bindingResult.hasErrors())
        {
            return "registration";
        }

        this.memberRepository.addMember(member);

        Authority authority = new Authority();
        authority.setAuthority(member.getLogin());
        authority.setUId(member);
        this.authorityRepository.addContact(authority);
        return "redirect:/";
    }

    @RequestMapping(value = "cabinet", method = RequestMethod.GET)
    public String cabinet( Model model){

        String memberLogin = SecurityContextHolder.getContext().getAuthentication().getName();

        List <MemberOfFamily> members = this.memberRepository.listAll();
        MemberOfFamily member = new MemberOfFamily();
        ListIterator<MemberOfFamily> it = members.listIterator();
        while(it.hasNext()){
            member = it.next();
            if(memberLogin.equals(member.getLogin())){
                break;
            }
        }
        System.out.println(member);

        model.addAttribute("member", member);
        return "cabinet";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login( Model model){


        return "login";
    }


    @RequestMapping(value = "/cabinet2", method = RequestMethod.GET)
    public String cabinet(@ModelAttribute("member") MemberOfFamily member) throws ParseException {
         this.memberRepository.updateMember(member);

         List<Authority> authority = this.authorityRepository.listAllMember(member.getId());

        Authority auth = authority.iterator().next();
        auth.setAuthority(member.getLogin());
        this.authorityRepository.updateAuthority(auth);


        return "redirect:/";
    }
}
