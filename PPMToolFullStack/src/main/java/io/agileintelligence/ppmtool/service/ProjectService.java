package io.agileintelligence.ppmtool.service;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.exceptions.ProjectIdException;
import io.agileintelligence.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdate(Project project) {
      try {
        project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
        return projectRepository.save(project);
      } catch (Exception ex) {
        throw new ProjectIdException("Project ID '" + project.getProjectIdentifier().toUpperCase() + "' already exists ");
      }
    }

    public Project findByProjectIdentifier(String projectId) {
      Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
      if (project == null)
        throw new ProjectIdException("Project ID '" + projectId + "' does not exists ");
      return project;
    }

    public Iterable<Project> findAllProjects() {
      return projectRepository.findAll();
    }

    public void deleteByProjectId(String projectId) {
      Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
      if (project == null)
        throw new ProjectIdException("Can not delete with ID '" + projectId + "', This project does not exists ");

      projectRepository.delete(project);
    }
}
