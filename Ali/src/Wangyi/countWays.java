package Wangyi;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *  有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
	给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
	测试样例：
	[1,2,4],3,4
	返回：2
 */
public class countWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String info;
		//Scanner input = new Scanner(System.in);
		//info = input.nextLine();
		info = "[1,2,3],3,5";
        //String[] strings = input.nextLine().split("\\[|\\]");
		String regEx = "^\\[([0-9,]+)\\],([0-9]),([0-9])$";
	    // 编译正则表达式
	    Pattern pattern = Pattern.compile(regEx);
	    Matcher matcher = pattern.matcher(info);
	    if(matcher.find()){
	    	int length = Integer.valueOf(matcher.group(2));
	    	int aim  = Integer.valueOf(matcher.group(3));
	    	int penny[]  =  new int[length];
	    	int i=0;
	    	pattern  = Pattern.compile("\\d+");
	    	matcher  = pattern.matcher(matcher.group(1));
	    	while(matcher.find()){
		    	penny[i++]  =  Integer.valueOf(matcher.group());
	    	}
	    	System.out.println(countWay(penny, aim));
	    	//System.out.println(advancedCountWay(penny, aim));
	    	//System.out.println(AcountWays(penny,penny.length,aim));
	    }
        
        //System.out.println(countWay(penny, aim));
	}
	public static int countWay(int[] penny, int aim){
		if(penny.length == 0) return 0;
		int[][] dp = new int[penny.length][aim+1];
		int i=0,j=0;
		while(i<penny.length){
			dp[i++][0] = 1;
		}
		for(i=1;i*penny[0]<=aim;i++){
			dp[0][penny[0]*i] = 1;
		}
		breath(dp);
		for(i=1;i<penny.length;i++){
			for(j=0;j<=aim;j++){
				dp[i][j] = (j>=penny[i])? dp[i][j-penny[i]]+dp[i-1][j] : dp[i-1][j];
				breath(dp);
			}
		}
		return dp[penny.length-1][aim];
	}
	public static void breath(int[][] dp){
		for(int i=0,j=0;i<dp.length;i++){
			for(j=0;j<dp[i].length;j++)
				System.out.format("%2d ", dp[i][j]);
			System.out.println();
		}
		System.out.println("---------------------------");
				
	}
	public static void breath(int[] dp){
		for(int i=0,j=0;i<dp.length;i++){
			System.out.format("%2d ", dp[i]);
			//System.out.println();
		}
		System.out.println();
				
	}
	public static int advancedCountWay(int[] penny, int aim){
		int[] dp = new int[aim+1];
		int i=0,j=0;
		for(;i*penny[0]<=aim;i++){
			dp[i*penny[0]] = 1;
		}
		breath(dp);
		for(i=0;i<penny.length;i++){
			for(j=aim;j>=penny[i];j--){
				dp[j] = dp[j-penny[i]]+dp[j];
				breath(dp);
				//System.out.println("i:"+i+" j:"+j+" penny[i]:"+penny[i]+" dp[i]:"+dp[i]+" dp[j-penny[i]]:"+dp[j-penny[i]]);
				//dp[j]表示要凑足j的金额时最多的方法数量，dp[j-penny[i]]表示使用一次面值penny[i]时的最大方法数
			}
		}
		return dp[aim];
	}
	 public static int AcountWays(int[] penny, int n, int aim) {  
	        // write code here  
	    if(n==0||penny==null||aim<0){  
	     return 0;     
	    }  
	    int[][] pd = new int[n][aim+1];  
	    for(int i=0;i<n;i++){  
	     pd[i][0] = 1;     
	    }  
	    for(int i=1;penny[0]*i<=aim;i++){  
	     pd[0][penny[0]*i] = 1;     
	    }  
	    for(int i=1;i<n;i++){  
	        for(int j=0;j<=aim;j++){  
	            if(j>=penny[i]){  
	                pd[i][j] = pd[i-1][j]+pd[i][j-penny[i]];  
	            }else{  
	                pd[i][j] = pd[i-1][j];  
	            }  
	        }  
	    }  
	    return pd[n-1][aim];  
	}
	public static void breath(boolean[][] dp) {
		// TODO Auto-generated method stub
		for(int i=0,j=0;i<dp.length;i++){
			for(j=0;j<dp[i].length;j++)
				System.out.print((dp[i][j])? 1+" ":0+" ");
			System.out.println();
		}
		System.out.println("---------------------------");
	}  
}
