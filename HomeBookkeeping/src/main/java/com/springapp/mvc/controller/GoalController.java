package com.springapp.mvc.controller;

import com.springapp.mvc.domain.*;
import com.springapp.mvc.repository.CostRepository;
import com.springapp.mvc.repository.GoalRepository;
import com.springapp.mvc.repository.GroupCostRepository;
import com.springapp.mvc.repository.MemberOfFamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class GoalController {
    private GoalRepository goalRepository;
    private GroupCostRepository groupCostRepository;
    private MemberOfFamilyRepository memberRepository;

    @Autowired
    public GoalController(GoalRepository goalRepository, GroupCostRepository groupCostRepository, MemberOfFamilyRepository memberRepository) {
        this.goalRepository = goalRepository;
        this.groupCostRepository = groupCostRepository;
        this.memberRepository = memberRepository;
    }

    @RequestMapping(value = "goal", method = RequestMethod.GET)
    public String goal(Model model, HttpServletRequest request) {

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

        List<Goal> goals = this.goalRepository.listAllMember(member.getId());
        model.addAttribute("goals", goals);

        return "goal";
    }

    @RequestMapping(value = "addGoal", method = RequestMethod.GET)
    public ModelAndView addGoal(HttpServletRequest request, Model model) throws ParseException {
        ModelAndView modelAndView = new ModelAndView("redirect:/goal");

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

        Date today = new Date();
        model.addAttribute("start", today);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = sdf.parse(request.getParameter("start"));
        Goal goal = new Goal();
        Integer choise1 = 1;
        Integer choise2 = 2;
        Date finish = new Date();

        Integer sum = Integer.valueOf(request.getParameter("sum"));
        Integer sumN = Integer.valueOf(request.getParameter("ante"));
        Integer kol = sum/sumN;

        System.out.println(kol);
        if(choise1 == Integer.valueOf(request.getParameter("radio"))){

            Calendar c = Calendar.getInstance();
            c.setTime(start);
            c.add(Calendar.DATE, kol);
            finish = c.getTime();
        }
        else {
            if(choise2 == Integer.valueOf(request.getParameter("radio"))){

                Calendar c = Calendar.getInstance();
                c.setTime(start);
                c.add(Calendar.WEEK_OF_MONTH, kol);
                finish = c.getTime();
                System.out.println(finish);
            }
            else{

                Calendar c = Calendar.getInstance();
                c.setTime(start);
                c.add(Calendar.MONTH, kol);
                finish = c.getTime();

            }
        }

        goal.setIdMemberOfFamily(member);
        goal.setCollected(request.getParameter("collected"));
        goal.setSum(Float.valueOf(request.getParameter("sum")));
        goal.setAnte(Float.valueOf(request.getParameter("ante")));
        goal.setStart(start);
        goal.setFinish(finish);


        this.goalRepository.addContact(goal);

        List<Goal> goals = this.goalRepository.listAll();
        model.addAttribute("goals", goals);

        return modelAndView;
    }
}
