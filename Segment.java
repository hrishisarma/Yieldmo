package logmein;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Hrishikesh
 */
public class Segment {

    int StartTime;
    int EndTime;

    public Segment(int StartTime, int EndTime) {
        this.StartTime = StartTime;
        this.EndTime = EndTime;
    }

    public int getStartTime() {
        return StartTime;
    }

    public void setStartTime(int StartTime) {
        this.StartTime = StartTime;
    }

    public int getEndTime() {
        return EndTime;
    }

    public void setEndTime(int EndTime) {
        this.EndTime = EndTime;
    }

    public static Comparator<Segment> StartTimeComparator = new Comparator<Segment>() {

        public int compare(Segment s1, Segment s2) {

            int StartTime1 = s1.getStartTime();
            int StartTime2 = s2.getStartTime();

            return StartTime1 - StartTime2;
        }
    };

    @Override
    public String toString() {
        return "StartTime=" + StartTime + ", EndTime=" + EndTime;
    }

    private static ArrayList<Segment> getnewSegmentList(ArrayList<Segment> seg) {

        ArrayList<Segment> seg2 = new ArrayList<Segment>();
        int i = 0;
        while (i < seg.size()) {
            boolean flag = false;
            if (i == seg.size() - 1) {
                Segment s1 = new Segment(seg.get(i).getStartTime(), seg.get(i).getEndTime());
                seg2.add(s1);
                i++;
                break;
            } else {

                int j = i + 1;
                int k = i;

                while (flag != true && j < seg.size()) {
                    Segment s2 = seg.get(j);
                    Segment s = seg.get(k);
                    if ((s2.getStartTime() - s.getEndTime()) < 5) {
                        j++;
                        k++;
                    } else {
                        Segment s1 = new Segment(seg.get(i).getStartTime(), seg.get(k).getEndTime());
                        seg2.add(s1);
                        i = j;
                        j = j + 1;

                        flag = true;
                    }
                }
            }
        }

        return seg2;
    }

    public static void main(String args[]) {
        Segment s1 = new Segment(29, 33);
        Segment s2 = new Segment(10, 12);
        Segment s3 = new Segment(18, 20);
        Segment s4 = new Segment(1, 8);
        Segment s5 = new Segment(5, 7);
        Segment s6 = new Segment(24, 27);
        Segment s7 = new Segment(39, 43);

        ArrayList<Segment> seg = new ArrayList<>();
        seg.add(s1);
        seg.add(s2);
        seg.add(s3);
        seg.add(s4);
        seg.add(s5);
        seg.add(s6);
        seg.add(s7);
        Collections.sort(seg, Segment.StartTimeComparator);
//        for (Segment str : seg) {
//            System.out.println(str);
//        }

        ArrayList<Segment> seg2 = getnewSegmentList(seg);
        for(int i=0;i<seg2.size();i++){
            System.out.println("Object "+i+ " : " + " StartTime: "+seg2.get(i).getStartTime()+"  " + " EndTime: "+seg2.get(i).getEndTime());
        }
    }
}
