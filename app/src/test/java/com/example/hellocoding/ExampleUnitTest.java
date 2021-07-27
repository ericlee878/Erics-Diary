package com.example.hellocoding;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        String input = "abbc";

        String actual = removeTargetLetter(input, 'b');

        assertEquals("ac", actual);
    }

    private String removeTargetLetter(String input, char targetLetter) {
        int targetLocation; // 1
        String finalOutput;
        for(i=0; i<input.length()-1;i++)
        {
            if(input.charat(i)==targetLetter)
            {
                input = input.remove(i);
                i--;
//                targetLocation = i;
            }
        }
        for(i=0;i<input.length()-1;i++)
        {
            if(i!=targetLocation)
            {
                finalOutput+=input.substring(i,i+1)
            }
        }
        return finalOutput;
    }
}