package src.main.java;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int howMuchWeNeed = 0; // from gas station 0 to i
        int i = 0;
        int extra;
        // find where we should start
        for (i = 0; i < gas.length; i++) {
            extra = gas[i] - cost[i];
            // find the first station that gas amount is more or equal to the cost
            if (extra >= 0) {
                break;
            } else {
                // calculate how much gas we need from 0 to previous station i-1.
                howMuchWeNeed += -extra;
            }
        }
        //start from here.
        int start = i;
        int howMuchInTank = 0; // how much gas left in tank
        for (; i < gas.length; i++) {
            howMuchInTank += gas[i] - cost[i];
            // if gas is not enough to contniue, we need to start at the next station after i.
            if (howMuchInTank < 0) {
                start = i + 1;
                howMuchInTank = 0; // reset the amount of gas in the tank
            }
        }
        // pretty much deficit of gas on every gas station or gas left in tank is not enough to travel
        if (start == gas.length || howMuchInTank < howMuchWeNeed) {
            return -1;
        }
        return start;
    }
}
