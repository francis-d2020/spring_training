package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {
        // Given        --      Preparation of the test
        //when this method run return new project entity
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());   // Stubbing
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        //the method we are testing
        // When         --      Execution of the real method
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());

        // Then         --      Verification and assertion
        InOrder inOrder = inOrder(projectRepository, projectMapper); // I want to check the order of these 2 Mocks

        inOrder.verify(projectRepository).findByProjectCode(anyString()); // We are providing in which order these 2 Mocks should be
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);

    }


    @Test
    void getByProjectCode_ExceptionTest() {
        //when we get empty string, throw an exception
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        //running the method and checking if it throws the expected exception
        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));

        //verify the method with empty string is running
        verify(projectRepository).findByProjectCode("");

        //verify the method with any project is never running
        verify(projectMapper, never()).convertToDto(any(Project.class));

        //assertion for the exception message
        assertEquals("Project Not Found", throwable.getMessage());





    }


}
