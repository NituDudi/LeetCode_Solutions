class Solution {
public int longestCommonSubsequence(String text1, String text2) {
// Tabulation method -> Assigning meaning to a cell.
int n= text1.length();
int m= text2.length();
if(n == 0 || m == 0) {
return 0;
}
int dp[][]= new int[n+1][m+1];
// dp[i][j] means lcs when len(text1)== i and len(text2)== j
for(int i=1; i< n+1; i++) {
for(int j=1; j< m+1; j++) {
if(i==0 || j==0) {
dp[i][j]= 0;
}
else if(text1.charAt(i-1) == text2.charAt(j-1)) {
dp[i][j]= dp[i-1][j-1] + 1;
}
else {
int ans1= dp[i-1][j];
int ans2= dp[i][j-1];
dp[i][j]= Math.max(ans1, ans2);
}
}
}

return dp[n][m];
}
}

/*
class Solution {
public int longestCommonSubsequence(String text1, String text2) {
//Memoization -> Storing values, avoids calculating same value multiple times
// from large to small problem
int n= text1.length();
int m= text2.length();
if(n== 0 || m==0) {
return 0;
}

int dp[][]= new int[n+1][m+1];
for(int i=0; i< n+1; i++) {
for(int j=0; j< m+1; j++) {
dp[i][j]= -1;
}
}

return lcs(text1, n, text2, m, dp);

}

public int lcs(String text1, int n, String text2, int m, int dp[][]) {
if(n ==0 || m== 0) {
return 0;
}

if(dp[n][m] != -1) {
return dp[n][m];
}
if(text1.charAt(n-1) == text2.charAt(m-1)) {
dp[n][m]= 1 + lcs(text1, n-1, text2, m-1, dp);
}
else {
dp[n][m]= Math.max(lcs(text1, n, text2, m-1, dp), lcs(text1, n-1, text2, m, dp));
}

return dp[n][m];
}
}
*/






/*
class Solution {
public int longestCommonSubsequence(String text1, String text2) {
return lcs(text1, text1.length(), text2, text2.length());       
}

public int lcs(String text1, int n, String text2, int m) {
if(n == 0 || m == 0) {
return 0;
}

if(text1.charAt(n-1) == text2.charAt(m-1)) {
return 1 + lcs(text1, n-1, text2, m-1);
}

else {
int ans1= lcs(text1, n, text2, m-1);
int ans2= lcs(text1, n-1, text2, m);
return Math.max(ans1, ans2);
}
}
}
*/



