package mao.t2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

/**
 * Project name(项目名称)：java并发编程_Fork_Join
 * Package(包名): mao.t2
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/10
 * Time(创建时间)： 13:30
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args)
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Integer result = forkJoinPool.invoke(new AddTask(1, 15));
        log.info("结果：" + result);
    }
}
