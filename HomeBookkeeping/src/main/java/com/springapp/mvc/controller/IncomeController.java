package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import com.springapp.mvc.validation.MemberValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

@Controller
public class IncomeController {
    private MemberOfFamilyRepository memberRepository;
    private IncomeRepository incomeRepository;
    private MemberValidation memberValidation;
    private PropertiesIncomeRepository propertiesIncomeRepository;
    private GroupIncomeRepository groupIncomeRepository;

    @Autowired
    public IncomeController(MemberOfFamilyRepository memberRepository, IncomeRepository incomeRepository, MemberValidation memberValidation, PropertiesIncomeRepository propertiesIncomeRepository, GroupIncomeRepository groupIncomeRepository) {
        this.memberRepository = memberRepository;
        this.incomeRepository = incomeRepository;
        this.memberValidation = memberValidation;
        this.propertiesIncomeRepository = propertiesIncomeRepository;
        this.groupIncomeRepository = groupIncomeRepository;
    }

    @RequestMapping(value = "income", method = RequestMethod.GET)
    public String income(Model model) {
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

        List<GroupIncome> groupIncome = this.groupIncomeRepository.listAll();
        model.addAttribute("groupIncome", groupIncome);
        List<Income> incomes = this.incomeRepository.listAllMember(member.getId());
        model.addAttribute("incomes", incomes);

        return "income";
    }
    @RequestMapping(value = "deleteIncome/{id}", method = RequestMethod.GET)
    public String deleteIncome(@PathVariable Integer id) {
        this.incomeRepository.removeIncome(id);

        return "redirect:/income";
    }

    @RequestMapping(value = "addIncome", method = RequestMethod.GET)
    public ModelAndView addIncome(HttpServletRequest request, Model model) throws ParseException {
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

        ModelAndView modelAndView = new ModelAndView("redirect:/income");
        List<GroupIncome> groupIncome = this.groupIncomeRepository.listAll();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String idGroup = request.getParameter("group");
        Integer id = Integer.valueOf(idGroup);
        GroupIncome group = new GroupIncome();
        Income income = new Income();
        PropertiesIncome propertiesIncome = new PropertiesIncome();
        ListIterator<GroupIncome> it = groupIncome.listIterator();
        while(it.hasNext()){
            group = it.next();

            if(group.getId()== id){
                break;
            }

        }
        income.setIdMemberOfFamily(member);
        income.setNameIncome(request.getParameter("name"));
        income.setIdgroupIncome(group);
        propertiesIncome.setIdIncome(income);
        propertiesIncome.setSum(Float.valueOf(request.getParameter("sum")));
        propertiesIncome.setData( sdf.parse(request.getParameter("data")));

        this.incomeRepository.addContact(income);
        this.propertiesIncomeRepository.addContact(propertiesIncome);

        List<Income> incomes = this.incomeRepository.listAll();
        model.addAttribute("income", incomes);
        return modelAndView;
    }

    @RequestMapping(value = "addGroupIncome", method = RequestMethod.GET)
    public ModelAndView addGroupIncome(HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView("redirect:/income");

        GroupIncome group = new GroupIncome();
        group.setNameGroup(request.getParameter("nameGroup"));

        this.groupIncomeRepository.addContact(group);
        return modelAndView;
    }

    @RequestMapping(value = "editIncome/{id}", method = RequestMethod.GET)
    public String editIncome(@PathVariable Integer id, Model model){
        List<GroupIncome> groupIncome = this.groupIncomeRepository.listAll();
        model.addAttribute("groupIncome", groupIncome);
        Income income = this.incomeRepository.findIncome(id);
        model.addAttribute("income", income);
        PropertiesIncome propertiesIncome = this.propertiesIncomeRepository.findPropertiesIncome(income.getPropertiesIncomeCollection().iterator().next().getId());
        model.addAttribute("propertiesIncome", propertiesIncome);
        return "editIncome";
    }

    @RequestMapping(value = "/editIncome2", method = RequestMethod.GET)
    public String editCost(HttpServletRequest request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(request.getParameter("group"));
        String idGroup = request.getParameter("group");
        Integer id = Integer.valueOf(idGroup);
        Income income = this.incomeRepository.findIncome(Integer.valueOf(request.getParameter("id")));
        PropertiesIncome propertiesIncome = this.propertiesIncomeRepository.findPropertiesIncome(income.getPropertiesIncomeCollection().iterator().next().getId());
        GroupIncome group = this.groupIncomeRepository.findGroupIncomeId(id);
        income.setIdgroupIncome(group);
        income.setNameIncome(request.getParameter("name"));
        propertiesIncome.setIdIncome(income);
        propertiesIncome.setData(sdf.parse(request.getParameter("data")));
        propertiesIncome.setSum(Float.valueOf(request.getParameter("sum")));
        this.incomeRepository.updateIncome(income);
        this.propertiesIncomeRepository.updatePropertiesIncome(propertiesIncome);
        return "redirect:/income";
    }
}
