package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import com.springapp.mvc.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Controller
public class CostController {
    private MemberOfFamilyRepository memberRepository;
    private CostRepository costRepository;
    private MemberValidation memberValidation;
    private PropertiesCostRepository propertiesCostRepository;
    private GroupCostRepository groupCostRepository;

    @Autowired
    public CostController(MemberOfFamilyRepository memberRepository, CostRepository costRepository, MemberValidation memberValidation, PropertiesCostRepository propertiesCostRepository, GroupCostRepository groupCostRepository) {
        this.memberRepository = memberRepository;
        this.costRepository = costRepository;
        this.memberValidation = memberValidation;
        this.propertiesCostRepository = propertiesCostRepository;
        this.groupCostRepository = groupCostRepository;
    }

    @RequestMapping(value = "cost", method = RequestMethod.GET)
    public String cost(Model model, HttpServletRequest request) {

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

        List<GroupCost> groupCost = this.groupCostRepository.listAll();
        model.addAttribute("groupCost", groupCost);
        List<Cost> costs = this.costRepository.listAllMember(member.getId());
        model.addAttribute("costs", costs);

        return "cost";
    }
    @RequestMapping(value = "deleteCost/{id}", method = RequestMethod.GET)
    public String deleteCost(@PathVariable Integer id) {
        this.costRepository.removeCost(id);

        return "redirect:/cost";
    }

    @RequestMapping(value = "editCost/{id}", method = RequestMethod.GET)
    public String editCost(@PathVariable Integer id, Model model){

        List<GroupCost> groupCost = this.groupCostRepository.listAll();
        model.addAttribute("groupCost", groupCost);
        Cost cost = this.costRepository.findCost(id);
        model.addAttribute("cost", cost);
        PropertiesCost propertiesCost =  this.propertiesCostRepository.findPropertiesCost(cost.getPropertiesCostCollection().iterator().next().getId());
        model.addAttribute("propertiesCost", propertiesCost);
        return "editCost";
    }

    @RequestMapping(value = "/editCost2", method = RequestMethod.GET)
    public String editCost(HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");



        String idGroup = request.getParameter("group");
        Integer id = Integer.valueOf(idGroup);
        Cost cost = this.costRepository.findCost(Integer.valueOf(request.getParameter("id")));

            PropertiesCost propertiesCost = this.propertiesCostRepository.findPropertiesCost(cost.getPropertiesCostCollection().iterator().next().getId());
            GroupCost group = this.groupCostRepository.findGroupCostId(id);
            cost.setIdgroupCost(group);
            cost.setNameCost(request.getParameter("name"));
            propertiesCost.setIdCost(cost);
            propertiesCost.setData(sdf.parse(request.getParameter("data")));
            propertiesCost.setSum(Float.valueOf(request.getParameter("sum")));
            this.costRepository.updateCost(cost);
            this.propertiesCostRepository.updatePropertiesCost(propertiesCost);

        return "redirect:/cost";
    }



    @RequestMapping(value = "addCost", method = RequestMethod.GET)
    public ModelAndView addCost(HttpServletRequest request, Model model) throws ParseException {

        String memberLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        List <MemberOfFamily> members = this.memberRepository.listAll();
        MemberOfFamily member = new MemberOfFamily();
        ListIterator<MemberOfFamily> iterator = members.listIterator();
        while(iterator.hasNext()){
            member = iterator.next();
            if(memberLogin.equals(member.getLogin())){
                break;
            }
        }
        System.out.println(member);

        ModelAndView modelAndView = new ModelAndView("redirect:/cost");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Cost cost = new Cost();
        List<GroupCost> groupCost = this.groupCostRepository.listAll();
        String idGroup = request.getParameter("group");
        Integer id = Integer.valueOf(idGroup);
        GroupCost group = new GroupCost();
        PropertiesCost propertiesCost = new PropertiesCost();
        ListIterator<GroupCost> it = groupCost.listIterator();
        while(it.hasNext()){
            group = it.next();

            if(group.getId()== id){
                break;
            }

        }
        cost.setIdMember(member);
        cost.setNameCost(request.getParameter("name"));
        cost.setIdgroupCost(group);

        propertiesCost.setIdCost(cost);
        propertiesCost.setSum(Float.valueOf(request.getParameter("sum")));
        propertiesCost.setData(sdf.parse(request.getParameter("data")));

        this.costRepository.addContact(cost);
        this.propertiesCostRepository.addContact(propertiesCost);

        List<Cost> costs = this.costRepository.listAll();
        model.addAttribute("cost", costs);
        return modelAndView;
    }

    @RequestMapping(value = "addGroupCost", method = RequestMethod.GET)
    public ModelAndView addGroupCost(HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/cost");

        GroupCost group = new GroupCost();
        group.setNameGroup(request.getParameter("nameGroup"));

        this.groupCostRepository.addContact(group);
        return modelAndView;
    }

}

