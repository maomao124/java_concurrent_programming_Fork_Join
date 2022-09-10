package mao.t1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

/**
 * Project name(项目名称)：java并发编程_Fork_Join
 * Package(包名): mao.t1
 * Class(类名): AddTask
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/10
 * Time(创建时间)： 13:07
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AddTask extends RecursiveTask<Integer>
{

    private final int n;

    private static final Logger log = LoggerFactory.getLogger(AddTask.class);

    public AddTask(int n)
    {
        this.n = n;
    }

    @Override
    public String toString()
    {
        return "{" + n + '}';
    }

    @Override
    protected Integer compute()
    {
        if (n == 1)
        {
            log.debug("join " + n);
            return n;
        }
        //不为1
        //拆分
        AddTask t1 = new AddTask(n - 1);
        t1.fork();
        log.debug("fork " + n + " " + t1);

        //合并
        Integer result = t1.join() + n;
        log.debug("join " + n + " " + t1 + " " + result);
        //返回
        return result;
    }
}
