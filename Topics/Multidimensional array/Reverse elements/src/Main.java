class ArrayOperations {
    public static void reverseElements(int[][] twoDimArray) {
        int temp;
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length / 2; j++) {
                temp = twoDimArray[i][j];
                twoDimArray[i][j] = twoDimArray[i][twoDimArray[i].length - 1 - j];
                twoDimArray[i][twoDimArray[i].length - 1 - j] = temp;
            }
        }
    }
}
