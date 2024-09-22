package leetcode.blind75.stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public static void main(String[] args) {
        int[] arr = {10,2,-5};

        System.out.println(Arrays.toString(asteroidCollision2(arr)));
    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> astroidStack = new Stack<>();

        for (int num : asteroids){
            if (astroidStack.isEmpty()){
                astroidStack.push(num);
            }else{
                //Compare the number to what is on the stack if they will collide and handle collision
                if((num * astroidStack.peek()) >0){
                    //They have the same sign so add to stack
                    astroidStack.push(num);
                }else{
                    //If they are equal destroy both of them
                    if(Math.abs(num)==Math.abs(astroidStack.peek())){
                        astroidStack.pop();
                    }else{
                        int min = Math.min(Math.abs(num), Math.abs(astroidStack.peek()));
                        if (Math.abs(astroidStack.peek())==min){
                            astroidStack.pop();
                        }
                    }
                }
            }
        }

        int[] arr = new int[astroidStack.size()];

        for (int i=0; i< astroidStack.size(); i++){
            arr[i] = astroidStack.get(i);
        }

        return arr;

    }


    public static int[] asteroidCollision2(int[] asteroids) {

        Stack<Integer> asteroidStack = new Stack<>();


        for (int num: asteroids){
            boolean isDestroyed = false;

            while (!asteroidStack.isEmpty() && num <0 && asteroidStack.peek()>0){
                if (Math.abs(num) > Math.abs(asteroidStack.peek())){

                    asteroidStack.pop();
                    isDestroyed = false;

                }else if (Math.abs(num) < Math.abs(asteroidStack.peek())){
                    isDestroyed = true;
                    break;

                }else{
                    //Equal
                    asteroidStack.pop();
                    isDestroyed = true;
                    break;
                }
            }


            if (!isDestroyed){
                asteroidStack.push(num);
            }
        }

        int[] arr = new int[asteroidStack.size()];
        for (int i=0; i< asteroidStack.size(); i++){
            arr[i] = asteroidStack.get(i);
        }

        return arr;

    }
}
