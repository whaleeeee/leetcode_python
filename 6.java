public class Solution
{
    public string Convert(string s, int numRows)
    {
        if (numRows == 1)
            return s;
        StringBuilder strBuilder = new StringBuilder();
        int lengthOfGroup = 2 * numRows - 2;        // 如上图所示，每组的长度为4     
        for (int row = 0; row < numRows; row++)      // 按从第0行到numRows-1行的顺序遍历  
        {
            if (row == 0 || row == numRows - 1)        // 此处负责第0行和numRows-1行
            {
                for (int j = row; j < s.Length; j += lengthOfGroup)
                {
                    strBuilder.Append(s[j]);
                }
            }
            else                   // 此处负责第0行和numRows-1行之间的所有行
            {
                int currentRow = row;           // 在当前行中向右移动（看上图）
                bool flag = true;
                int childLenOfGroup1 = 2 * (numRows - 1 - row);                //  怎么说呢……中间行的各个索引吧
                int childLenOfGroup2 = lengthOfGroup - childLenOfGroup1;

                while (currentRow < s.Length)
                {
                    strBuilder.Append(s[currentRow]);
                    if (flag)
                        currentRow += childLenOfGroup1;
                    else
                        currentRow += childLenOfGroup2;
                    flag = !flag;
                }
            }
        }
        return strBuilder.ToString();
    }
}