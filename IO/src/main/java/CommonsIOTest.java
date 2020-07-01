import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.util.Collection;

/**  文件大小,各种文件格式过滤  .java  .class  不为空
 * @author: duhao
 * @date: 2020/7/1 22:11
 */
public class CommonsIOTest {
    public static void main(String[] args) {
        // 文件大小
//        long len1 = FileUtils.sizeOf(new File("src/main/java/ContentDecode.java"));
//        System.out.println(len1);
//        //目录大小
//        long len = FileUtils.sizeOf(new File("D:/develop/Java/ideaProjects/MyLearning"));
//        System.out.println(len);
      // 文件过滤
        Collection<File> files = FileUtils.listFiles(new File("D:/develop/Java/ideaProjects/MyLearning"),
                EmptyFileFilter.NOT_EMPTY, // 内容不为空,有空就过滤掉
                null);// 不操作目录
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("--------------------");

           files = FileUtils.listFiles(new File("D:/develop/Java/ideaProjects/MyLearning"),
                EmptyFileFilter.NOT_EMPTY, // 内容不为空,有空就过滤掉
                   DirectoryFileFilter.INSTANCE);// 操作子孙级
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }


        System.out.println("--------------------");

        files = FileUtils.listFiles(new File("D:/develop/Java/ideaProjects/MyLearning"),
                new SuffixFileFilter("java"), // 过滤后缀是 java的
                DirectoryFileFilter.INSTANCE);// 操作子孙级
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }


        System.out.println("--------------------");

        files = FileUtils.listFiles(new File("D:/develop/Java/ideaProjects/MyLearning"),
                FileFilterUtils.or(new SuffixFileFilter("java"),new SuffixFileFilter("class")), // 过滤后缀是 java的的文件和 后缀是class的文件
          //      FileFilterUtils.and(new SuffixFileFilter("java"),EmptyFileFilter.NOT_EMPTY) // 不为空且为java 文件
                DirectoryFileFilter.INSTANCE);// 操作子孙级
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

    }
}
