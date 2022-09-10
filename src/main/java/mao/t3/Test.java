package mao.t3;

import mao.t2.AddTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

/**
 * Project name(项目名称)：java并发编程_Fork_Join
 * Package(包名): mao.t3
 * Class(类名): Test
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/9/10
 * Time(创建时间)： 13:40
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test
{
    /**
     * 大小
     */
    private static final int size = 50000;

    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(Test.class);

    /**
     * test1
     *
     * @param forkJoinPool 连接池
     */
    private static void test1(ForkJoinPool forkJoinPool)
    {
        long startAll = System.currentTimeMillis();
        for (int i = 0; i < 10; i++)
        {
            long start = System.currentTimeMillis();
            Integer result = forkJoinPool.invoke(new AddTask(1, size));
            long end = System.currentTimeMillis();
            log.info("结果：" + result + ", 花费时间：" + (end - start) + "ms");
        }
        long endAll = System.currentTimeMillis();
        log.info("花费总时间：" + (endAll - startAll) + "ms");
    }

    /**
     * test2
     */
    private static void test2()
    {
        long startAll = System.currentTimeMillis();
        for (int j = 0; j < 10; j++)
        {
            long start = System.currentTimeMillis();
            long total = 0;
            for (int i = 1; i <= size; i++)
            {
                total = total + i;
            }
            long end = System.currentTimeMillis();
            log.info("结果：" + total + ", 花费时间：" + (end - start) + "ms");
        }
        long endAll = System.currentTimeMillis();
        log.info("花费总时间：" + (endAll - startAll) + "ms");
    }

    public static void main(String[] args)
    {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        test1(forkJoinPool);

        test2();
    }

}
