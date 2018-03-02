package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        System.out.println(toDoList);
        System.out.println(inProgressList);
        System.out.println(doneList);
        //Then
        Assert.assertEquals(toDoList, repController.findByListName(toDoList).get(0).getListName());
        Assert.assertEquals(inProgressList, repController.findByListName(inProgressList).get(0).getListName());
        Assert.assertEquals(doneList, repController.findByListName(doneList).get(0).getListName());
        //ClearUp
        repController.deleteAll();
    }
}
