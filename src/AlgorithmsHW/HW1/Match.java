package AlgorithmsHW.HW1;

/** This program implements stable matching algorithm and will find out the number of elements from the first set (table of order of
 * preference for men) that have only one valid partner

 * @author Shardul Dabholkar and Joe Tom Job
 */
import java.util.Scanner;

/*This class is used to store data related to a man or woman. mapped will tell whethrer the person is mapped.
    preference will tell the current preference of the person given by his partner. counter will keep the count to
    check whether the person requested every partner*/
class personPref {
    int id;
    int partnerId;
    int preference;
    int mapped;
    int counter;

    /*intially set the preference and mapped to -1 and counter to 0. */
    public personPref() {
        mapped = -1;
        preference = -1;
        counter = 0;
    }
}

/* This class implements the main function that calculates sum of all even numbers among the input*/
public class Match {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        //take the input n - the number of elements in each group
        Integer n = in.nextInt();
        in.nextLine();

        //initialize m and w arrays to take the input of preference
        String[] m = new String[n];
        String[] w = new String[n];

        //take the n lines of inputs. This will be the preference list of first group
        for (int i = 0; i < n; i++) {
            m[i] = in.nextLine();
        }

        //take the n lines of inputs. This will be the preference list of seconda group
        for (int i = 0; i < n; i++) {
            w[i] = in.nextLine();
        }

        //intialize 2-D arrays to save the preference list in 2D array
        String[][] mn = new String[n][n];
        String[][] wn = new String[n][n];

        //store the preferences in 2D array
        for (int i = 0; i < n; i++) {
            mn[i] = m[i].split(" ");
            wn[i] = w[i].split(" ");
        }

        //initialize 2D integer array to store preferences
        int[][] men = new int[n][n];
        int[][] women = new int[n][n];

        //Move values of preferences in String array to integer array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                men[i][j] = Integer.parseInt(mn[i][j]);
                women[i][j] = Integer.parseInt(wn[i][j]);
            }
        }

        //initialize 2D arrays to store the inverse relation of preferences
        int[][] inverseMen = new int[n][n];
        int[][] inverseWomen = new int[n][n];

        //Store the inverse relation of Men
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseMen[i][men[i][j]] = j;
            }
        }

        //Store the inverse relation of Women
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseWomen[i][women[i][j]] = j;
            }
        }

        //Create array of objects of personPref to store the data related to each row
        personPref[] manp = new personPref[n];
        personPref[] womanp = new personPref[n];

        personPref[] manpWo = new personPref[n];
        personPref[] womanpWo = new personPref[n];

        //intialize the object
        for (int i = 0; i < n; i++) {
            manp[i] = new personPref();
            womanp[i] = new personPref();

            manpWo[i] = new personPref();
            womanpWo[i] = new personPref();
        }

        int mc = 0, wc = 0;

        //The below algorithm works in O(n^2) time. If we divide the group into men and women. The below code is Man Optimal Solution.
        while (mc<n) {      //stop once it reach n
            for (int i = 0; i < n; i++) { //run n times
                if (manp[i].mapped == -1) {  // if a man is not mapped he will be mapped
                    if(womanp[men[i][manp[i].counter]].preference ==-1) { //if the woman has not partner yet, she will be matched to this man
                        manp[i].id = i;
                        manp[i].partnerId = men[i][manp[i].counter];
                        manp[i].mapped = 0;
                        manp[i].preference = inverseWomen[men[i][manp[i].counter]][i];

                        womanp[men[i][manp[i].counter]].mapped = 0;
                        womanp[men[i][manp[i].counter]].partnerId = i;
                        womanp[men[i][manp[i].counter]].preference = inverseWomen[men[i][manp[i].counter]][i];

                        mc++;
                    }
                    else if ((womanp[men[i][manp[i].counter]].preference !=-1)&&(womanp[men[i][manp[i].counter]].preference >  inverseWomen[men[i][manp[i].counter]][i])){
                        //if the woman prefer this man than the already paired man, then she will pair up with this man
                        manp[i].id = i;
                        manp[i].partnerId = men[i][manp[i].counter];
                        manp[i].mapped = 0;
                        manp[i].preference = inverseWomen[men[i][manp[i].counter]][i];

                        manp[womanp[men[i][manp[i].counter]].partnerId].mapped = -1; // Since the woman releases a man,
                        // that man will be released from the current woman to which he is mapped

                        womanp[men[i][manp[i].counter]].mapped = 0;
                        womanp[men[i][manp[i].counter]].partnerId = i;
                        womanp[men[i][manp[i].counter]].preference = inverseWomen[men[i][manp[i].counter]][i];
                    }
                    manp[i].counter++;
                }
            }
        }

        //The below algorithm works in O(n^2) time. If we divide the group into men and women. The below code is Man Optimal Solution.
        while (wc<n) {//stop once it reach n
            for (int i = 0; i < n; i++) {//run n times
                if (womanpWo[i].mapped == -1) {// if a man is not mapped he will be mapped
                    if(manpWo[women[i][womanpWo[i].counter]].preference ==-1) {//if the woman has not partner yet, she will be matched to this man
                        womanpWo[i].id = i;
                        womanpWo[i].partnerId = women[i][womanpWo[i].counter];
                        womanpWo[i].mapped = 0;
                        womanpWo[i].preference = inverseMen[women[i][womanpWo[i].counter]][i];

                        manpWo[women[i][womanpWo[i].counter]].mapped = 0;
                        manpWo[women[i][womanpWo[i].counter]].partnerId = i;
                        manpWo[women[i][womanpWo[i].counter]].preference = inverseMen[women[i][womanpWo[i].counter]][i];

                        wc++;
                    }
                    else if ((manpWo[women[i][womanpWo[i].counter]].preference !=-1)&&(manpWo[women[i][womanpWo[i].counter]].preference >  inverseMen[women[i][womanpWo[i].counter]][i])){
                        womanpWo[i].id = i;
                        womanpWo[i].partnerId = men[i][womanpWo[i].counter];
                        womanpWo[i].mapped = 0;
                        womanpWo[i].preference = inverseMen[women[i][womanpWo[i].counter]][i];

                        womanpWo[manpWo[women[i][womanpWo[i].counter]].partnerId].mapped = -1;// Since the man releases a woman,
                        // that woman will be released from the current man to which she is mapped

                        manpWo[women[i][womanpWo[i].counter]].mapped = 0;
                        manpWo[women[i][womanpWo[i].counter]].partnerId = i;
                        manpWo[women[i][womanpWo[i].counter]].preference = inverseMen[women[i][womanpWo[i].counter]][i];
                    }
                    womanpWo[i].counter++;
                }
            }
        }
        int count = 0;
        //The below code will check Man Optimal and Woman Optimal Solution will give the same pairs. If we find same pair, we increment the counter
        for (int i = 0; i < n ; i++) {
            if(manp[i].id == womanpWo[manp[i].partnerId].partnerId){
                count++;
            }
        }

        //Finally we print the counter value as output. The counter will give the number people having only one valid partner.
        System.out.println(count);
    }
}
