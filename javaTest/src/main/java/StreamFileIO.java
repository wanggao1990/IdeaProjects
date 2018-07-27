import java.io.*;


public class StreamFileIO {

    public static void main(String args[]) throws IOException {

        // brread();

        // brreadLines();

      //  System.out.write(new byte[]{-28, 25, 48, 96, 113, 48});

       // fileStreamTest();
       // fileStreamTest2();

      //  createDir();
        dirList();
    }

    ////////////////////////////////////////////////////////////////////////////////

    public static void createDir()
    {
       // String dirname = "/dir1/dir2/dir3";   // 所在盘符根目录
        String dirname = "dir1/dir2/dir3";   // 当前工程目录
        File d = new File(dirname);
        // 现在创建目录
        d.mkdirs();
    }

    public static void dirList()
    {
            String dirname = "E:\\IdeaProjects\\ArtifaceId"   ;
            File f1 = new File(dirname);
            if (f1.isDirectory()) {
                System.out.println( "目录 " + dirname);
                String s[] = f1.list();
                for (int i=0; i < s.length; i++) {
                    File f = new File(dirname + "/" + s[i]);
                    if (f.isDirectory()) {
                        System.out.println(s[i] + " 是一个目录");
                    } else {
                        System.out.println(s[i] + " 是一个文件");
                    }
                }
            } else {
                System.out.println(dirname + " 不是一个目录");
            }
        }

    /////////////////////////////////////////////////////////////////////////////////

    public static void fileStreamTest() {
        try {
            byte bWrite[] = {11, 21, 3, 40, 5};
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");  // 是二进制写入，可能存在乱码
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }

    public static void fileStreamTest2() throws IOException
    {
        File f = new File("a.txt");
        FileOutputStream fop = new FileOutputStream(f);
        // 构建FileOutputStream对象,文件不存在会自动新建
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
        writer.append("中文输入");
        // 写入到缓冲区
        writer.append("\r\n");
        //换行
        writer.append("English");
        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
        writer.close();
        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
        fop.close();
        // 关闭输出流,释放系统资源
        FileInputStream fip = new FileInputStream(f);
        // 构建FileInputStream对象
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        // 构建InputStreamReader对象,编码与写入相同
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
            // 转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        // 关闭读取流
        fip.close();
        // 关闭输入流,释放系统资源
    }


    //////////////////////////////////////////////////////////////////////////////////////

    /**
     *  // 使用 BufferedReader 在控制台读取字符
     */
    public static void brread() throws IOException
    {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != 'q');
    }

    /**
     *  // 使用 BufferedReader 在控制台读取字符串
     */
    public static void  brreadLines() throws IOException
    {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("end"));
    }
}
