package mao.t2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RecursiveTask;

/**
 * Project name(项目名称)：java并发编程_Fork_Join
 * Package(包名): mao.t2
 * Class(类名): AddTask
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/10
 * Time(创建时间)： 13:22
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class AddTask extends RecursiveTask<Integer>
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(AddTask.class);

    /**
     * 开始
     */
    int begin;
    /**
     * 结束
     */
    int end;


    /**
     * 添加任务
     *
     * @param begin 开始
     * @param end   结束
     */
    public AddTask(int begin, int end)
    {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public String toString()
    {
        return "{" + begin + "," + end + '}';
    }


    /**
     * 计算
     *
     * @return {@link Integer}
     */
    @Override
    protected Integer compute()
    {
        if (begin == end)
        {
            log.debug("join " + begin);
            return begin;
        }
        if (begin == end - 1)
        {
            int result = begin + end;
            log.debug("join " + begin + " " + end + " " + result);
            return result;
        }

        //中间
        int m = (begin + end) / 2;
        AddTask addTaskLeft = new AddTask(begin, m);
        AddTask addTaskRight = new AddTask(m + 1, end);
        addTaskLeft.fork();
        addTaskRight.fork();
        log.debug("fork " + addTaskLeft + "    " + addTaskRight);
        int result = addTaskLeft.join() + addTaskRight.join();
        log.debug("join  " + addTaskLeft + "    " + addTaskRight + "    " + result);
        return result;
    }
}
