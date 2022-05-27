package sql.bookmanagement.operations;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 柒
 * Date: 2022-05-17
 * Time: 10:26
 */
public class ExitOperation implements IOperation{
    @Override
    public void work() {
        System.out.println("程序退出");
        System.exit(0);
    }
}
