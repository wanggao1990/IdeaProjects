import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

    public static void main(String args[]) {

        // 初始化 Date 对象
        Date date = new Date();

        // 使用 toString() 函数显示日期时间
        System.out.println(date.toString());

        //  返回1970-01-01 00:00:00 到 此刻的ms数
        System.out.println(date.getTime());

        System.out.println("============================================");

        // 格式化时间
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));

        ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' HH:mm:ss:S zzz");
        System.out.println("Current Date: " + ft.format(dNow));

        System.out.println("============================================");

        // 使用printf格式化日期, 两个字母格式，它以 %t 开头
        //c的使用
        System.out.printf("全部日期和时间信息：%tc%n",date);
        //f的使用
        System.out.printf("年-月-日格式：%tF%n",date);
        //d的使用
        System.out.printf("月/日/年格式：%tD%n",date);
        //r的使用
        System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n",date);
        //t的使用
        System.out.printf("HH:MM:SS格式（24时制）：%tT%n",date);
        //R的使用
        System.out.printf("HH:MM格式（24时制）：%tR%n",date);

        System.out.println("============================================");

        System.out.printf("%tF %tT%n ",date,date);
        System.out.printf("%1$s %2$tB %2$td, %2$tY \n", "Time: ", date);


        System.out.println("============================================");

//        try {
//            long start = System.currentTimeMillis( );           // 计时开始
//
//            System.out.println(new Date( ) + "\n");
//            Thread.sleep(5*60*10);
//            System.out.println(new Date( ) + "\n");
//
//            long end = System.currentTimeMillis( );             // 计时结束
//            long diff = end - start;
//
//            System.out.println("Difference is : " + diff);
//        } catch (Exception e) {
//            System.out.println("Got an exception!");
//        }

        System.out.println("============================================");

        /**
         *   Calendar
         */

        Calendar c1 = Calendar.getInstance();
        //System.out.println(c1 + "\n");
        c1.set(2009, 6 - 1, 12);// 把Calendar对象c1的年月日分别设这为：2009、6、12
        c1.set(Calendar.DATE,10);                   // 把 c1对象代表的日期设置为10号，其它所有的数值会被重新计算
        c1.add(Calendar.DATE, 10);          // 为10天后的日期

        c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);// 获得年份
        int month = c1.get(Calendar.MONTH) + 1;// 获得月份
        int dat = c1.get(Calendar.DATE); // 获得日期
        int hour = c1.get(Calendar.HOUR_OF_DAY);// 获得小时
        int minute = c1.get(Calendar.MINUTE); // 获得分钟
        int second = c1.get(Calendar.SECOND);// 获得秒

        // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
        int day = c1.get(Calendar.DAY_OF_WEEK);

        System.out.println("============================================");

        /**
         *   GregorianCalendar
         */

        String months[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        int yea;
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(yea = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(yea))
            System.out.println("当前年份是闰年");
        else
            System.out.println("当前年份不是闰年");


    }
}
