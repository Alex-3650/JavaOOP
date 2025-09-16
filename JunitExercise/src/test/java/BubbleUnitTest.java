import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleUnitTest {


    @Test
    public void test_whenProvideUnorderedArrayOfNumbers_ThenOrderTheArray(){


        int[]unorderedArray=new int[]{9,8,7,6,5,4,3,2,1};
        Bubble.sort(unorderedArray);

        int[]orderedArray=new int[]{1,2,3,4,5,6,7,8,9};

        Assertions.assertArrayEquals(orderedArray,unorderedArray);
    }

}
