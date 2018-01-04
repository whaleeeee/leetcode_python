public static String convert(String s, int nRows) {  
    if (nRows <= 0)  
        return "";  
    if (nRows == 1 || nRows >= s.length())  
        return s;  
    StringBuffer buffer = new StringBuffer();  
    int len = s.length();  
    for (int i = 0; i < len && i < nRows; ++i) {  
        // 在字符串中的变化的位置  
        int start = i;  
        buffer.append(s.charAt(start));  
        for (int j = 1; start < len; ++j) {  
            // 第一行和最后一行  
            if (i == 0 || i == nRows - 1) {  
                start = start + 2 * nRows - 2;  
            } else {  
                // 对于中间行，在字符串中位置为基数时  
                if (j % 2 == 1) {  
                    start = start + 2 * (nRows - i - 1);  
                } else {  
                    // 位置为偶数时  
                    start = start + 2 * i;  
                }  
            }  
            // 边界判断  
            if (start < len)  
                buffer.append(s.charAt(start));  
        }  
    }  
    return buffer.toString();  
}  