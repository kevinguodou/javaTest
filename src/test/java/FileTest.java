/**
 * @author dou.guo
 * @version FileTest, v 0.1 2022-10-29 1:06 上午 dou.guo Exp $
 */
public class FileTest {

    public static void main(String[] args) {
        file tt = new file();
        add(tt.getP());
        System.out.println(tt);
    }

    public static void add(pfile tt){
        tt.setA(3);
    }

}
