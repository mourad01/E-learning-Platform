package com.jobintech.elearningjobintech;

import com.jobintech.elearningjobintech.entities.Parcour;
import com.jobintech.elearningjobintech.entities.Users;
import com.jobintech.elearningjobintech.repositories.IParcourRep;
import com.jobintech.elearningjobintech.repositories.IUserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ELearningJobInTechApplication {

    public static void main(String[] args) {

        SpringApplication.run(ELearningJobInTechApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(IParcourRep parcourRep, IUserRepo userRepo){
        return args -> {
            List<Parcour> parcours = new ArrayList<>();
            parcours.add( Parcour.builder().title("parcour1").description("description1").build());
            parcours.add( Parcour.builder().title("parcour2").description("description2").build());
            List<Parcour> parcours1 = new ArrayList<>();
            parcours1.add( Parcour.builder().title("parcour3").description("description3").build());
            parcours1.add( Parcour.builder().title("parcour4").description("description4").build());
            List<Users> users = new ArrayList<>();

            Users user = new Users("user1","password1","email1","role1");
            Users user2 = new Users("user2","password2","email2","role2");
            users.add(user);
            users.add(user2);
//            user.addParcour(new Parcour("parcour3", "description3"));
//            user.addParcour(new Parcour("parcour4", "description4"));
//            user.addParcour(new Parcour("parcour5", "description4"));
            userRepo.saveAll(users);

            parcours.forEach(element->{
               element.setUser(user);
               parcourRep.save(element);
            });
            parcours1.forEach(element->{
                element.setUser(user2);
                parcourRep.save(element);
            });













            };
    }

}
