package tvn;

public class App {
    public int sum (int a, int b){
        return a + b;
    }

    public int sub (int a, int b){
        return a - b;
    }

    public int mul (int a, int b){
        return a * b;
    }

    public int div (int a, int b){
        return a / b;
    }

    public boolean kiemTraSoChan(int a){
        if (a % 2 == 0 ){
            return true;
        }else return false;
    }

    public boolean kiemTraSoNT(int x){
        int count = 0;
        for (int i = 1; i < x ; i ++){
            if (x % i == 0){
                count++;
            }
        }
        if (x < 2){
            return false;
        }
        else {
            if (count > 1){
                return false;
            }
            else return true;
        }

    }

}
