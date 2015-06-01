package com.springapp.mvc.controller;


import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.List;

@Controller
public class GroupController {
    private Statistics statictics;
    private GroupCostRepository groupCostRepository;
    private CostRepository costRepository;
    private PropertiesCostRepository propertiesCostRepository;
    private GroupIncomeRepository groupIncomeRepository;
    private IncomeRepository incomeRepository;
    private PropertiesIncomeRepository propertiesIncomeRepository;
    private MemberOfFamilyRepository memberRepository;

    @Autowired
    public GroupController(Statistics statictics, GroupCostRepository groupCostRepository, PropertiesCostRepository propertiesCostRepository, CostRepository costRepository, GroupIncomeRepository groupIncomeRepository, PropertiesIncomeRepository propertiesIncomeRepository, IncomeRepository incomeRepository, MemberOfFamilyRepository memberRepository) {
        this.groupCostRepository = groupCostRepository;
        this.costRepository = costRepository;
        this.statictics= statictics;
        this.propertiesCostRepository = propertiesCostRepository;
        this.groupIncomeRepository = groupIncomeRepository;
        this.incomeRepository = incomeRepository;
        this.propertiesIncomeRepository = propertiesIncomeRepository;
        this.memberRepository = memberRepository;
    }

    @RequestMapping(value = "statistics", method = RequestMethod.GET)
    public String statistics(Model model) {
        List<PropertiesCost> propertiesCosts = this.propertiesCostRepository.listAll();
        model.addAttribute("propertiesCosts", propertiesCosts);
        List<Integer> mas = new ArrayList<Integer>();
        int i = 0;
        Calendar calendar = Calendar.getInstance();
        List<PropertiesCost> prop = this.propertiesCostRepository.listAll();
        Iterator<PropertiesCost> iter = prop.iterator();
        while (iter.hasNext()) {
            PropertiesCost el = iter.next();
            calendar.setTime(el.getData());
            if (!mas.contains(calendar.get(Calendar.YEAR))) {
                mas.add(calendar.get(Calendar.YEAR));
            }
        }
        Collections.shuffle(mas);
        System.out.println(mas);
        List<Integer> nmas = mas;

        model.addAttribute("nmas", mas);

        return "statistics";
    }

    @RequestMapping(value = "year", method = RequestMethod.POST)
    public String year(HttpServletRequest request, Model model) {
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

        String year = request.getParameter("el");

        Integer nyear = Integer.valueOf(year);
        List<Statistics> statisticsList = new ArrayList<Statistics>();
          //  List<PropertiesCost> propertiesCosts = new ArrayList<PropertiesCost>(this.propertiesCostRepository.getPropertiesData(nmonth, nyear));
            List<Cost> costs = this.costRepository.listAllMember(member.getId());
            List<GroupCost> groupCosts = this.groupCostRepository.listAll();
            ListIterator<GroupCost> it = groupCosts.listIterator();
            ListIterator<GroupCost> newIt = groupCosts.listIterator();

            while (it.hasNext() && newIt.hasNext()) {
                GroupCost group = it.next();
                Statistics element = new Statistics();


                for(int i=0; i<12; i++) {
                    List<PropertiesCost> propertiesCosts = new ArrayList<PropertiesCost>(this.propertiesCostRepository.getPropertiesData(i, nyear));
                    int sum = 0;
                    ListIterator<Cost> itr = costs.listIterator();
                    while (itr.hasNext()) {
                        Cost cost = itr.next();
                        if (cost.getIdgroupCost().getId() == group.getId()) {
                            ListIterator<PropertiesCost> iter = propertiesCosts.listIterator();
                            while (iter.hasNext()) {
                                PropertiesCost propertiesCost = iter.next();
                                if (propertiesCost.getIdCost().getId() == cost.getId()) {
                                    sum += propertiesCost.getSum();
                                }
                            }
                        }
                    }

                System.out.println(sum);
               // newIt.next().setSum(sum);
                element.setNameCategory(group.getNameGroup());
                element.setSum(i, sum);
                }
                statisticsList.add(element);
            }


       System.out.println(statisticsList);


        List<Statistics> statisticsListIncome = new ArrayList<Statistics>();

        List<Income> incomes = this.incomeRepository.listAllMember(member.getId());
        List<GroupIncome> groupIncomes = this.groupIncomeRepository.listAll();
        ListIterator<GroupIncome> itIncome = groupIncomes.listIterator();
        ListIterator<GroupIncome> newItIncome = groupIncomes.listIterator();

        while (itIncome.hasNext() && newItIncome.hasNext()) {
            GroupIncome group = itIncome.next();
            Statistics element = new Statistics();
            for(int i=0; i<13; i++) {
                List<PropertiesIncome> propertiesIncomes = new ArrayList<PropertiesIncome>(this.propertiesIncomeRepository.getPropertiesData(i, nyear));
                int sum = 0;
                ListIterator<Income> itr = incomes.listIterator();
                while (itr.hasNext()) {
                    Income income = itr.next();
                    if (income.getIdgroupIncome().getId() == group.getId()) {
                        ListIterator<PropertiesIncome> iter = propertiesIncomes.listIterator();
                        while (iter.hasNext()) {
                            PropertiesIncome propertiesIncome = iter.next();
                            if (propertiesIncome.getIdIncome().getId() == income.getId()) {
                                sum += propertiesIncome.getSum();
                            }
                        }
                    }
                }

                System.out.println(sum);
                // newIt.next().setSum(sum);
                element.setNameCategory(group.getNameGroup());
                element.setSum(i, sum);
            }
            statisticsListIncome.add(element);
        }


        System.out.println(statisticsList);
        model.addAttribute("statisticsList", statisticsList);
        model.addAttribute("statisticsListIncome", statisticsListIncome);

       return "statistic2";
    }
}
