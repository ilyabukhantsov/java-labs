class CountSuperPrimeNumbers {

    public int countSuperPrime(int number){

        int answer = 0;
        
        if (number > 1000) {
            throw new IllegalArgumentException("Number should be less than 1000");
        } else if (number <= 0 ){
            throw new IllegalArgumentException("Number should be positive");
        }

        for (int correctNumber = 0; correctNumber <= number; correctNumber++){
            int reversedNumber = reverseNumber(correctNumber);
            if (isNumberPrime(correctNumber) && isNumberPrime(reversedNumber)){
                answer++;
            }
        } 

        return answer;

    }

    private boolean isNumberPrime(int number){
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        int boundary = (int) Math.sqrt(number);
        for (int i = 3; i <= boundary; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int reverseNumber(int number){
        int reversed = Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
        return reversed;
    }

}
