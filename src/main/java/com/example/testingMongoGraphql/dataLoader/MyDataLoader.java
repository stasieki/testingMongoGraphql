package com.example.testingMongoGraphql.dataLoader;

import com.example.testingMongoGraphql.models.User;
import com.example.testingMongoGraphql.repositories.ProjectRepository;
import com.example.testingMongoGraphql.repositories.TaskRepository;
import com.example.testingMongoGraphql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
public class MyDataLoader {
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    @Autowired
    MyDataLoader(UserRepository userRepository, TaskRepository taskRepository, ProjectRepository projectRepository){
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.projectRepository=projectRepository;
    }
    @PostConstruct
    private void generateData(){
//        User user = User.builder().name("Igor".age(24).articlesIds(new ArrayList<>()).articlesIds(new ArrayList<>()).build(); //.name("Igor") ).createdAt(new Date())
        User user = User.builder().name("Ania").birthDate("10.10.2010").surname("Nowakowicz").eMail("kowlaski@gmail.com").build();
        userRepository.save(user);
        List<User> users = (List<User>) userRepository.findAll();
//        System.out.println("useres: " + users);
        System.out.println("useres: " + user);

//        List<User> users = new ArrayList<>();
//        users.add(User.builder().name("Igor").createdAt(new Date()).age(24).articlesIds(new ArrayList<>()).articlesIds(new ArrayList<>()).build());
//        users.add(User.builder().name("Ellen").createdAt(new Date()).age(24).articlesIds(new ArrayList<>()).articlesIds(new ArrayList<>()).build());
//        users.add(User.builder().name("John").createdAt(new Date()).age(53).articlesIds(new ArrayList<>()).articlesIds(new ArrayList<>()).build());
//        users.add(User.builder().name("Nazar").createdAt(new Date()).age(14).articlesIds(new ArrayList<>()).articlesIds(new ArrayList<>()).build());
//        users = (ArrayList) userRepository.save(users);
//        List<Article> articles = new ArrayList<>();
//        articles.add(Article.builder().title("Java 8 Lambdas").minutesRead(8).authorId(users.get(0).getId().toString()).build());
//        articles.add(Article.builder().title("GraphQL Getting Started").minutesRead(10).authorId(users.get(1).getId().toString()).build());
//        articles.add(Article.builder().title("Spring Boot + WebSockets").minutesRead(6).authorId(users.get(3).getId().toString()).build());
//        articles = (ArrayList) articleRepository.save(articles);
//        User me = users.get(0);
//        users.get(0).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));
//        users.get(0).setArticlesIds(Arrays.asList(articles.get(1).getId().toHexString()));
//        users.get(1).setArticlesIds(Arrays.asList(articles.get(2).getId().toHexString()));
//        users.get(3).setArticlesIds(Arrays.asList(articles.get(0).getId().toHexString()));
//        userRepository.save(users);
//        List<String> myFriendsIds = new ArrayList<>();
//        for (int i = 1; i<users.size(); i++){
//            myFriendsIds.add(users.get(i).getId().toHexString());
//        }
//        me.setFriendsIds(myFriendsIds);
//        userRepository.save(me);
    }
}
