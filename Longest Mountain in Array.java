class Solution {
    public int longestMountain(int[] arr) {
        int len=arr.length;
        int[] LIS=new int[len];
        int[] LDS=new int[len];
		int res=0;
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        for(int i=1;i<len;i++)
        {
                if(arr[i-1]<arr[i])
                {
                    LIS[i]=Math.max(LIS[i], 1+LIS[i-1]);
                }

        }
        for(int i=len-2;i>=0;i--)
        {
                if(arr[i+1]<arr[i])
                {
                    LDS[i]=Math.max(LDS[i], 1+LDS[i+1]);
                }
        }
        for(int i=0;i<len-1;i++)
        {
            if(LIS[i]>1 && LDS[i]>1)
            {
                res=Math.max(res, LIS[i]+LDS[i]-1);
            }
        }
        return res;
    }
}