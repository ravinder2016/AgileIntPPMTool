package io.agileintelligence.ppmtool.exceptions;

public class ProjectIdExceptionResponse {
  private String projectIdentifier;

  public ProjectIdExceptionResponse(final String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

  public String getProjectIdentifier() {
    return projectIdentifier;
  }

  public void setProjectIdentifier(final String projectIdentifier) {
    this.projectIdentifier = projectIdentifier;
  }

}