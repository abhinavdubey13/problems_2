package DP.classic;

/**
 *
 * https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
 *
 * given some number of floors and eggs ,
 *
 * find the attempts it would take IN THE WORST CASE to find the floor from which an egg will break
 *
 * note : if an egg breaks from floor number X , it would break form higher floors as well
 */



/**
 *
 * dp-array = 2D
 * array-filling = new concept
 *
 * consider F floors and E eggs
 * concept : if we throw an egg from K'th floor , it has 2 choices
 *
 * choice-1 :  it breaks (in this case we will have #floors left = K-1 , and #eggs to user = E-1)
 * choice-2 :  it does NOT breaks (in this case we will have #floors left = F-K , and #eggs to user = E)
 *
 * thus, we use the above , such that K runs from 1st floor till last floor
 *
 * =====================================================
 * answer-for-each-floor(k) = Math.min(set of all MAX)
 * =====================================================
 *
 * =========================
 * TC = O(eggs . floors  . floor)   = cubic
 * SC = O(eggs . floors)
 *
 */





public class p4_egg_dropping {
    public static void main(String[] args) {

        //expected=4
        int floors = 10;
        int eggs = 2;

        int answer = p4_egg_dropping_soln.find(floors, eggs);
        System.out.println(answer);

    }
}


class p4_egg_dropping_soln {

    static int find(int floors , int eggs){

        int[][]dp = new int[floors+1][eggs+1];

        //1st column : if eggs=0 , except for floor=0 , we cannot perform experiment , ie dp[i][0]=-1
        for(int i=1;i<=floors;i++){
            dp[i][0]=-1;
        }

        //1st row : if floor=0 , eggs required =0


        //2nd row onwards
        for(int curr_floor=1 ; curr_floor<=floors ; curr_floor++){
            for(int curr_eggs=1 ; curr_eggs<=eggs ; curr_eggs++){


                //if floor=1 , we only need 1 egg
                if(curr_floor==1){
                    dp[curr_floor][curr_eggs]=1;
                    continue;
                }

                //if we have 1 egg only , we need as many attempts as floors
                if(curr_eggs==1){
                    dp[curr_floor][curr_eggs] = curr_floor;
                    continue;
                }

                //for i>1 && j>1
                dp[curr_floor][curr_eggs] = Integer.MAX_VALUE;
                for(int flr=1 ; flr<=curr_floor ; flr++){
                    int if_egg_brks = dp[flr-1][curr_eggs-1];
                    int if_egg_not_brks = dp[curr_floor - flr][curr_eggs];
                    int attempts = 1 + Math.max(if_egg_brks , if_egg_not_brks);


                    //min of all max
                    //min of all worst cases
                    dp[curr_floor][curr_eggs] = Math.min(dp[curr_floor][curr_eggs] , attempts);

                }

            }
        }
        return dp[floors][eggs];
    }


}
