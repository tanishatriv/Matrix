import java.io.*;
import java.util.*;
public class MatrixData
{
	public static void main(String[] args)
	{
		File name = new File("Matrix.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text,output="";
			while((text=input.readLine())!= null)
			{
				output+=text +"\n";
				String[] arr = text.split("\t");

				int[][] matrix1 = matrixMaker(arr[0]);
				int[][] matrix2 = matrixMaker(arr[1]);

				System.out.println("Matrix 1: ");
				printMatrix(matrix1);
				System.out.println();
				System.out.println("Matrix 2: ");
				printMatrix(matrix2);
				System.out.println();
				System.out.println("Sum: ");
				printMatrix(add(matrix1, matrix2));
				System.out.println();
				System.out.println("Difference: ");
				printMatrix(subtract(matrix1, matrix2));
				System.out.println();
				System.out.println("Product: ");
				printMatrix(multiply(matrix1, matrix2));
				System.out.println();
			}
			System.out.println();
		}
		catch (IOException io){System.err.println("Error reading file => "+io);}
	}


	public static int[][] matrixMaker(String str)
	{
		str = str.replace("},{","_");
		str = str.replace("}","");
		str = str.replace("{","");
		String rows[] = str.split("_");
		int numRows = rows.length;
		int numCol = rows[0].split(",").length;
		int[][] matrix = new int[numRows][numCol];

		for(int i = 0; i < numRows; i++)
		{
			String [] nums = rows[i].split(",");
			for(int j= 0; j<numCol; j++)
			{
				matrix[i][j] = Integer.parseInt(nums[j]);
			}
		}
		return matrix;
	}

	public static void printMatrix(int[][] matrix)
	{
		if(matrix != null)
		{
			for(int i = 0; i < matrix.length; i++)
			{
				for(int j = 0; j < matrix[0].length; j++)
				{
					System.out.print(" " + matrix[i][j] + "\t");
				}
				System.out.println();
			}
		}
		else
		{
			System.out.println("Operation not possible.");
		}
	}

	public static int[][] add(int[][] m1, int[][]m2)
	{
		int d1 = m1.length;
		int d2 = m1[0].length;
		int d3 = m2.length;
		int d4 = m2[0].length;
		int[][] sum = new int[d1][d2];
		if ((d1 == d3) && (d2 == d4))
		{
			for (int i = 0; i < d1; i++)
			{
				for (int j = 0; j < d2; j++)
				{
					sum[i][j] = m1[i][j] + m2[i][j];
				}
		    }
		    return sum;
		}
		else
		{
			return null;
		}
	}

	public static int[][] subtract(int[][] m1, int[][] m2)
	{
		int d1 = m1.length;
		int d2 = m1[0].length;
		int d3 = m2.length;
		int d4 = m2[0].length;
		int[][] difference = new int[d1][d2];
		if ((d1 == d3) && (d2 == d4))
		{
			for (int i = 0; i < d1; i++)
			{
				for (int j = 0; j < d2; j++)
			    {
			    	difference[i][j] = m1[i][j] - m2[i][j];
			    }
			}
			return difference;
		}
		else
		{
			return null;
		}
	}

	public static int[][] multiply(int[][] m1, int[][] m2)
	{
		int d1 = m1.length;
		int d2 = m1[0].length;
		int d3 = m2.length;
		int d4 = m2[0].length;
		 if(d1 == 1 && d2 == 1)
		 {
			int[][] product = new int[d3][d4];
		    for(int i = 0; i < d3; i++)
		    {
		    	for(int j = 0; j < d4; j++)
		        {
		        	product[i][j] = m2[i][j] * m1[0][0];
		        }
		    }
        }
         else if(d3 == 1 && d4 == 1)
         {
		 	int[][] product = new int[d1][d2];
		    for(int i = 0; i < d1; i++)
		    {
		    	for(int j = 0; j < d2; j++)
		    	{
		        	product[i][j] = m1[i][j] * m2[0][0];
		        }
		    }
        }

        if(d2 == d3)
        {
			int[][] product = new int[d1][d4];
			for(int i = 0; i< d1; i++)
		    {
		    	for(int j = 0; j < d4; j++)
		        {
		        	int sum = 0;
		            for(int y = 0; y < d2; y++)
		            {
		            	sum += m1[i][y] * m2[y][j];
		            }
		            product[i][j] = sum;
		         }
			}
		    return product;
        }

        else
        {
			return null;
		}

	}
}