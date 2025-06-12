
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;

public class MeetingsRoomsIII {
    
    public static int mostBooked(int n, int[][] meetings) {
        
        int[] schedule = new int[n];
        int[] countMeetings = new int[n];

        Arrays.sort(meetings, Comparator.comparing(m -> m[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];
            boolean booked = false;

            int closest = Integer.MAX_VALUE;
            int proxRoom = 0;

            for (int j = 0; j < n; j++) {
                if(schedule[j] < start){
                    schedule[j] = end;
                    countMeetings[j]++;
                    booked = true;
                    break;
                }

                System.out.println(closest + " > " + schedule[j]);
                if(closest > schedule[j]){
                    closest = schedule[j];
                    proxRoom = j;
                }
            }

            if(!booked) {
                int duration = end - start;
                schedule[proxRoom] += duration;
                countMeetings[proxRoom]++;
            }
        }

        int maxMeet = 0;
        int room = 0;
        for(int i=0; i<n; i++){
            if(maxMeet < countMeetings[i]) {
                maxMeet = countMeetings[i];
                room = i;
            }
        }

        return room;
    }

    public static void main(String[] args) {
        // int[][] meetings = {{4,10},{1,5},{2,7},{3,4}}; // res 0 1,5 2,7 3,4 4,10 -> 5 7 -> 3
        int[][] meetings = {{1,20},{2,10},{3,5},{4,9},{6,8}}; // res 1

        // int res = mostBooked(2, meetings);
        int res = mostBooked(3, meetings);

        System.out.println(res);

        System.out.println(res == 1);
    }
}

/**
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

    Each meeting will take place in the unused room with the lowest number.
    If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
    When a room becomes unused, meetings that have an earlier original start time should be given the room.

Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.

 

Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0. 

Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1. 

 

Constraints:

    1 <= n <= 100
    1 <= meetings.length <= 105
    meetings[i].length == 2
    0 <= starti < endi <= 5 * 105
    All the values of starti are unique.


 */

 /*
  Algorithm

    Initialize two arrays, room_availability_time and meeting_count, both of size n, to keep track of the availability time for each room and the count of meetings held in each room, respectively.
    Iterate through each meeting in the sorted order based on their start times.
    For each meeting, find the earliest available room by iterating through the room_availability_time array. If a room is available (its availability time is less than or equal to the current meeting's start time), allocate the meeting to that room, update the meeting count for that room, and set the room's availability time to the meeting's end time. Break out of the loop.
    If no available room is found (i.e., found_unused_room is False), find the room with the earliest availability time (min_room_availability_time). Update the availability time for that room to accommodate the delayed meeting, and increment the meeting count for that room.
    After processing all meetings, return the index of the room with the maximum meeting count using. If there are multiple rooms with the same maximum meeting count, return the room with the lowest index.

  */
