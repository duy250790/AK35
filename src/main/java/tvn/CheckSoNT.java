package tvn;

public class CheckSoNT {
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
