package com.jobintech.elearningjobintech;

import com.jobintech.elearningjobintech.entities.*;
import com.jobintech.elearningjobintech.repositories.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
public class ELearningJobInTechApplication {

    public static void main(String[] args) {

        SpringApplication.run(ELearningJobInTechApplication.class, args);

    }

    @Bean
    CommandLineRunner commandLineRunner(IParcourRep parcourRep, IUserRepo userRepo, IStepsRep stepsRep,
    ILearningRep learningRep, IDoingRep doingRep) {
        return args -> {
            List<Parcour> parcours = new ArrayList<>();
            parcours.add( Parcour.builder().title("parcour1").description("description1").build());
            parcours.add( Parcour.builder().title("parcour2").description("description2").build());

            parcourRep.saveAll(parcours);
            List<Users> users = new ArrayList<>();
            String username = "user1";


            Users user = new Users("user1","password1","email1","role1",parcours);

            users.add(user);

//            user.addParcour(new Parcour("parcour3", "description3"));
//            user.addParcour(new Parcour("parcour4", "description4"));
//            user.addParcour(new Parcour("parcour5", "description4"));
            userRepo.saveAll(users);



//            parcours.forEach(element->{
//               element.setUsers(users);
//               parcourRep.save(element);
//            });

            List<Steps> steps = new ArrayList<>();
            steps.add(Steps.builder().title("step1").status("pending").description("description1").parcour(parcours.get(0)).build());
            steps.add(Steps.builder().title("step2").status("done").description("description2").parcour(parcours.get(0)).build());
            stepsRep.saveAll(steps);

            List<Learning> learnings = new ArrayList<>();
            learnings.add(Learning.builder().title("learning1").steps(steps.get(0)).build());
            learnings.add(Learning.builder().title("learning2").steps(steps.get(0)).build());
            learningRep.saveAll(learnings);

            List<Doing> doings = new ArrayList<>();
            doings.add(Doing.builder().title("doing1").status("prnding").description("des").steps(steps.get(0)).build());
            doings.add(Doing.builder().title("doing2").status("done").description("des").steps(steps.get(0)).build());
            doingRep.saveAll(doings);















            };
    }

}
