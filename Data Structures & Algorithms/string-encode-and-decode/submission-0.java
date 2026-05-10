class Solution {

    public String encode(List<String> strs) {

        StringBuilder enc = new StringBuilder();
        int len = 0;
        for(String s:strs)
        {
            len = s.length();
            enc.append(len);
            enc.append("#");
            enc.append(s);
        }

        return enc.toString();
    }

    public List<String> decode(String str) {
        List<String> dec = new ArrayList<>();
        int i = 0;

        while(i<str.length())
        {
            int j = i;
            while(str.charAt(j) != '#')
            {
                j++;
            }

            int length = Integer.parseInt(str.substring(i,j));
            String word =  str.substring(j+1,j+length+1);

            dec.add(word);
            i = j+length+1;
        }
        return dec;
    }
}
