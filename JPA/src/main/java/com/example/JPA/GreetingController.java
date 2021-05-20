package com.example.JPA;

import com.example.JPA.domain.Application;
import com.example.JPA.domain.Developers;
import com.example.JPA.repos.AppRepo;
import com.example.JPA.repos.DeveloperRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class GreetingController {
    @Autowired
    private DeveloperRepo developerRepo;
    @Autowired
    private AppRepo appRepo;


    @GetMapping("simpleExample")
    public String simpleExample(Model model) {
            for (long i = 0; i < 10000; i++) {
                developerRepo.save(new Developers("Proselyte", "Java", i));
            }
            Iterable<Developers> developer = developerRepo.findAll();

            for (long i = 1; i < 10001; i++) {
                developerRepo.deleteById(i);
            }
        return "main";
    }

    @GetMapping("middleExample")
    public String middleExample() {
        Date start = new Date();
        for (long i = 0; i < 10000; i++) {
            developerRepo.save(new Developers("Proselyte", "Java", i));
        }

        Date start2 = new Date();
        Iterable<Developers> developer = developerRepo.findBySalaryLessThan(5000);
        Date end2 = new Date();

        Date start1 = new Date();
        developerRepo.deleteAllBySalaryGreaterThan(5000);
        Date end1 = new Date();

        Long a = developer.spliterator().getExactSizeIfKnown();

        Date end = new Date();
        System.out.println("all time:" + (end.getTime()-start.getTime()) + "s");
        System.out.println("select:" + (end2.getTime()-start2.getTime()) + "s");
        System.out.println("delete:" + (end1.getTime()-start1.getTime()) + "s");
        System.out.println("size:" + a);
        return "main";
    }

    @GetMapping("middleExampleWithSort")
    public String middleExampleWithSort() {
        Date start = new Date();
        for (long i = 0; i < 10000; i++) {
            developerRepo.save(new Developers("Proselyte", "Java", i));
        }

        Date start2 = new Date();
        Iterable<Developers> developer = developerRepo.findBySalaryLessThanOrderBySalaryDesc(5000);
        Date end2 = new Date();

        Date start1 = new Date();
        developerRepo.deleteAllBySalaryGreaterThan(5000);
        Date end1 = new Date();

        Long a = developer.spliterator().getExactSizeIfKnown();

        Date end = new Date();
        System.out.println("all time:" + (end.getTime()-start.getTime()) + "s");
        System.out.println("select:" + (end2.getTime()-start2.getTime()) + "s");
        System.out.println("delete:" + (end1.getTime()-start1.getTime()) + "s");
        System.out.println("size:" + a);
        return "main";
    }

    @GetMapping("preparingSpace")
    public String preparingSpace() {
        for (long i = 0; i < 10000; i++) {
            Application app = new Application("App"+i, "Russian");
            appRepo.save(app);
        }

        Developers developer = developerRepo.findFirstBySalary(4000);
        for (int i = 0; i < 1000; i++) {
            long random = Math.round(10000*Math.random());
            Application app = appRepo.findById(random).get();
            app.setDevelopers(developer);
            appRepo.save(app);
        }
        for (long i = 0; i < 10000; i++) {
            developerRepo.save(new Developers("Proselyte", "Java", i));
        }
        return "main";
    }
}
