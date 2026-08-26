class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
       /*
       Steps to Solve
Take the first two points from the array.
Find the change in x between these two points.
Find the change in y between these two points.
Now take each remaining point one by one.
Compare its position with the first point using the same change in x and y.
If any point does not follow the same ratio/slope, the points are not on the same straight line.
If all points follow the same pattern, return true.
*/

int x = coordinates[1][0]- coordinates[0][0];
int y = coordinates[1][1] - coordinates[0][1];

for(int i=1;i<coordinates.length;i++){
int dx = coordinates[i][0]- coordinates[i-1][0];
int dy = coordinates[i][1] - coordinates[i-1][1];

if(dx * y != dy*x){
    return false;
}


}
return true;

    }
}