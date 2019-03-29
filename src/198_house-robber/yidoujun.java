class Solution(){
//动态规划---打家劫舍
	public int rob(int[] nums) {
		
		//1.获取数组nums的长度
		int len = nums.length;
		//2.首先判断数组nums是否为空，为空返回0，结束方法
		if(len == 0) {
			return 0;
		}
		/*
		 * 3.数组不为空，可以定义一维数组dp[len]
		 *   dp[i]表示到i位置时不相邻数组元素的最大和
		 */
		int[] dp = new int[len];
		//4.如果数组nums只有一个元素，则直接返回这个元素值
		if(len == 1) {
			return nums[0];
		}
		
		int firstNum = Math.max(nums[0], nums[1]);
		if(len == 2) {
			return firstNum;
		}
	
		/*
		 * 5.dp的递推式：dp[i] = Max{dp[i-1], nums[i] + dp[i-2]}  我们需要清楚每一个dp[i]都是最优解
		 * a.到了nums[i]处，我们有两种选择，加进来或不加进来
		 * b.如果放进来，暂时不考虑与dp[i-1]相邻问题，此时dp[i] = nums[i] + dp[i-2]
		 * c.如果不放进来，毫无疑问dp[i] = dp[i-1]
		 * d.到这里，我们需要判断这两个dp[i]谁更大，就选择要不要把nums[i]加进来
		 */
		dp[0] = nums[0];
		dp[1] = firstNum;
		for(int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
			
		}
		return dp[len - 1];
    }
}
