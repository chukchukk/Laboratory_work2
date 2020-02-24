import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrEnd[] = new int[4];
        int[] arrNominal=new int[4];
        System.out.print("Введите количество купюр в банке (1000, 500, 100, 30):\n");
        for(int i=0;i<4;i++)
            arrNominal[i]=in.nextInt();
        System.out.println();
        int sum = arrNominal[0] * 1000 + arrNominal[1] * 500 + arrNominal[2] * 100 + arrNominal[3] * 30;
        //arrNominal[0] - 1000, arrNominal[1] - 500, arrNominal[2] - 100, arrNominal[3] - 30
        System.out.println("Сумма для снятия:");
        int sumSTRH = in.nextInt();
        if(sumSTRH % 10 !=0) {
            System.out.print("Невозможно выдать введенную сумму купюрами предложенного номинала.");
            return;
        }
        else  if (sumSTRH > sum){
            System.out.println("К сожалению, в банкомате недостаточно купюр для выдачи.");
            return;
        }
        else {
            //Сначала избавимся от купюр с номиналом 30
            while (sumSTRH % 100 != 0 && sumSTRH > 0 && arrNominal[3] > 0) {
                sumSTRH -= 30;
                arrNominal[3]--;
                arrEnd[3]++;
            }
            //А дальше подсчет купюр с наибольним номиналом
            while (arrNominal[0] > 0 && sumSTRH - 1000 >= 0) {
                sumSTRH -= 1000;
                arrNominal[0]--;
                arrEnd[0]++;
            }
            while (arrNominal[1] > 0 && sumSTRH - 500 >= 0) {
                sumSTRH -= 500;
                arrNominal[1]--;
                arrEnd[1]++;
            }
            while (arrNominal[2] > 0 && sumSTRH - 100 >= 0) {
                sumSTRH -= 100;
                arrNominal[2]--;
                arrEnd[2]++;
            }
            if (sumSTRH == 0) {
                System.out.print(arrEnd[0] + ": 1000-рублевых купюр; " + arrEnd[1] + ": 500-рублевых купюр; " + arrEnd[2] + ": 100-рублевых купюр; " + arrEnd[3] + ": 30-рублевых купюр.");
            }
            else
                System.out.println("Невозможно выдать введенную сумму.");
        }
    }
}