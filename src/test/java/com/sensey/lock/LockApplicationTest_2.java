package com.sensey.lock;

import com.sensey.lock.model.Developer;
import com.sensey.lock.repository.TaskRepository;
import com.sensey.lock.model.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class LockApplicationTest_2 {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void shouldObtainTask_2() {
        Task found_2 = entityManager.find(Task.class, 1, LockModeType.PESSIMISTIC_WRITE);
        found_2.description("Edited by test 02");

        System.out.println("Get test02");

        try {
            System.out.println(" Waiting...");
            Thread.sleep(12000);
        } catch (InterruptedException e) {}
    }


}
