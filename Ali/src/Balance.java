import java.util.Arrays;
import java.util.Scanner;

public class Balance {

	public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int maxQps= Integer.valueOf(in.nextLine());
		final String[] rtList = in.nextLine().split(",");
		final int requestNum = Integer.valueOf(in.nextLine());
		final int threadNum = Integer.valueOf(in.nextLine());
		System.out.println(doneTime(maxQps, rtList, requestNum, threadNum));
	}
	/**
	 * 如果使用最优的最大吞吐量负载均衡算法，按照最优模型多久能够处理完所有请求，单位毫秒。
	 * @return
	 */
	static long doneTime(int maxQps,String[] rtList,int requestNum,int threadNum) {
		//TODO
		int num= rtList.length;
		int[] rtl = new int[num];
		
		for(int i=0;i<num;i++){//型
			rtl[i] = Integer.parseInt(rtList[i]);
			
		}
		Arrays.sort(rtl);
		System.out.println(Arrays.toString(rtl));
		int[] th = new int[threadNum];
		int sum=0;
		for(int j=0;j<threadNum;j++){
			sum+=rtl[j];
		}
		System.out.println(sum);
		long time = 0;
		float qps = 0;
		for(int k=0;k<threadNum;k++){
			qps = (long)requestNum*((float)rtl[k]/sum);
			if(qps>maxQps) qps = maxQps;
			requestNum-=qps;
			System.out.println(qps);
			time=Math.max(time, (long)qps*rtl[k]);
		}
		return time;
	}
}