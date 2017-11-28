import java.util.ArrayList;
import java.util.Random;

public class Gene
{
    public static ArrayList<int[]> geneCollection = new ArrayList<>();
    private static int[] solution = new int[60];

    private static int[] getRandom()
    {
        int inputNode = 1;
        int[] randomSol = new int[60];
        Random random = new Random();
        while (inputNode <= 15)
        {
            int inputAddress = random.nextInt(59);
            if (randomSol[inputAddress] == 0)
            {
                randomSol[inputAddress] = inputNode;
                inputNode++;
            }
        }
        return randomSol;
    }

    public static void calGeneCollection(int numberGene)
    {
        for (int i = 0; i < numberGene; i++)
        {
            solution = getRandom();
            geneCollection.add(solution);
        }
    }

    public static int calBestSolution(ArrayList<int[]> geneColl)
    {
        double cost = 0;
        double minCost = 0;
        int indexVal = 0;

        minCost = cost;
        for (int i = 0; i < geneColl.size(); i++)
        {
            cost = PathCal.calGeneCost(geneColl.get(i));
            System.out.print("\n");
            if (cost < minCost)
            {
                minCost = cost;
                indexVal = i;
            }
        }
        return indexVal;
    }

    public static void main(String[] args)
    {
        PathCal.initializeCalculator();
        calGeneCollection(10);
        /*for (int i = 0; i < geneCollection.size(); i++)
        {
            for (int j = 0; j < geneCollection.get(i).length; j++)
            {
                System.out.print(geneCollection.get(i)[j] + " ");
            }
            System.out.print("\n");
        }*/

        geneCollection.clear();
        int[] solution1 = {15,13,6,2,14,1,0,0,0,0,0,0,0,0,0,5,7,12,0,0,0,0,0,0,0,0,0,0,0,0,8,4,3,0,0,0,0,0,0,0,0,0,0,0,0,10,11,9,0,0,0,0,0,0,0,0,0,0,0,0};
        geneCollection.add(solution1);
        System.out.println(calBestSolution(geneCollection));
    }
}