package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    //EASY
    @Test
    public void q1test() {                    //Input                  //Expected Output
        assertThat(Question1.FindLargestNumber(new int[]{5, 8, 11, 2}), is(11));
    }
    //EASY
    @Test
    public void qtest2() {
        System.out.println(" Question 2: 2nd month = February");
        assertEquals("February", Question2.monthN(2));
    }
    //MEDIUM
        @Test
        public void qtest3() {
            assertEquals(true, Question3.IsIso("Pie"));
            System.out.printf(" Question 3: True" + " \n Question 4: Reversed Number = ");

        }
    //MEDIUM
    @Test
    public void qtest4() {
        assertThat(Question4.ReversedNum(-87), is(0));


    }
    //HARD
    @Test
    public void qtest5() {
        assertThat(Question5.join(new String[]{"Cat", "Fish"}), is(new String[]{"CatFish", "0"}));
    }


    }






