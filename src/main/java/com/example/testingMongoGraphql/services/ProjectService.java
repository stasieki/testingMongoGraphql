package com.example.testingMongoGraphql.services;


import com.example.testingMongoGraphql.models.Project;
import org.bson.types.ObjectId;

import java.util.List;

public interface ProjectService {

    List<Project> findByIdInProject(List<String> projectsListIds);

    List<Project> findAllProjects();
}
