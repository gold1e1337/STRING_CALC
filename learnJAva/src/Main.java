
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String arg = scan.nextLine();
        char act;
        String[] data;
        if(arg.contains(" + ")) {
            data = arg.split("\\+");
            act = '+';
        }else if(arg.contains(" - ")){
            data = arg.split(" - ");
            act = '-';
        }else if(arg.contains(" * ")){
            data = arg.split(" \\* ");
            act = '*';
        }else if(arg.contains(" / ")){
            data = arg.split(" / ");
            act = '/';
        }else{
            throw new Exception("Неверный знак операции! ");
        }
        if(act == '*' || act == '/'){
            if(data[1].contains("\"")) throw new Exception("Строку можно делить и умножать, только на число");
        }
        for(int i = 0; i < data.length;i++){
            data[i] = data[i].replace("\"", "");
        }
        if(act == '+'){
            del(data[0] + data[1]);
        }else if (act == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            del(result);
        }else if (act == '-'){
            int minus = data[0].indexOf(data[1]);
            if(minus == -1){
                del(data[0]);
            }else{
                String res = data[0].substring(minus + data[1].length());
                res += data[0].substring(minus+ data[1].length());
                del(res);
            }
        }else{
            int nee = data[0].length()/Integer.parseInt(data[1]);
            String res = data[0].substring(0,nee);
            del(res);
        }

    }
    static void del(String text){
        System.out.println("\"" + text + "\"");
    }

}













