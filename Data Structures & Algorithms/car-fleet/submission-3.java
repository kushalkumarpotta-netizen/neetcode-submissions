class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];

        int fleet = 0;
        double prevTime = -1;

        //insert into cars position,time
        for(int i = 0;i < n;i++)
        {
            double time = (double)(target - position[i])/speed[i];
            cars[i][0] = position[i];
            cars[i][1] = time;
        }
        
        //sort the array in descending order closest to farthest
        Arrays.sort(cars, (a,b) -> Double.compare(b[0],a[0]));

        //for loop for comparing times of prev time and curr time
        for(int i = 0;i<n;i++)
        {
            double currTime = cars[i][1];
            if(currTime > prevTime)
            {
                fleet++;
                prevTime = currTime;
            }
        }

        //return the result fleet;
        return fleet;
    }
}


// 1 2 3 4 5 6 7 8 9 10
// .     ,
//       .   ,
//             .  ,
//                    .,

                   