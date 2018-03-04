package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao repController;

    @Test
    public void testFindByListName() {
        //Given
        TaskList taskListToDo = new TaskList("To do tasks", "List with tasks to be carried out");
        TaskList taskListInProgress = new TaskList("In progress", "List with tasks in progress");
        TaskList taskListDone = new TaskList("Done", "List with completed tasks");
        repController.save(taskListToDo);
        repController.save(taskListInProgress);
        repController.save(taskListDone);
        //When
        String toDoList = taskListToDo.getListName();
        String inProgressList = taskListInProgress.getListName();
        String doneList = taskListDone.getListName();
        //Then
        Assert.assertEquals(toDoList, repController.findByListName(toDoList).get(0).getListName());
        Assert.assertEquals(inProgressList, repController.findByListName(inProgressList).get(0).getListName());
        Assert.assertEquals(doneList, repController.findByListName(doneList).get(0).getListName());
        //CleanUp
        repController.deleteAll();
    }
    @Test
    public void testTaskListDaoSaveWithTasks() {
        //Given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);
        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        TaskList taskListToDo = new TaskList("To do tasks", "List with tasks to be carried out");
        taskListToDo.getTasks().add(task1);
        taskListToDo.getTasks().add(task2);
        task1.setTaskList(taskListToDo);
        task2.setTaskList(taskListToDo);
        //When
        repController.save(taskListToDo);
        int id =taskListToDo.getId();
        //Then
        Assert.assertNotEquals(0, id);
        //CleanUp
        repController.delete(id);
    }
}
