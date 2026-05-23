class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for (int i=0; i<strs.size(); i++) {
            encodedString += strs.get(i).length() + "#" + strs.get(i);
        }
        return encodedString;
    }

    // "5#Hello"
    public List<String> decode(String str) {
        ArrayList<String> encodedString = new ArrayList();

        int i = 0;
        while(i < str.length()) {
            int j = i;
            int length = 0;
            String subString = "";

            while(str.charAt(j) != '#') {
                j++;
            }
            length = Integer.parseInt(str.substring(i,j));
        
            subString = str.substring(j+1, j + length + 1);
            encodedString.add(subString);
            i = j + subString.length() + 1;
        }

        return encodedString;
    }
}
