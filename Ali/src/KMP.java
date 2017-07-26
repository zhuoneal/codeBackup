/** 
* @author ZYJ 
* @version 创建时间：Jul 25, 2017 12:36:02 AM 
* @Details 
*/
public class KMP {
	public static void makeNext(char P[],int next[])
	{
	    int q,k;//q:模版字符串下标；k:最大前后缀长度
	    int m = P.length;//模版字符串长度
	    next[0] = 0;//模版字符串的第一个字符的最大前后缀长度为0
	    for (q = 1,k = 0; q < m; ++q)//for循环，从第二个字符开始，依次计算每一个字符对应的next值
	    {
	        while(k > 0 && P[q] != P[k])//递归的求出P[0]···P[q]的最大的相同的前后缀长度k
	            k = next[k-1];          //不理解没关系看下面的分析，这个while循环是整段代码的精髓所在，确实不好理解  
	        if (P[q] == P[k])//如果相等，那么最大相同前后缀长度加1
	        {
	            k++;
	        }
	        next[q] = k;
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}